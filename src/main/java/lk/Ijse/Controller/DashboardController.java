package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private List<Node> originalMainformChildren;
    private int role;
    private String userid;
    public void setRole(int role) {
        this.role = role;
        applyRoleBasedDecisions();
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid(){
        return this.userid;
    }

    private void applyRoleBasedDecisions() {
        if (1 == role) {
            System.out.println("Admin privileges granted.");
            enableAllButtons();
        } else if (0 == role) {
            System.out.println("Coordinator privileges granted.");
            restrictToCoordinatorPermissions();
        } else {
            System.out.println("No specific privileges granted.");
            disableAllButtons();
        }
    }

    private void enableAllButtons() {
        btncourses.setVisible(true);
        btndashboard.setVisible(true);
        btnenrollment.setVisible(true);
        btnlogout.setVisible(true);
        btnpayments.setVisible(true);
        btnseeprofile.setVisible(true);
        btnstudent.setVisible(true);
        btnuser.setVisible(true);
    }


    private void restrictToCoordinatorPermissions() {
        btncourses.setVisible(false);
        btndashboard.setVisible(true);
        btnlogout.setVisible(true);
        btnpayments.setVisible(false);
        btnseeprofile.setVisible(true);
        btnstudent.setVisible(true);
        btnenrollment.setVisible(true);
        btnuser.setVisible(false);
    }

    private void disableAllButtons() {
        btncourses.setVisible(false);
        btndashboard.setVisible(false);
        btnenrollment.setVisible(false);
        btnlogout.setVisible(false);
        btnpayments.setVisible(false);
        btnseeprofile.setVisible(false);
        btnstudent.setVisible(false);
        btnuser.setVisible(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        originalMainformChildren = new ArrayList<>(mainform.getChildren());
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
    void btndashboardOnAction(ActionEvent event) throws IOException {
        try {
            mainform.getChildren().setAll(originalMainformChildren);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void btnlogoutOnAction(ActionEvent event) throws IOException {
        mainform.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();
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
    void btnseeprofileOnAction(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Profile.fxml"));
            AnchorPane profilePane = loader.load();
            mainform.getChildren().setAll(profilePane);
            ProfileController profileController = loader.getController();
            profileController.setUserid(getUserid());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
