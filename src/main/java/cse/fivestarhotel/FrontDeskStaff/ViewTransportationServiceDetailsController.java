package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class ViewTransportationServiceDetailsController implements Serializable
{
    @javafx.fxml.FXML
    private TableView<Transportation> transportationTableView;
    @javafx.fxml.FXML
    private TableColumn<Transportation,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Transportation,String> emailCol;
    @javafx.fxml.FXML
    private TableColumn<Transportation,LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Transportation,String> destinationCol;
    @javafx.fxml.FXML
    private TableColumn<Transportation,String> vehicleTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Transportation, String> timeCol;


    //String name, String email, String destination, LocalDate date, String time, String vehicletype
    @javafx.fxml.FXML
    public void initialize() {

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        vehicleTypeCol.setCellValueFactory(new PropertyValueFactory<>("vehicletype"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

    }






    @javafx.fxml.FXML
    public void showTransportationBookingDetailsOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

//String name, String email, String destination, LocalDate date, String time, String vehicletype


        try{
            File f = new File("TransportationDetails.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            transportationTableView.getItems().clear();

            while(true) {
                transportationTableView.getItems().add((Transportation) ois.readObject());


                //CheckinTableView.setItems(CheckinTabledataList);
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