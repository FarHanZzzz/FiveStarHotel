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



        // combobox
        RoomTypeComboBox.getItems().addAll("Single", "Double", "Suite");



        //String name, String email, String roomtype, Integer noofRooms, String roomnumber, LocalDate checkoutDate




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
        RoomTypeComboBox.setValue(null);
        CheckoutDatePicker.setValue(null);
        NumberofRoomsTextField.clear();

    }




    @javafx.fxml.FXML
    public void CheckInOnAction(ActionEvent actionEvent) {

        String name = GuestNameTextField.getText();
        String email = GuestEmailTextField.getText();
        Integer contactno = Integer.valueOf(GuestContactNoTetField.getText());
        LocalDate checkoutDate = CheckoutDatePicker.getValue();
        String roomtype = RoomTypeComboBox.getValue();
        int noofRooms;



        try {
            noofRooms = Integer.parseInt(NumberofRoomsTextField.getText());
        } catch (NumberFormatException e) {
            CheckInStatusLabel.setText("Invalid number of Rooms");
            return;
        }


        // validating other inputs
        if (name.isEmpty() || email.isEmpty() || roomtype.isEmpty() || noofRooms <= 0 || contactno == null ||  checkoutDate == null ){
            CheckInStatusLabel.setText("Please fill all the fields");
        }


        // Allocate rooms
        List<Integer> allocatedRooms = allocateRooms(roomtype, noofRooms);
        if (allocatedRooms.isEmpty()) {
            CheckInStatusLabel.setText("Not enough rooms available for the selected type!");
            return;
        }

        String roomNumber = allocatedRooms.stream().map(String::valueOf).collect(Collectors.joining(", "));


        CheckInTableDummyClass c = new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumber,checkoutDate,contactno);
        CheckinTabledataList.add(c);





        try {
            File f = new File("CheckInGuestDetails.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;


            if(f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            for(CheckInTableDummyClass s : CheckinTabledataList){
                oos.writeObject(s);
                CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumber);
                GuestTextAreaDetails.setText("Guest Details: " + s.toString());

          }


            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }








//         for (CheckInTableDummyClass s : CheckinTabledataList){
//         //   CheckinTableView.getItems().add(s);
//         //   CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumber);
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









        //        // ends
        //
        //        //        CheckinTabledataList.add(new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumber,checkoutDate));
        ////        for(CheckInTableDummyClass c: CheckinTabledataList){
        ////            CheckinTableView.getItems().add(c);
        ////            CheckInStatusLabel.setText("Check-in successful! Rooms allocated: " + roomNumber);
        //
        //        //CheckInTableDummyClass temp = new CheckInTableDummyClass(name,email,roomtype,noofRooms,roomNumber,checkoutDate);
        ////        CheckinTabledataList.add(temp);
        ////        CheckinTableView.refresh();
        //        // String name, String email, String roomtype, Integer noofRooms, Integer roomnumber, LocalDate checkoutDate
        //
        //
        //// main code of tableview
        //
        //
        //
        //            //Will create multiple file header issue while appending objects (class instances)
        //
        //        // append


        //
//                    if(f.exists()) {
//                        fos = new FileOutputStream(f, true);
//                        oos = new AppendableObjectOutputStream(fos);
//                    }
//                    else {
//                        fos = new FileOutputStream(f);
//                        oos = new ObjectOutputStream(fos);
//                    }
//
//
//


    }




