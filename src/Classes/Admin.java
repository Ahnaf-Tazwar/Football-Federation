/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author AhNAF TAzWAR
 */
public class Admin extends User implements Serializable {

    
    public Admin(){}
    public Admin(String name, String pass, String email, String country, String cardNo,
            boolean isBanned, int id, char gender, String dob) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.contactNo = email;
        this.cardNo = cardNo;
        this.isBanned = isBanned;
        this.dob = dob;

    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }
    
    
    
    
    public void createAcc(String name, char gender, LocalDate dob, char accType, String country, String cardNo,
            String email, String pass, int idNo) {

        String dOB = dob.toString();

        User u = null;
        if (accType == '1') {
            u = new Admin(name, pass, email, country, cardNo, false, idNo, gender, dOB);
            writeBinFile(u);
        } else if (accType == '2') {
            u = new Employee (name, pass, email, country, cardNo,
            false , idNo, gender, dOB);
            writeBinFile(u);

        } else if (accType == '3') {

        } else if (accType == '4') {

        } else if (accType == '5') {

        }
        System.out.println(u.id + "_____" + u.name + "_____" + u.name);
        if (u instanceof Admin) System.out.println("_____Admin");
        else if (u instanceof Employee) System.out.println("_____Employee");

    }

    public boolean deleteAcc(int id) {
        User tempUser = accFinder(id);
        if (tempUser != null) {
            File f = new File("Users.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            ArrayList<User> userList = readUsers();
            try {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

                for (User u1 : userList) {
                    if (u1.id == tempUser.id) {
                        continue;
                    }
                    oos.writeObject(u1);
                }
                

            } catch (IOException ex) {
                System.out.println("There was IO Exception: " + ex);
            } finally {
                try {
                    oos.flush();
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("There was IO Exception: " + ex);
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    boolean isBanned(int id, String pass) {
        User editUser = accFinder(id);
        if (editUser != null) {
            editUser.isBanned = true;
            editBinFile(editUser);
            return true;
        } else {
            return false;
        }
    }

    boolean banAcc(int id) {
        User editUser = accFinder(id);
        if (editUser != null) {
            editUser.isBanned = true;
            editBinFile(editUser);
            return true;
        } else {
            return false;
        }
    }

    private User accFinder(int id) {
        ArrayList<User> userList = readUsers();
        User returnUser = null;
        for (User u : userList) {
            if (u.id == id) {
                returnUser = u;
                break;
            }
        }
        return returnUser;
    }

    void writeBinFile(User u) {
        File f = new File("Users.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(u);

        } catch (IOException ex) {
            System.out.println("There was IO Exception: " + ex);
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                System.out.println("There was IO Exception: " + ex);
            }

        }
    }

    private void editBinFile(User u) {
        ArrayList<User> userList = readUsers();
        File f = new File("Users.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

            for (User u1 : userList) {
                if (u1.id == u.id) {
                    continue;
                }
                oos.writeObject(u1);
            }
            oos.writeObject(u);

        } catch (IOException ex) {
            System.out.println("There was IO Exception: " + ex);
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                System.out.println("There was IO Exception: " + ex);
            }
        }

    }

    private ArrayList<User> readUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        File f = new File("Users.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            if (!f.exists()) {
                System.out.println("Unable to find/ locate file");
            } else {
                User u = null;
                while ((u = (User) ois.readObject()) != null) {
                    userList.add(u);
                }
            }

        } catch (IOException ex) {
            System.out.println("There was IO Exception: " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Unable to find Class: " + ex);
        }
        return userList;
    }

    /*
    private void writeObjectsBinFile(ArrayList<User> u) {
        File f = new File("Users.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            for (User u1 : u) {
                oos.writeObject(u);
            }

        } catch (IOException ex) {
            System.out.println("There was IO Exception: " + ex);
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                System.out.println("There was IO Exception: " + ex);
            }
        }
    }*/
}
