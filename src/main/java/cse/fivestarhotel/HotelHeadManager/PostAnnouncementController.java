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

public class PostAnnouncementController implements Serializable {

    @javafx.fxml.FXML
    private Label Status;
    @javafx.fxml.FXML
    private DatePicker HeaddateDatePicker;
    @javafx.fxml.FXML
    private TextField HeadAnnouncementTextField;

    ObservableList<Announcement> announcementList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void submitAnnoncementOnAction(ActionEvent actionEvent) {

    }
}