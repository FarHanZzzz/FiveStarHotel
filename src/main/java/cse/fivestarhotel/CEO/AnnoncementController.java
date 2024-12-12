package cse.fivestarhotel.CEO;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class AnnoncementController implements Serializable
{
    @javafx.fxml.FXML
    private Label Status;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextField AnnouncementTextField;

    ObservableList<Announcement> announcementList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void submitAnnoncementOnAction(ActionEvent actionEvent) {
        String Announcement = AnnouncementTextField.getText();
        LocalDate date = dateDatePicker.getValue();


        Announcement a = new Announcement(Announcement,date);
        announcementList.add(a);

        try {
            File f = new File("AnnoncementsDetails.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            // Use appropriate streams based on file existence
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            Status.setText("Succesfully Submitted");
            oos.writeObject(a);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        AnnouncementTextField.clear();
        dateDatePicker.setValue(null);





    }
}