package lk.Ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class PaymentController {

    @FXML
    private JFXButton btnaddpayment;

    @FXML
    private JFXButton btnclear;

    @FXML
    private JFXButton btndelete;

    @FXML
    private JFXButton btnsearchpayment;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private TableColumn<?, ?> colamount;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colenrollmentid;

    @FXML
    private TableColumn<?, ?> colpaymentid;

    @FXML
    private AnchorPane paymentform;

    @FXML
    private TableView<?> tblpayment;

    @FXML
    private JFXTextField txtamount;

    @FXML
    private JFXTextField txtdate;

    @FXML
    private JFXComboBox<?> txtenrollmentid;

    @FXML
    private JFXTextField txtpaymentid;

    @FXML
    private JFXTextField txtsearch;

    @FXML
    void btnaddpaymentOnAction(ActionEvent event) {

    }

    @FXML
    void btnclearOnAction(ActionEvent event) {

    }

    @FXML
    void btndeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnsearchpaymentOnAction(ActionEvent event) {

    }

    @FXML
    void btnupdateOnAction(ActionEvent event) {

    }

}
