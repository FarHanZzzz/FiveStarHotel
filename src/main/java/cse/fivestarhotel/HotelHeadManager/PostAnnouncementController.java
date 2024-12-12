package cse.fivestarhotel.HotelHeadManager;

import cse.fivestarhotel.CEO.Announcement;
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

    ObservableList<Announcement> announcementList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {


    }

    @Deprecated
    public void submitAnnoncementOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void HeadsubmitAnnoncementOnAction(ActionEvent actionEvent) {
    }
}