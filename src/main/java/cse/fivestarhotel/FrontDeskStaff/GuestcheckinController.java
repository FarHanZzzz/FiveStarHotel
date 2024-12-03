package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class GuestcheckinController
{
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,String> RoomtypeCol;
    @javafx.fxml.FXML
    private Label CheckInStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,String> NameCol;
    @javafx.fxml.FXML
    private TextField GuestNameTextField;
    @javafx.fxml.FXML
    private TextField GuestContactNoTetField;
    @javafx.fxml.FXML
    private TextField GuestNationalityTextField;
    @javafx.fxml.FXML
    private ComboBox<String> RoomTypeComboBox;
    @javafx.fxml.FXML
    private TableView<CheckinAssociation> CheckinTableView;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,Integer> NumberofRoomsCol;
    @javafx.fxml.FXML
    private TextField NumberofRoomsTextField;
    @javafx.fxml.FXML
    private ComboBox<String> GuestMaritalStatusComboBox;
    @javafx.fxml.FXML
    private DatePicker CheckoutDatePicker;
    @javafx.fxml.FXML
    private TextField GuestEmailTextField;
    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,String> EmailCol;


    ArrayList<CheckinAssociation> checkinassociationlist = new ArrayList<>();
    ArrayList<Guest> guestlist = new ArrayList<>();
    ArrayList<Room> roomlist = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {

        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        RoomtypeCol.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
        NumberofRoomsCol.setCellValueFactory(new PropertyValueFactory<>("NoofRooms"));



    }




    @javafx.fxml.FXML
    public void ClearFieldsOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {



        for (int i =1 ; i <=50; i++){

        }






//        CheckinTableView.getItems().add()








    }
}