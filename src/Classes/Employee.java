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
import java.util.ArrayList;

/**
 *
 * @author AhNAF TAzWAR
 */
public class Employee extends User implements Serializable {
    //String employeeType; float salary;
    
    public Employee(String name, String pass, String email, String country, String cardNo,
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

    public Employee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean isBanned(int id, String pass) {
        System.out.println("Do Nothing");
        return false;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }
    
    
    
    public void changeAccSettings(int id, String pass){
        ArrayList<User> tempUser = readUsers();
        User u = null;
        for (User u1 : tempUser){
            if (u1.id == id){
                u = u1;
            }
        }
        u.pass = pass;
        
        tempUser.add(u);
        writeObjectsBinFile(tempUser);
        
    }
    
    public float checkSalary(int id, String pass){
        Employee u = (Employee)accFinder(id);
        
        //return u.salary - 1.0f;
        return 1.0f;
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
}
