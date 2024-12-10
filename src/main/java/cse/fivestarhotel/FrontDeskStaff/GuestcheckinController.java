package cse.fivestarhotel.FrontDeskStaff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//import static cse.fivestarhotel.FrontDeskStaff.GuestcheckinController.EmailValidator.isValidEmail;

public class GuestcheckinController implements Serializable
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
    private TableColumn<CheckInTableDummyClass,String> roomnumberCol;




    ObservableList<CheckInTableDummyClass> CheckinTabledataList = FXCollections.observableArrayList();
    //ObservableList<AcessGuestDetails> ViewTableListofGuest = FXCollections.observableArrayList();



     ArrayList<Integer> SingleRoom = new ArrayList<>();
     ArrayList<Integer> DoubleeRoom = new ArrayList<>();
     ArrayList<Integer> SuiteRoom = new ArrayList<>();


   // ArrayList<CheckInTableDummyClass> CheckinTabledataList = new ArrayList<>();



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


        //String name, String email, String roomtype, Integer noofRooms, String roomnumber, LocalDate checkoutDate

        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        RoomtypeCol.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
        NumberofRoomsCol.setCellValueFactory(new PropertyValueFactory<>("noofRooms"));
        roomnumberCol.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
        checkoutCol.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));



        //CheckinTabledataList.add(new CheckInTableDummyClass("John Doe", "john@example.com", "Single", 1, "101", LocalDate.now()));

        //CheckinTableView.setItems(CheckinTabledataList);
//        CheckinTableView.refresh();

    }


// name,  email,  roomtype,  noofRooms,  roomnumber,  checkoutDate

    @javafx.fxml.FXML
    public void ClearFieldsOnAction(ActionEvent actionEvent) {
        GuestNameTextField.clear();
        GuestContactNoTetField.clear();
        NumberofRoomsTextField.clear();
        GuestEmailTextField.clear();
        GuestNationalityTextField.clear();
        RoomTypeComboBox.setValue(null);
        CheckoutDatePicker.setValue(null);
        GuestMaritalStatusComboBox.setValue(null);
        NumberofRoomsTextField.clear();

    }




    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {

        String name = GuestNameTextField.getText();
        String email = GuestEmailTextField.getText();
        Integer contactno = Integer.valueOf(GuestContactNoTetField.getText());
        String nationality = GuestNationalityTextField.getText();
        LocalDate checkoutDate = CheckoutDatePicker.getValue();
        String roomtype = RoomTypeComboBox.getValue();
        String maritalStatus = GuestMaritalStatusComboBox.getValue();
        int noofRooms;



        try {
            noofRooms = Integer.parseInt(NumberofRoomsTextField.getText());
        } catch (NumberFormatException e) {
            CheckInStatusLabel.setText("Invalid number of Rooms");
            return;
        }


        // validating other inputs
        if (name.isEmpty() || email.isEmpty() || roomtype.isEmpty() || noofRooms <= 0 || contactno == null || nationality.isEmpty() || checkoutDate == null || maritalStatus.isEmpty()){
            CheckInStatusLabel.setText("Please fill all the fields");
        }


        // Allocate rooms
        List<Integer> allocatedRooms = allocateRooms(roomtype, noofRooms);
        if (allocatedRooms.isEmpty()) {
            CheckInStatusLabel.setText("Not enough rooms available for the selected type!");
            return;
        }

        String roomNumber = allocatedRooms.stream().map(String::valueOf).collect(Collectors.joining(", "));


        CheckInTableDummyClass c = new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumber,checkoutDate);
        CheckinTabledataList.add(c);
        CheckinTableView.refresh();


        // ends

        //        CheckinTabledataList.add(new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumber,checkoutDate));
//        for(CheckInTableDummyClass c: CheckinTabledataList){
//            CheckinTableView.getItems().add(c);
//            CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumber);

        //CheckInTableDummyClass temp = new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumber,checkoutDate);
//        CheckinTabledataList.add(temp);
//        CheckinTableView.refresh();
        // String name, String email, String roomtype, Integer noofRooms, Integer roomnumber, LocalDate checkoutDate


// main code of tableview



            //Will create multiple file header issue while appending objects (class instances)

//            if(f.exists()) {
//                fos = new FileOutputStream(f, true);
//                oos = new AppendableObjectOutputStream(fos);
//            }
//            else {
//                fos = new FileOutputStream(f);
//                oos = new ObjectOutputStream(fos);
//            }
//
        try {

            File f = new File("CheckInGuestDetails.bin");

            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);


            for(CheckInTableDummyClass s : CheckinTabledataList){
                oos.writeObject(s);
                CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumber);

          }


            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }











//         for (CheckInTableDummyClass s : CheckinTabledataList){
//         //   CheckinTableView.getItems().add(s);
//         //   CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumber);
//
//
//
//
//        }

    }



    public List<Integer> allocateRooms(String roomtype , int noofRooms) {
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

        // roomlist = 50 , 3

        if (roomList.size() >= noofRooms) {
            for(int i = 0; i < noofRooms; i++){
                allocatedRooms.add(roomList.remove(0));  // remove and allocate

            }

            System.out.println("1"+ allocatedRooms);


            // single 1 -50 =

        }

        else {
            System.out.println("Insufficient rooms for " + roomtype + ". Available: " + roomList.size());

        }


        System.out.println("Final "+ allocatedRooms);

        return allocatedRooms;
    }




    @javafx.fxml.FXML
    public void GenerateCheckinDetailsTableOnAction(ActionEvent actionEvent) {

        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("CheckInGuestDetails.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            CheckinTableView.getItems().clear();
            while(true) {
                CheckinTableView.getItems().add((CheckInTableDummyClass) ois.readObject());
                //CheckinTableView.setItems(CheckinTabledataList);
            }
            //ois.close();

        }
        catch(Exception e){
            try {
                if (ois != null) ois.close();
            }
            catch(Exception e2){
                //

            }

        }
    }
}



