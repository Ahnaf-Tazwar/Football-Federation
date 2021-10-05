/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballfederation;

import Classes.Admin;
import Classes.Employee;
import Classes.User;
import GUIS.Admin.AdminMainPanelController;
import GUIS.Employee.EmployeeMainPanelController;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AhNAF TAzWAR
 */
public class SignInController implements Initializable {

    @FXML
    private TextField idTF;
    @FXML
    private PasswordField passTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void siignInButtonOnClick(ActionEvent event) throws IOException {
        int idNo = Integer.valueOf(idTF.getText());
        String password = passTF.getText().toString();
        User u;
        u = findUser(idNo, password);

        if (u instanceof Employee) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUIS/Employee/EmployeeMainPanel.fxml"));
            Parent employee = loader.load();

            Scene employeeScene = new Scene(employee);

            EmployeeMainPanelController controller = loader.getController();
            controller.userInfo(u);

            Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            customerWindow.setScene(employeeScene);
            customerWindow.show();
        } else if (u instanceof Admin) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUIS/Admin/AdminMainPanel.fxml"));
            Parent admin = (Parent) loader.load();

            Scene adminScene = new Scene(admin);

            AdminMainPanelController controller = loader.getController();
            controller.userInfo((Admin) u);

            Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            customerWindow.setScene(adminScene);
            customerWindow.show();

            /*Parent root = FXMLLoader.load(getClass().getResource("/GUIS/Admin/AdminMainPanel.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();*/

        } else if (idTF.getText().charAt(0) == '3') {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUIS/ShareHolder/ShareHolderMainPanel.fxml"));
            Parent admin = (Parent) loader.load();

            Scene adminScene = new Scene(admin);

            //AdminMainPanelController controller = loader.getController();
            //controller.userInfo((Admin)u);
            Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            customerWindow.setScene(adminScene);
            customerWindow.show();

        } else if (idTF.getText().charAt(0) == '4') {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUIS/TeamManager/TeamManager.fxml"));
            Parent admin = (Parent) loader.load();

            Scene adminScene = new Scene(admin);

            //AdminMainPanelController controller = loader.getController();
            //controller.userInfo((Admin)u);
            Stage customerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            customerWindow.setScene(adminScene);
            customerWindow.show();

        } else if (u == null) {
            System.out.println("Invalid username or password!");
        }

    }

    private User findUser(int iDNo, String passw) {
        User user = null;
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
                    u = (User) ois.readObject();
                    //System.out.println(u.getId() + "---------" + u.getPass());
                    if (u instanceof Admin) {
                        if (u.getId() == iDNo && passw.equals(u.getPass())) {
                            user = (Admin) u;
                            break;
                        }
                        continue;
                    } else if (u instanceof Employee) {
                        if (u.getId() == iDNo && passw.equals(u.getPass())) {
                            user = (Employee) u;
                            break;
                        }
                        continue;
                    }
                    System.out.println(u);

                }
                //ois.close();
            }

        } catch (IOException ex) {
            System.out.println("There was IO Exception: " + ex);
        } catch (Exception ex) {
            System.out.println("Unable to find Class: " + ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return user;
    }
}
