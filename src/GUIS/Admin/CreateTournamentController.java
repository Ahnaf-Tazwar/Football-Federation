/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS.Admin;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AhNAF TAzWAR
 */
public class CreateTournamentController implements Initializable {

    @FXML
    private TextField tNameTF;
    @FXML
    private TextField tIDTF;
    @FXML
    private DatePicker startDP;
    @FXML
    private DatePicker endDP;
    @FXML
    private DatePicker regDeadlineDP;

    /**
     * Initializes the controller class.
     */
    User u;
    public void userInfo(User u1){
        this.u = u1;    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void backsButtonOnClick(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminMainPanel.fxml"));
        Parent nextFXML = loader.load();

        Scene nextScene = new Scene(nextFXML);

        AdminMainPanelController controller = loader.getController();
        controller.userInfo(u);

        Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customerWindow.setScene(nextScene);
        customerWindow.show();
    }

    @FXML
    private void createTournamentButtonOnClick(ActionEvent event) {
    }
}
