package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class UserController {

    @FXML
    private JFXButton btnadduser;

    @FXML
    private JFXButton btnclear;

    @FXML
    private JFXButton btndelete;

    @FXML
    private JFXButton btnsearchuser;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colpassword;

    @FXML
    private TableColumn<?, ?> colrole;

    @FXML
    private TableColumn<?, ?> coluserid;

    @FXML
    private TableColumn<?, ?> colusername;

    @FXML
    private TableView<?> tbluser;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtpassword;

    @FXML
    private JFXPasswordField txtpassword1;

    @FXML
    private JFXPasswordField txtrepassword;

    @FXML
    private JFXComboBox<?> txtrole;

    @FXML
    private JFXTextField txtsearch;

    @FXML
    private JFXTextField txtuserid;

    @FXML
    private JFXTextField txtusername;

    @FXML
    private AnchorPane userform;

    @FXML
    void btnadduserOnAction(ActionEvent event) {

    }

    @FXML
    void btnclearOnAction(ActionEvent event) {

    }

    @FXML
    void btndeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnsearchuserOnAction(ActionEvent event) {

    }

    @FXML
    void btnupdateOnAction(ActionEvent event) {

    }

    @FXML
    void showPassword2OnMousePresseds(MouseEvent event) {

    }

    @FXML
    void showPassword2OnMouseReleased(MouseEvent event) {

    }

}
