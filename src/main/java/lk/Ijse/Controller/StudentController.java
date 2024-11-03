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
    private JFXButton btnaddcustomer;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> coldelete;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colstudentid;

    @FXML
    private TableColumn<?, ?> colstudentname;

    @FXML
    private TableColumn<?, ?> coltel;

    @FXML
    private TableColumn<?, ?> colupdate;

    @FXML
    private AnchorPane studentform;

    @FXML
    private TableView<?> tblcustomer;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtstudentid;

    @FXML
    private JFXTextField txtstudentname;

    @FXML
    private JFXTextField txttel;

    @FXML
    void btnaddcustomerOnAction(ActionEvent event) {

    }

}
