/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS.Employee;

import Classes.User;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AhNAF TAzWAR
 */
public class SalaryController implements Initializable {

    @FXML
    private Label molnthlyLabel;
    @FXML
    private Label yearlyLabel;
    @FXML
    private Label bonusLabel;

    /**
     * Initializes the controller class.
     */
    
    User u;
    public void userInfo(User u1){
        this.u = u1;
        salaryChecker(u.getId());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EmployeeMainPanel.fxml"));
        Parent employee = loader.load();

        Scene employeeScene = new Scene(employee);

        EmployeeMainPanelController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(employeeScene);
        customerWindow.show();
    }

    private void salaryChecker(int id){
        File f = new File ("Salaries.txt");
        Scanner sc;
        BufferedReader bos;
        String s = "";
        String []contentSplitter = new String [3];
        if (f.exists()){
            try{
                sc = new Scanner (f);
                //bos = new BufferedReader(new FileReader("Salaries.txt"));
                while(sc.hasNext()){
                    contentSplitter = sc.nextLine().split(":");
                    //System.out.println(Integer.valueOf("File ID: " + contentSplitter[0] + "__Method ID:" + id));
                    System.out.println("File ID: " + Integer.valueOf(contentSplitter[0]));
                    System.out.println("Method ID: " + id);
                    if (Integer.valueOf(contentSplitter[0]) == id){
                        contentSplitter = sc.nextLine().split(":");
                        s+= sc.nextLine();
                        System.out.println("______");
                        molnthlyLabel.setText(contentSplitter[1] + "BDT");
                    break;
                    }
                }
                System.out.println(s);
            }
            catch(Exception e){
                //System.out.println("There was an exception while reading the file: " + e);
            }
    }
        else{
            System.out.println("File not found!");
        }
    }
    
}
