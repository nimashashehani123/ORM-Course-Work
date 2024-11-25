package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private JFXButton btncourses;

    @FXML
    private JFXButton btndashboard;

    @FXML
    private JFXButton btnenrollment;

    @FXML
    private JFXButton btnlogout;

    @FXML
    private JFXButton btnpayments;

    @FXML
    private JFXButton btnseeprofile;

    @FXML
    private JFXButton btnstudent;

    @FXML
    private JFXButton btnuser;

    @FXML
    private AnchorPane mainform;

    @FXML
    private JFXTextField txtcoursescount;

    @FXML
    private JFXTextField txtenrollmentcount;

    @FXML
    private JFXTextField txtstudentcount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtcoursescount.setText("10");
        txtenrollmentcount.setText("5");
        txtstudentcount.setText("20");
    }

    @FXML
    void btncoursesOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Course.fxml"));
            AnchorPane coursesPane = loader.load();
            mainform.getChildren().setAll(coursesPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btndashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnenrollmentOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Enrollment.fxml"));
            AnchorPane coursesPane = loader.load();
            mainform.getChildren().setAll(coursesPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnlogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnpaymentsOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Payment.fxml"));
            AnchorPane coursesPane = loader.load();
            mainform.getChildren().setAll(coursesPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnseeprofileOnAction(ActionEvent event) {

    }

    @FXML
    void btnstudentOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Student.fxml"));
            AnchorPane coursesPane = loader.load();
            mainform.getChildren().setAll(coursesPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnuserOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/User.fxml"));
            AnchorPane coursesPane = loader.load();
            mainform.getChildren().setAll(coursesPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
