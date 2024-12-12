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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RoomServiceReqController implements Serializable {

    @FXML
    private TextField reqnamefield;
    @FXML
    private TextField reqroomfield;
    @FXML
    private ComboBox<String> reqspecifycombobox;
    @FXML
    private TextField reqdetailsfield;
    @FXML
    private Label reqLabel;

    ObservableList<serRequests> requests = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        reqspecifycombobox.getItems().addAll("Cleanup", "Extra pillow/blanket etc", "Extra commodities (shampoo/soap etc)", "Other");
    }

    @FXML
    public void submitreqOnAction(ActionEvent actionEvent) {
        String name = reqnamefield.getText();
        String roomNo = reqroomfield.getText();
        String specifyreq = reqspecifycombobox.getValue();
        String detailnote = reqdetailsfield.getText();


        if (specifyreq == null || name.isEmpty() || roomNo.isEmpty()) {
            reqLabel.setText("Please input all the details.");
            return;
        }

        serRequests req = new serRequests(specifyreq, name, roomNo, detailnote);
        requests.add(req);


        try {
            File f = new File("RoomServiceReq.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(req);

            reqLabel.setText("Request Submitted!");

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        reqnamefield.clear();
        reqroomfield.clear();
        reqspecifycombobox.setValue(null);
        reqdetailsfield.clear();
    }
}