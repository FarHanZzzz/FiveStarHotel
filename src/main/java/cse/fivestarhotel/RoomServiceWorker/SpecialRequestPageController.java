package cse.fivestarhotel.RoomServiceWorker;

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

public class SpecialRequestPageController {

    @javafx.fxml.FXML
    private TableView<serRequests> specialreqtable;
    @javafx.fxml.FXML
    private TableColumn<serRequests, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<serRequests, String> specificationCol;
    @javafx.fxml.FXML
    private TableColumn<serRequests, String> roomNoCol;
    @javafx.fxml.FXML
    private TableColumn<serRequests, String> detailnoteCol;

    @javafx.fxml.FXML
    public void initialize() {

        specificationCol.setCellValueFactory(new PropertyValueFactory<>("specifyreq"));
        detailnoteCol.setCellValueFactory(new PropertyValueFactory<>("detailnote"));
        roomNoCol.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

    }

    @javafx.fxml.FXML
    public void loadreqOnAction(ActionEvent actionEvent) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;


        try {
            File f = new File("RoomServiceReq.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
            }
            if (fis != null) ois = new ObjectInputStream(fis);

            specialreqtable.getItems().clear();

            while (true) {
                specialreqtable.getItems().add((serRequests) ois.readObject());


                //CheckinTableView.setItems(CheckinTabledataList);
            }
            //ois.close();

        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
                //

            }


        }
    }
}

