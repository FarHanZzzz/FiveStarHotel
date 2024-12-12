package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.Serializable;

public class GuestcheckoutController implements Serializable
{
    @javafx.fxml.FXML
    private Label StatusLabel;
    @javafx.fxml.FXML
    private TextField GuestcheckoutEmailTextfield;
    @javafx.fxml.FXML
    private TextArea checkoutTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CheckoutOnAction(ActionEvent actionEvent) {


    }
}