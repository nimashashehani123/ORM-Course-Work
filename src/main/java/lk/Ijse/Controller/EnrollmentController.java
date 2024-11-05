package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.bo.BoFactory;
import lk.Ijse.bo.custom.CourseBo;
import lk.Ijse.bo.custom.EnrollmentBo;
import lk.Ijse.bo.custom.StudentBo;
import lk.Ijse.bo.custom.impl.CourseBoImpl;
import lk.Ijse.bo.custom.impl.StudentBoImpl;
import lk.Ijse.dto.EnrollmentDTO;
import lk.Ijse.dto.StudentDTO;
import lk.Ijse.entity.tm.EnrollmentTm;
import lk.Ijse.entity.tm.StudentTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class EnrollmentController implements Initializable {

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
    private TableView<EnrollmentTm> tblenrollment;

    @FXML
    private JFXTextField txtcomment;

    @FXML
    private JFXComboBox<String> txtcourseid;

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
    private JFXComboBox<String> txtstudentid;

    @FXML
    private JFXTextField txtstudentname;

    @FXML
    private JFXTextField txttotalfees;

    @FXML
    private JFXTextField txtupfrontpayment;


    ObservableList<EnrollmentTm> observableList;
    String ID;
    EnrollmentBo enrollmentBo = (EnrollmentBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Enrollment);
    StudentBo studentBo = (StudentBoImpl) BoFactory.getBoFactory().getBo(BoFactory.BoType.Student);
    CourseBo courseBo = (CourseBoImpl) BoFactory.getBoFactory().getBo(BoFactory.BoType.Course);



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            txtdate.setText(today.format(formatter));
            getAll();
            loadStudentIds();
            loadCourseIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setCellValueFactory();
        generateNextUserId();
    }

    private void loadCourseIds() throws SQLException, ClassNotFoundException {
        List<String> courseIds = courseBo.getAllCourseIds();
        txtcourseid.getItems().clear();
        txtcourseid.getItems().addAll(courseIds);
    }

    private void generateNextUserId() {
        String nextId = null;
        try {
            nextId = enrollmentBo.generateNewEnrollmentID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        txtenrollmentid.setText(nextId);
    }

    private void setCellValueFactory() {
        colenrollmentid.setCellValueFactory(new PropertyValueFactory<>("seid"));
        colstudentid.setCellValueFactory(new PropertyValueFactory<>("sid"));
        colstudentname.setCellValueFactory(new PropertyValueFactory<>("Studentname"));
        colcourse_id.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colcoursename.setCellValueFactory(new PropertyValueFactory<>("Coursename"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colupfront_fee.setCellValueFactory(new PropertyValueFactory<>("upfrontpayment"));
        colremain_fee.setCellValueFactory(new PropertyValueFactory<>("remainingfee"));
        colcomment.setCellValueFactory(new PropertyValueFactory<>("comment"));
    }

    private void getAll() throws SQLException, ClassNotFoundException {
        observableList = FXCollections.observableArrayList();
        List<EnrollmentDTO> allenrollment = enrollmentBo.getAllEnrollment();

        for (EnrollmentDTO enrollmentDTO : allenrollment){
            observableList.add(new EnrollmentTm(enrollmentDTO.getEid(),enrollmentDTO.getSid(),enrollmentDTO.getStudentname(),enrollmentDTO.getCid(),enrollmentDTO.getCoursename(),enrollmentDTO.getDate(),enrollmentDTO.getUpfrontpayment(),enrollmentDTO.getRemainingfee(),enrollmentDTO.getComment()));
        tblenrollment.setItems(observableList);
        }
    }

    private void loadStudentIds() throws Exception {
        List<String> studentIds = studentBo.getAllStudentIds();
        txtstudentid.getItems().clear();
        txtstudentid.getItems().addAll(studentIds);
    }
    @FXML
    void btnaddenrollmentOnAction(ActionEvent event) throws Exception {
        String id = txtenrollmentid.getText();
        String sid = txtstudentid.getValue();
        String studentname = txtstudentname.getText();
        String cid = txtstudentid.getValue();
        String coursename = txtcoursename.getText();
        LocalDate date = LocalDate.parse(txtdate.getText());
        Double totalfee = Double.valueOf(txttotalfees.getText());
        Double upfrontpayment = Double.valueOf(txtupfrontpayment.getText());
        Double remainingfee = totalfee - upfrontpayment;
        String comment = txtcomment.getText();

        if (enrollmentBo.EnrollmentIdExists(id)){
            new Alert(Alert.AlertType.ERROR, "Enrollment ID " + id + " already exists!").show();
            return;
        }

        if (enrollmentBo.saveEnrollment(new EnrollmentDTO(id, sid,studentname,cid,coursename,date,upfrontpayment,remainingfee,comment))) {
            clearTextFileds();
            generateNextUserId();
            getAll();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error!!").show();
        }
    }

    private void clearTextFileds() {
        txtstudentid.clear();
        txtstudentname.clear();
        txtaddress.clear();
        txttel.clear();
        txtemail.clear();
        generateNextUserId();
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
