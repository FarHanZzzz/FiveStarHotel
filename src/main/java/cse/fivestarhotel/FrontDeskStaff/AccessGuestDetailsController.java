package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
//package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class AccessGuestDetailsController implements Serializable
{

    @javafx.fxml.FXML
    private TableView<CheckInTableDummyClass> CheckinTableView;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,Integer> NumberofRoomsCol;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,String> RoomtypeCol;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,String> roomnumberCol;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,String> EmailCol;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass, LocalDate> checkoutCol;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,String> NameCol;
    @javafx.fxml.FXML
    private TableColumn<CheckInTableDummyClass,Integer> contactInfoCol;


    @javafx.fxml.FXML
    public void initialize() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        RoomtypeCol.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
        NumberofRoomsCol.setCellValueFactory(new PropertyValueFactory<>("noofRooms"));
        roomnumberCol.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
        checkoutCol.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
        contactInfoCol.setCellValueFactory(new PropertyValueFactory<>("contactinfo"));

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
                //
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            CheckinTableView.getItems().clear();
            while(true) {
                CheckinTableView.getItems().add((CheckInTableDummyClass) ois.readObject());


                //
            }
            //ois.close();

        }
        catch(Exception e) {
            try {
                if (ois != null) ois.close();

            } catch (Exception e2) {
                //

            }

        }

    }
}