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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AhNAF TAzWAR
 */
public class ReportController implements Initializable {

    @FXML
    private TableView<?> reasonTable;
    @FXML
    private TableColumn<?, ?> nameTC;
    @FXML
    private TableColumn<?, ?> accIDTC;
    @FXML
    private TableColumn<?, ?> accTypeTC;

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
    private void reasonButtonOnClick(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reason.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}
