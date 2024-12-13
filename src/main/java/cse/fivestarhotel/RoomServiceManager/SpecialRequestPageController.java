package cse.fivestarhotel.RoomServiceManager;


import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import cse.fivestarhotel.HotelGuest.serRequests;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SpecialRequestPageController implements Serializable {

    @javafx.fxml.FXML
    private Label viewrequestlabel;



    @javafx.fxml.FXML
    public void viewRequestOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("RoomServiceReq.Bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
                viewrequestlabel.setText("error");
                return;
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            StringBuilder menuDetails = new StringBuilder();

            while (true) {
                try {
                    serRequests req = (serRequests) ois.readObject();
                    menuDetails.append((req)).append("\n");
                } catch (Exception e) {
                    break;
                }
            }
            viewrequestlabel.setText(menuDetails.toString());

        } catch (Exception e) {
            viewrequestlabel.setText("Error!");
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {

            }
        }
    }


    
    //  if (specifyreq == null || name.isEmpty() || roomNo.isEmpty())
}
