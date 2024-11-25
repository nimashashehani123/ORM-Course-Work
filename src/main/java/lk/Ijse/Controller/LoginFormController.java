package lk.Ijse.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.Ijse.Utill.PasswordVerifier;
import lk.Ijse.bo.BoFactory;
import lk.Ijse.bo.custom.UserBo;
import lk.Ijse.bo.custom.impl.UserBoImpl;
import lk.Ijse.dto.UserDTO;
import lk.Ijse.entity.User;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane loginform;

    @FXML
    private JFXTextField txtPassword1;

    @FXML
    private JFXPasswordField txtPassword2;

    @FXML
    private JFXTextField txtUsername;
    UserBo userBO = (UserBoImpl) BoFactory.getBoFactory().getBo(BoFactory.BoType.User);

    @FXML
    void btnLogInOnAction(ActionEvent event) throws Exception {
        String username  = txtUsername.getText().trim();
        String password = txtPassword1.getText().trim();
        User userByname = userBO.findUserByname(username);
        String userid;
        String role;
        int x ;

        if (userByname != null) {
            userid = userByname.getUserid();
            role = userByname.getRole();
            String password1 = userByname.getPassword();
            if (PasswordVerifier.verifyPassword(password,password1)){
                if(role.equals("admin")){
                    x = 1;
                    navigateToTheDashboard(x,userid);
                }else {
                    x = 0;
                    navigateToTheDashboard(x,userid);
                }

            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid password! Please try again.").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Username does not exist! Please check your username.").show();
        }
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUpForm.fxml"));
            AnchorPane coursesPane = loader.load();
            loginform.getChildren().setAll(coursesPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showPasswordOnMousePresseds(MouseEvent event) {
        txtPassword2.setVisible(false);
        txtPassword1.setText(txtPassword2.getText());
        txtPassword1.setVisible(true);
    }

    @FXML
    void showPasswordOnMouseReleased(MouseEvent event) {
        txtPassword2.setVisible(true);
        txtPassword1.setVisible(false);
    }

    private void navigateToTheDashboard(int role,String userid) throws IOException {
        loginform.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
        Parent root = loader.load();
        DashboardController dashboardController = loader.getController();

        dashboardController.setRole(role);
        dashboardController.setUserid(userid);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();
    }

}
