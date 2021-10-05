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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AhNAF TAzWAR
 */
public class BanAccountController implements Initializable {

    @FXML
    private TextField accIDTF;
    @FXML
    private ComboBox<?> accTypeCombo;
    @FXML
    private TextArea reasonTA;

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
    private void banAccButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void backButtonOnClick(ActionEvent event)throws IOException {
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
    
}
