package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class StudentController {

    @FXML
    private JFXButton btnaddstudent;

    @FXML
    private JFXButton btnclear;

    @FXML
    private JFXButton btndelete;

    @FXML
    private JFXButton btnsearchstudent;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colstudentid;

    @FXML
    private TableColumn<?, ?> colstudentname;

    @FXML
    private TableColumn<?, ?> coltel;

    @FXML
    private AnchorPane studentform;

    @FXML
    private TableView<?> tblstudent;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtsearch;

    @FXML
    private JFXTextField txtstudentid;

    @FXML
    private JFXTextField txtstudentname;

    @FXML
    private JFXTextField txttel;

    @FXML
    void btnaddstudentOnAction(ActionEvent event) {

    }

    @FXML
    void btnclearOnAction(ActionEvent event) {

    }

    @FXML
    void btndeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnsearchstudentOnAction(ActionEvent event) {

    }

    @FXML
    void btnupdateOnAction(ActionEvent event) {

    }

}
