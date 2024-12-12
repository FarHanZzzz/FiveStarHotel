package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import cse.fivestarhotel.FrontDeskStaff.Transportation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class TransportationDetailsPAGEController implements Serializable {

    @javafx.fxml.FXML
    private TextField transportDestinationField;
    @javafx.fxml.FXML
    private TextField transporttimefield;
    @javafx.fxml.FXML
    private TextField transportemailField;

    @javafx.fxml.FXML
    private TextField transportnameField;
    @javafx.fxml.FXML
    private DatePicker transportdatepicker;
    @javafx.fxml.FXML
    private Label transportlabel;
    @javafx.fxml.FXML
    private ComboBox<String> transportvehicleComboBox;


    ObservableList<Transportation> transportations = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        transportvehicleComboBox.getItems().addAll("Private Car" , "Micro" , "Limo");
    }

    @javafx.fxml.FXML
    public void BookTransportOnAction(ActionEvent actionEvent) {
        String name = transportnameField.getText();
        String email = transportemailField.getText();
        LocalDate date = transportdatepicker.getValue();
        String time = transporttimefield.getText();
        String destination = transportDestinationField.getText();
        String vehicletype = transportvehicleComboBox.getValue();

//String name, String email, String destination, LocalDate date, String time, String vehicletype
        if (name.isEmpty() || email.isEmpty() || time.isEmpty() || destination.isEmpty() || date == null || vehicletype == null ) {
            transportlabel.setText("Please input all the details."); // Show error message
            return;
        }

        Transportation transfer = new Transportation(name, email, destination, date, time, vehicletype);
        transportations.add(transfer);


        // Step 4: Write the reviews to a file
        try {
            File f = new File("TransportationDetails.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            transportlabel.setText("Transportation Booked!");
            // Write the object
            oos.writeObject(transfer);



            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        transportnameField.clear();
        transportDestinationField.clear();
        transportemailField.clear();
        transporttimefield.clear();
        transportDestinationField.clear();
        transportdatepicker.setValue(null);
        transportvehicleComboBox.setValue(null);

    }

}

