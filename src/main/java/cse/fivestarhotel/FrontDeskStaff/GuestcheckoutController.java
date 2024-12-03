package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GuestcheckoutController
{
    @javafx.fxml.FXML
    private TableColumn checkOutRoomTypeCol;
    @javafx.fxml.FXML
    private Label StatusLabel;
    @javafx.fxml.FXML
    private TextField GuestcheckoutidTextfield;
    @javafx.fxml.FXML
    private TableColumn checkoutnameCol;
    @javafx.fxml.FXML
    private TableColumn checkoutNoofRoomsCol;
    @javafx.fxml.FXML
    private TableColumn checkoutTotalBillCol;
    @javafx.fxml.FXML
    private TableView CheckoutTableView;
    @javafx.fxml.FXML
    private TableColumn checkoutEmailCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CheckoutOnAction(ActionEvent actionEvent) {
    }
}