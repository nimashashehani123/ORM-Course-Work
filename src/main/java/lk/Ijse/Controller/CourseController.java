package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class CourseController {

    @FXML
    private JFXButton btnaddcourse;

    @FXML
    private JFXButton btnsearchcourse;

    @FXML
    private TableColumn<?, ?> colcourseid;

    @FXML
    private TableColumn<?, ?> colcoursename;

    @FXML
    private TableColumn<?, ?> coldelete;

    @FXML
    private TableColumn<?, ?> colduration;

    @FXML
    private TableColumn<?, ?> colfees;

    @FXML
    private TableColumn<?, ?> colupdate;

    @FXML
    private AnchorPane courseform;

    @FXML
    private TableView<?> tblcourse;

    @FXML
    private JFXTextField txtcoursename;

    @FXML
    private JFXTextField txtduration;

    @FXML
    private JFXTextField txtfees;

    @FXML
    private JFXTextField txtscourseid;

    @FXML
    private JFXTextField txtsearch;

    @FXML
    void btnaddcourseOnAction(ActionEvent event) {

    }

    @FXML
    void btnsearchcourseOnAction(ActionEvent event) {

    }

}
