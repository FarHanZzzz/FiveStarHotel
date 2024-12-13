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
import java.util.stream.Collectors;

import static cse.fivestarhotel.FrontDeskStaff.alert.showAlert;

//import static cse.fivestarhotel.FrontDeskStaff.GuestcheckinController.EmailValidator.isValidEmail;

public class GuestcheckinController implements Serializable
{
    @javafx.fxml.FXML
    private Label CheckInStatusLabel;
    @javafx.fxml.FXML
    private TextField GuestEmailTextField;
    @javafx.fxml.FXML
    private TextField NumberofRoomsTextField;
    @javafx.fxml.FXML
    private DatePicker CheckoutDatePicker;
    @javafx.fxml.FXML
    private TextField GuestNameTextField;
    @javafx.fxml.FXML
    private TextField GuestContactNoTetField;
    @javafx.fxml.FXML
    private ComboBox<String> RoomTypeComboBox;


    ObservableList<CheckInTableDummyClass> CheckinTabledataList = FXCollections.observableArrayList();





    //ObservableList<Guest> GuestDetails = FXCollections.observableArrayList();



     ArrayList<Integer> SingleRoom = new ArrayList<>();
     ArrayList<Integer> DoubleeRoom = new ArrayList<>();
     ArrayList<Integer> SuiteRoom = new ArrayList<>();


    @javafx.fxml.FXML
    private TextArea GuestTextAreaDetails;


    // ArrayList<CheckInTableDummyClass> CheckinTabledataList = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {

        for (int i = 1; i <= 100; i++) {
            if (i <= 50) SingleRoom.add(i); // 50 Single rooms
            else if (i <= 80) DoubleeRoom.add(i); // 30 Double rooms
            else SuiteRoom.add(i); // 20 Suite rooms
        }

        RoomTypeComboBox.getItems().addAll("Single", "Double", "Suite");

    }


// name,  email,  roomtype,  noofRooms,  roomnumber,  checkoutDate

    @javafx.fxml.FXML
    public void ClearFieldsOnAction(ActionEvent actionEvent) {
        GuestNameTextField.clear();
        GuestContactNoTetField.clear();
        NumberofRoomsTextField.clear();
        GuestEmailTextField.clear();
        RoomTypeComboBox.setValue(null);
        CheckoutDatePicker.setValue(null);
        NumberofRoomsTextField.clear();

    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }




    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {
        String name = GuestNameTextField.getText();
        String email = GuestEmailTextField.getText();
        int contactno;
        LocalDate checkoutDate = CheckoutDatePicker.getValue();
        String roomtype = RoomTypeComboBox.getValue();
        int noofRooms;

        try {
            noofRooms = Integer.parseInt(NumberofRoomsTextField.getText());
            contactno = Integer.parseInt(GuestContactNoTetField.getText());

        } catch (NumberFormatException e) {
            CheckInStatusLabel.setText("Invalid number of Rooms");
            return;
        }

            if (checkoutDate.isBefore(LocalDate.now())) {
                showAlert("error","Checkout date cannot be in the past!");
                return;
            }


        // validating other inputs
        if (name.isEmpty() || email.isEmpty() || roomtype.isEmpty() || noofRooms <= 0  ||  checkoutDate == null ){
            CheckInStatusLabel.setText("Please fill all the fields");
        }

        // email
        if (!isValidEmail(email)) {
            CheckInStatusLabel.setText("Invalid email address.");
            return;
        }




        // Allocate rooms
        List<Integer> allocatedRooms = allocateRooms(roomtype, noofRooms);
        if (allocatedRooms.isEmpty()) {
            //CheckInStatusLabel.setText("Not enough rooms available for the selected type!");
            showAlert("error", "Not enough rooms available for the selected type!");
            return;
        }

        String roomNumber = allocatedRooms.stream().map(String::valueOf).collect(Collectors.joining(", "));
        CheckInTableDummyClass c = new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumber,checkoutDate,contactno);
        CheckinTabledataList.add(c);



        try {
            File f = new File("CheckInGuestDetails.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;


            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            // Write the object
            oos.writeObject(c);

            // Update UI
            CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumber);
            GuestTextAreaDetails.setText("Guest Details: " + c.toString());

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }





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

        if (roomList.size() >= noofRooms) {
            for(int i = 0; i < noofRooms; i++){
                allocatedRooms.add(roomList.remove(0));  // remove and allocate
            }
            System.out.println("1"+ allocatedRooms);
        }
        else {
            System.out.println("Insufficient rooms for " + roomtype + ". Available: " + roomList.size());

        }
        System.out.println("Final "+ allocatedRooms);
        return allocatedRooms;
    }



    }




