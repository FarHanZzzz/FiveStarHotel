package cse.fivestarhotel.RoomServiceWorker;

import cse.fivestarhotel.HotelGuest.Laundry;
import cse.fivestarhotel.HotelGuest.Reviews;
import cse.fivestarhotel.HotelGuest.serRequests;
import cse.fivestarhotel.RestaurantManager.Menu;
import cse.fivestarhotel.RestaurantManager.PerformanceReport;
import cse.fivestarhotel.FrontDeskStaff.CheckInTableDummyClass;
import cse.fivestarhotel.RestaurantManager.PerformanceReport;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ViewLaundryRequestPageController {

    @javafx.fxml.FXML
    private TableColumn<Laundry, String> addilaunCol;
    @javafx.fxml.FXML
    private TableColumn<Laundry, String> launnameCol;
    @javafx.fxml.FXML
    private TableColumn<Laundry, String> launroomNoCol;
    @javafx.fxml.FXML
    private TableView<Laundry> launreqtable;

    @javafx.fxml.FXML
    public void initialize() {

        launnameCol.setCellValueFactory(new PropertyValueFactory<>("specifyreq"));
        launroomNoCol.setCellValueFactory(new PropertyValueFactory<>("detailnote"));
        addilaunCol.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
    }

    @javafx.fxml.FXML
    public void loadlaunreqOnAction(ActionEvent actionEvent) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;


        try {
            File f = new File("LaundryInfo.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
            }
            if (fis != null) ois = new ObjectInputStream(fis);

            launreqtable.getItems().clear();

            while (true) {
                launreqtable.getItems().add((Laundry) ois.readObject());

            }

        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {

            }

        }
    }
}

