package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.Utill.PasswordEncrypt;
import lk.Ijse.Utill.PasswordVerifier;
import lk.Ijse.bo.BoFactory;
import lk.Ijse.bo.custom.UserBo;
import lk.Ijse.bo.custom.impl.UserBoImpl;
import lk.Ijse.dto.UserDTO;
import lk.Ijse.entity.User;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController{

    @FXML
    private JFXButton btnchange;

    @FXML
    private JFXButton btnclear;

    @FXML
    private AnchorPane profileform;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtnewpassword;

    @FXML
    private JFXPasswordField txtnewpassword1;

    @FXML
    private JFXTextField txtpassword;

    @FXML
    private JFXPasswordField txtpassword1;

    @FXML
    private JFXTextField txtrole;

    @FXML
    private JFXTextField txtuserid;

    @FXML
    private JFXTextField txtusername;
    UserBo userBO = (UserBoImpl) BoFactory.getBoFactory().getBo(BoFactory.BoType.User);
    private String userid;
    User userById;
    public void setUserid(String userid) {
        this.userid = userid;
        setdetails();
    }

    private void setdetails() {
        if (userid == null || userid.isEmpty()) {
            System.out.println("User ID is null or empty");
            return;
        }

        try {
             userById = userBO.findUserById(userid);

            if (userById != null) {
                txtuserid.setText(userid);
                txtusername.setText(userById.getUsername());
                txtemail.setText(userById.getEmail());
                txtrole.setText(userById.getRole());
            } else {
                System.out.println("No user found with id: " + userid);
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error loading user details").show();
        }
    }

    @FXML
    void btnchangeOnAction(ActionEvent event) throws Exception {
        try {
            String password = txtpassword1.getText();
            String newPassword = txtnewpassword1.getText();
            if (PasswordVerifier.verifyPassword(password,userById.getPassword())) {
                String encryptedNewPassword = PasswordEncrypt.hashPassword(newPassword);
                if (userBO.updateUser(new UserDTO(userid, txtusername.getText().trim(), encryptedNewPassword, txtemail.getText().trim(), txtrole.getText().trim()))) {
                    new Alert(Alert.AlertType.INFORMATION, "Password changed successfully!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to update password! Please try again.").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "The entered current password is incorrect!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "An unexpected error occurred! Please try again later.").show();
        }
    }

    @FXML
    void btnclearOnAction(ActionEvent event) {
         txtnewpassword1.clear();
         txtpassword1.clear();
    }

    @FXML
    void showPassword1OnMousePresseds(MouseEvent event) {
        txtpassword1.setVisible(false);
        txtpassword.setText(txtpassword1.getText());
        txtpassword.setVisible(true);
    }

    @FXML
    void showPassword1OnMouseReleased(MouseEvent event) {
        txtpassword1.setVisible(true);
        txtpassword.setVisible(false);
    }

    @FXML
    void showPassword2OnMousePresseds(MouseEvent event) {
        txtnewpassword1.setVisible(false);
        txtnewpassword.setText(txtnewpassword1.getText());
        txtnewpassword.setVisible(true);
    }

    @FXML
    void showPassword2OnMouseReleased(MouseEvent event) {
        txtnewpassword1.setVisible(true);
        txtnewpassword.setVisible(false);
    }

}
