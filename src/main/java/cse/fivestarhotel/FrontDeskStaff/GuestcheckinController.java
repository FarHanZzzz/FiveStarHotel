package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class GuestcheckinController
{
    @javafx.fxml.FXML
    private TableView<CheckinAssociation> CheckinTableView;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,Integer> NumberofRoomsCol;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,String> RoomtypeCol;
    @javafx.fxml.FXML
    private Label CheckInStatusLabel;
    @javafx.fxml.FXML
    private TextField GuestEmailTextField;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,String> NameCol;
    @javafx.fxml.FXML
    private TextField NumberofRoomsTextField;
    @javafx.fxml.FXML
    private DatePicker CheckoutDatePicker;
    @javafx.fxml.FXML
    private TextField GuestNameTextField;
    @javafx.fxml.FXML
    private TextField GuestContactNoTetField;
    @javafx.fxml.FXML
    private ComboBox<String> GuestMaritalStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,String> EmailCol;
    @javafx.fxml.FXML
    private TextField GuestNationalityTextField;
    @javafx.fxml.FXML
    private ComboBox<String> RoomTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,String> roomidCol;

    // Check in List
    ArrayList<CheckinAssociation> CheckinAssociationList = new ArrayList<>();

    // Roomtype list

    ArrayList<Room> roomArrayList = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {

        // combobox

        RoomTypeComboBox.getItems().addAll("Single", "Double", "Suite");
        GuestMaritalStatusComboBox.getItems().addAll("Married","Unmarried","Divorced");



        //String name, String email, String roomtype, Integer noofRooms, String roomid
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        RoomtypeCol.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
        NumberofRoomsCol.setCellValueFactory(new PropertyValueFactory<>("noofRooms"));
        roomidCol.setCellValueFactory(new PropertyValueFactory<>("roomid"));




    }






    @javafx.fxml.FXML
    public void ClearFieldsOnAction(ActionEvent actionEvent) {

    }



    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {




    }



}