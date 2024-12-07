package cse.fivestarhotel.FrontDeskStaff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//import static cse.fivestarhotel.FrontDeskStaff.GuestcheckinController.EmailValidator.isValidEmail;

public class GuestcheckinController
{
    @javafx.fxml.FXML
    private TableView<CheckInTableDummyClass> CheckinTableView;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,Integer> NumberofRoomsCol;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,String> RoomtypeCol;
    @javafx.fxml.FXML
    private Label CheckInStatusLabel;
    @javafx.fxml.FXML
    private TextField GuestEmailTextField;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,String> NameCol;
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
    private TableColumn<CheckInTableDummyClass,String> EmailCol;
    @javafx.fxml.FXML
    private TextField GuestNationalityTextField;
    @javafx.fxml.FXML
    private ComboBox<String> RoomTypeComboBox;


    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,LocalDate> checkoutCol;

    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,Integer> roomnumberCol;




    ObservableList<CheckInTableDummyClass> CheckinTabledataList = FXCollections.observableArrayList();
    ObservableList<AcessGuestDetails> ViewTableListofGuest = FXCollections.observableArrayList();

    //ArrayList<CheckinAssociation> CheckinAssociationList = new ArrayList<>();


    ArrayList<Integer> SingleRoom = new ArrayList<>();

    ArrayList<Integer> DoubleeRoom = new ArrayList<>();

    ArrayList<Integer> SuiteRoom = new ArrayList<>();




    @javafx.fxml.FXML
    public void initialize() {




        for (int i = 1; i <= 100; i++) {
            if (i <= 50) SingleRoom.add(i); // 50 Single rooms
            else if (i <= 80) DoubleeRoom.add(i); // 30 Double rooms
            else SuiteRoom.add(i); // 20 Suite rooms
        }







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


// name,  email,  roomtype,  noofRooms,  roomnumber,  checkoutDate

    @javafx.fxml.FXML
    public void ClearFieldsOnAction(ActionEvent actionEvent) {
        GuestNameTextField.clear();
        GuestContactNoTetField.clear();
        NumberofRoomsTextField.getText();
        GuestEmailTextField.clear();
        GuestNationalityTextField.clear();
        RoomTypeComboBox.setValue(null);
        CheckoutDatePicker.setValue(null);
        GuestMaritalStatusComboBox.setValue(null);



    }







    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {

        String name = GuestNameTextField.getText();
        String email = GuestEmailTextField.getText();
        Integer contactno = Integer.valueOf(GuestContactNoTetField.getText());
        String nationality = GuestNationalityTextField.getText();
        LocalDate Checkoutdate = CheckoutDatePicker.getValue();
        String roomtype = RoomTypeComboBox.getValue();
        String maritalStatus = GuestMaritalStatusComboBox.getValue();
        int noofRooms;


        try {
            noofRooms = Integer.parseInt(GuestContactNoTetField.getText());
        } catch (NumberFormatException e) {
            CheckInStatusLabel.setText("Invalid number of Rooms");
            return;
        }

        // validating other inputs
        if (name.isEmpty() || email.isEmpty() || roomtype.isEmpty() || noofRooms <= 0 || contactno == null || nationality.isEmpty() || Checkoutdate == null || maritalStatus.isEmpty()){
            CheckInStatusLabel.setText("Please fill all the fields");
        }



        // Allocate rooms
        List<Integer> allocatedRooms = allocateRooms(roomtype, noofRooms);
        if (allocatedRooms.isEmpty()) {
            CheckInStatusLabel.setText("Not enough rooms available for the selected type!");
            return;
        }


        String roomNumbers = allocatedRooms.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        //String name, String email, String roomtype, Integer noofRooms, Integer roomnumber, LocalDate checkoutDate
        CheckInTableDummyClass newcheckin = new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumbers,Checkoutdate);

        CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumbers);
        CheckinTabledataList.add(newcheckin);










    }

















    public List<Integer> allocateRooms(String roomtype , int numberofRooms) {

        List<Integer> roomList;
        List<Integer> allocatedRooms = new ArrayList<>();

        switch (roomtype) {
            case "Single" -> roomList = SingleRoom;
            case "Double" -> roomList = DoubleeRoom;
            case "Suite" -> roomList = SuiteRoom;

            default -> {
                return allocatedRooms; // empty list if invalid

            }

        }

        // allocate room if avalidable
        System.out.println("Room list for " + roomtype + ": " + roomList);


        if (roomList.size() >= numberofRooms) {
            for(int i = 0; i < numberofRooms; i++){
                Integer allocatedRoom = roomList.remove(0);
                allocatedRooms.add(allocatedRoom); // remove and allocate
                System.out.println(allocatedRooms);

            }

        }

        else {
            System.out.println("Insufficient rooms for " + roomtype + ". Available: " + roomList.size());

        }

        return allocatedRooms;


    }


}



