package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LaundryPAGEController implements Serializable {

    @FXML
    private TextField LanNamefield;
    @FXML
    private TextField LanRoomfield;
    @FXML
    private TextField Lannotesfield;


    @FXML
    private Label LanLabel;

    ObservableList<Laundry> laundries = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void bookLaundryOnAction(ActionEvent actionEvent) {
        String name = LanNamefield.getText();
        String roomNo = LanRoomfield.getText();
        String addiNotes = Lannotesfield.getText();

        if (name.isEmpty() || roomNo.isEmpty() || addiNotes.isEmpty() ) {
            LanLabel.setText("Please input all the details.");
            return;
        }

        Laundry lan = new Laundry(name, roomNo, addiNotes);
        laundries.add(lan);


        try {
            File f = new File("LaundryInfo.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(lan);

            LanLabel.setText("Event Booked!");

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        LanNamefield.clear();
        LanRoomfield.clear();
        Lannotesfield.clear();

    }

}


