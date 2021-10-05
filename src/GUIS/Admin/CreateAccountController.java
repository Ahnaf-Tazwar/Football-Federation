/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS.Admin;

import Classes.Admin;
import Classes.Employee;
import Classes.User;
import GUIS.Employee.EmployeeMainPanelController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AhNAF TAzWAR
 */
public class CreateAccountController implements Initializable {

    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private RadioButton maileRadio;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private RadioButton transgenderRadio;
    @FXML
    private CheckBox addCardCB;
    @FXML
    private TextField cardNo1;
    @FXML
    private TextField cardNo2;
    @FXML
    private TextField cardNo3;
    @FXML
    private TextField cardNo4;
    @FXML
    private DatePicker dobDP;
    @FXML
    private ComboBox countiesCombo;
    @FXML
    private ComboBox accTypeCombo;
    @FXML
    private TextField passTF;
    @FXML
    private TextField contactNo;
    @FXML
    private TextField setIDTF;

    User u;
    public void userInfo(User u1){
        this.u = u1;    
    }
    
    /**
     * Initializes the controller class.
     */
    ObservableList<String> accountTypes = FXCollections.observableArrayList("Admin", "Employee", "Team Manager", "Customer",
            "Share Holder");

    ObservableList<String> countries = FXCollections.observableArrayList("Bangladesh", "India", "Pakistan", "Nepal",
            "China", "Japan", "Germany", "Italy", "France", "Belgium", "Taiwan", "Korea", "USA", "Uruguway",
            "Sweden", "Norway", "Netherland", "Australia");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accTypeCombo.setItems(accountTypes);
        countiesCombo.setItems(countries);

    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminMainPanel.fxml"));
        Parent employee = loader.load();

        Scene employeeScene = new Scene(employee);

        AdminMainPanelController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(employeeScene);
        customerWindow.show();
    }

    @FXML
    private void addAccButtonOnClick(ActionEvent event) {
        String acc = "";
        char gender = 'M';
        String cardN = "";
        LocalDate ld = dobDP.getValue();
        String dateee = ld.toString();
        int idNumber;

        if (maileRadio.isSelected()) {
            gender = 'M';
        } else if (femaleRadio.isSelected()) {
            gender = 'F';
        } else if (transgenderRadio.isSelected()) {
            gender = 'T';
        }
        if (addCardCB.isSelected()) {
            cardN = cardNo1.getText() + "-" + cardNo2.getText() + "-" + cardNo3.getText() + "-" + cardNo4.getText();
        }

        if (accTypeCombo.getSelectionModel().getSelectedItem().toString().equals("Admin")) {
            Admin a = new Admin();
            idNumber = 10000;
            idNumber = idNumber + Integer.valueOf(setIDTF.getText());

            a.createAcc(firstNameTF.getText() + ":" + lastNameTF.getText(), gender, ld, '1',
                    countiesCombo.getSelectionModel().getSelectedItem().toString(), cardN, emailTF.getText(), "1234", idNumber);
        } else if (accTypeCombo.getSelectionModel().getSelectedItem().toString().equals("Employee")) {

            idNumber = 20000;
            idNumber = idNumber + Integer.valueOf(setIDTF.getText());

            Admin a = new Admin();
            a.createAcc(firstNameTF.getText() + ":" + lastNameTF.getText(), gender, ld, '2',
                    countiesCombo.getSelectionModel().getSelectedItem().toString(), cardN, emailTF.getText(), "1234", idNumber);

        } else if (accTypeCombo.getSelectionModel().getSelectedItem().toString().equals("Team Manager")) {

        } else if (accTypeCombo.getSelectionModel().getSelectedItem().toString().equals("Customer")) {

        } else if (accTypeCombo.getSelectionModel().getSelectedItem().toString().equals("Share Holder")) {

        }
    }

}
