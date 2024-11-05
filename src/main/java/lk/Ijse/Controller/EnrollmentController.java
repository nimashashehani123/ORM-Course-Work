package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class EnrollmentController {

    @FXML
    private JFXButton btnaddenrollment;

    @FXML
    private JFXButton btnclear1;

    @FXML
    private JFXButton btndelete;

    @FXML
    private JFXButton btnsearchcourse;

    @FXML
    private JFXButton btnsearchstudent;

    @FXML
    private TableColumn<?, ?> colcomment;

    @FXML
    private TableColumn<?, ?> colcourse_id;

    @FXML
    private TableColumn<?, ?> colcoursename;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colenrollmentid;

    @FXML
    private TableColumn<?, ?> colremain_fee;

    @FXML
    private TableColumn<?, ?> colstudentid;

    @FXML
    private TableColumn<?, ?> colstudentname;

    @FXML
    private TableColumn<?, ?> colupfront_fee;

    @FXML
    private AnchorPane enrollmentform;

    @FXML
    private TableView<?> tblenrollment;

    @FXML
    private JFXTextField txtcomment;

    @FXML
    private JFXComboBox<?> txtcourseid;

    @FXML
    private JFXTextField txtcoursename;

    @FXML
    private JFXTextField txtdate;

    @FXML
    private JFXTextField txtenrollmentid;

    @FXML
    private JFXTextField txtsearchcourse;

    @FXML
    private JFXTextField txtsearchstudent;

    @FXML
    private JFXComboBox<?> txtstudentid;

    @FXML
    private JFXTextField txtstudentname;

    @FXML
    private JFXTextField txttotalfees;

    @FXML
    private JFXTextField txtupfrontpayment;

    @FXML
    void btnaddenrollmentOnAction(ActionEvent event) {

    }

    @FXML
    void btnclearOnAction(ActionEvent event) {

    }

    @FXML
    void btndeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnsearchcourseOnAction(ActionEvent event) {

    }

    @FXML
    void btnsearchstudentOnAction(ActionEvent event) {

    }

}
