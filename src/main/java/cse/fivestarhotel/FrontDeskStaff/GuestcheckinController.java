package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class GuestcheckinController
{
    @javafx.fxml.FXML
    private TableView CheckinTableView;
    @javafx.fxml.FXML
    private TableColumn NumberofRoomsCol;
    @javafx.fxml.FXML
    private TableColumn RoomtypeCol;
    @javafx.fxml.FXML
    private Label CheckInStatusLabel;
    @javafx.fxml.FXML
    private TextField GuestEmailTextField;
    @javafx.fxml.FXML
    private TableColumn NameCol;
    @javafx.fxml.FXML
    private TextField NumberofRoomsTextField;
    @javafx.fxml.FXML
    private DatePicker CheckoutDatePicker;
    @javafx.fxml.FXML
    private TextField GuestNameTextField;
    @javafx.fxml.FXML
    private TextField GuestContactNoTetField;
    @javafx.fxml.FXML
    private ComboBox GuestMaritalStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn EmailCol;
    @javafx.fxml.FXML
    private TextField GuestNationalityTextField;
    @javafx.fxml.FXML
    private ComboBox RoomTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        System.out.println("hello magii can you see me");
    }

    @javafx.fxml.FXML
    public void ClearFieldsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {
    }
}