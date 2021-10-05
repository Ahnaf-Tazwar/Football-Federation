/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballfederation;

import Classes.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author AhNAF TAzWAR
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label showLabel;
    ArrayList<User> userList = new ArrayList<User>();
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        readUsers();
        //ArrayList<User> u = readUsers();
        String s = "";
        String [] splitter; 
        for (User u1: userList){
            s += u1.getId()+ "____" + u1.getPass() + "_____" + u1.getName() + "\n";
        }
        showLabel.setText(s);
        //readUsers();
    }
    
    @FXML
    private void adminButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/GUIS/Admin/AdminMainPanel.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    private void employeeButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/GUIS/Employee/EmployeeMainPanel.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    private void shareHolderButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/GUIS/ShareHolder/ShareHolderMainPanel.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    private void teamManagerButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/GUIS/TeamManager/TeamManager.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    private void customerButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/GUIS/Admin/AdminMainPanel.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void signInButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void registerButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void highlightsButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Highlights.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void galleryButtonOnClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Gallery.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
    private void readUsers() {
        //ArrayList<User> userList = new ArrayList<User>();
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
                while (true) {
                    u = (User)ois.readObject();
                    userList.add(u);
                    System.out.println(u.getId());
                }
            }

        } catch (Exception e) {
            System.out.println("Exception found: " + e);
        }
            finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) {
                }
            }
            } 
        //return userList;
    }

