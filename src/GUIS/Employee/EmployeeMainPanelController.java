/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS.Employee;

import Classes.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class EmployeeMainPanelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    User u = null;
    @FXML
    private Label bannerLabel;
    String []splitter = new String[2];
    public void userInfo(User u1){
        this.u = u1;
        splitter = u1.getName().split(":");
        bannerLabel.setText("Wellcome " + splitter[0] + "!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void slalaryButtonOnClick(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Salary.fxml"));
        Parent employee = loader.load();

        Scene employeeScene = new Scene(employee);

        SalaryController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(employeeScene);
        customerWindow.show();
    }
    

    @FXML
    private void notificationsButtonOnClick(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Notifications.fxml"));
        Parent nextParent = loader.load();

        Scene nextScene = new Scene(nextParent);

        NotificationsController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(nextScene);
        customerWindow.show();
    }

    @FXML
    private void reqLeaveButtonOnClick(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LeaveRequest.fxml"));
        Parent employee = loader.load();

        Scene employeeScene = new Scene(employee);

        LeaveRequestController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(employeeScene);
        customerWindow.show();
    }

    @FXML
    private void settingsButtonOnClick(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Settings.fxml"));
        Parent nextParent = loader.load();

        Scene nextScene = new Scene(nextParent);

        SettingsController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(nextScene);
        customerWindow.show();
    }

    @FXML
    private void reportButtonOnClick(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ReportAccount.fxml"));
        Parent nextParent = loader.load();

        Scene nextScene = new Scene(nextParent);

        ReportAccountController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(nextScene);
        customerWindow.show();
    }

    @FXML
    private void signOutButtonOnClick(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/footballfederation/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
}
