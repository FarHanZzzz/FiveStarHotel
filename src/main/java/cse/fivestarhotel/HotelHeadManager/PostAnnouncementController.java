package cse.fivestarhotel.HotelHeadManager;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import cse.fivestarhotel.CEO.Announcement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class PostAnnouncementController implements Serializable
{
    @javafx.fxml.FXML
    private Label HeadStatus;


    @javafx.fxml.FXML
    private ComboBox<String> headpositionCombobox;
    @javafx.fxml.FXML
    private DatePicker HeaddateDatePicker;
    @javafx.fxml.FXML
    private TextField HeadAnnouncementTextField;


    ObservableList<Announcement> announcementList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        headpositionCombobox.getItems().addAll("CEO", "Head Manager");


    }

    @Deprecated
    public void HeadsubmitAnnoncementOnAction(ActionEvent actionEvent) {
        String Announcement = HeadAnnouncementTextField.getText();
        String position = headpositionCombobox.getValue();
        LocalDate date = HeaddateDatePicker.getValue();


        Announcement a = new Announcement(Announcement,position,date);
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

            HeadStatus.setText("Succesfully Submitted");
            oos.writeObject(a);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        HeadAnnouncementTextField.clear();
        HeaddateDatePicker.setValue(null);


    }

}