package cse.fivestarhotel.FrontDeskStaff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private TableColumn<CheckinAssociation,LocalDate> checkoutCol;

    @javafx.fxml.FXML
    private TableColumn<CheckinAssociation,Integer> roomnumberCol;




    ObservableList<CheckinAssociation> CheckinTabledataList = FXCollections.observableArrayList();



    //ArrayList<CheckinAssociation> CheckinAssociationList = new ArrayList<>();


    ArrayList<Integer> SingleRoom = new ArrayList<>();

    ArrayList<Integer> DoubleeRoom = new ArrayList<>();

    ArrayList<Integer> SuiteRoom = new ArrayList<>();




    @javafx.fxml.FXML
    public void initialize() {


        for (int i=0; i <=50 ; i++) SingleRoom.add(i);
        for (int i=51; i <=70 ; i++)  DoubleeRoom.add(i);
        for (int i = 71; i <= 100;i++) SuiteRoom.add(i);



        // combobox
        RoomTypeComboBox.getItems().addAll("Single", "Double", "Suite");
        GuestMaritalStatusComboBox.getItems().addAll("Married","Unmarried","Divorced");



        //String name, String email, String roomtype, Integer noofRooms, String roomid

        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        RoomtypeCol.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
        NumberofRoomsCol.setCellValueFactory(new PropertyValueFactory<>("noofRooms"));
        roomnumberCol.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
        checkoutCol.setCellValueFactory(new PropertyValueFactory<>("checkoutCol"));


        CheckinTableView.setItems(CheckinTabledataList);






    }






    @javafx.fxml.FXML
    public void ClearFieldsOnAction(ActionEvent actionEvent) {

    }



    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {

        //   for(CheckinAssociation s : CheckinAssociationList){



        String name =  GuestNameTextField.getText();
        String email = GuestEmailTextField.getText();
        String roomtype = RoomTypeComboBox.getValue();
        Integer NumberofRooms = Integer.valueOf(NumberofRoomsTextField.getText());
        LocalDate checkoutdate = CheckoutDatePicker.getValue();











        }








        }



