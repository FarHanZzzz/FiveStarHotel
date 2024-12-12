package cse.fivestarhotel.RoomServiceWorker;

import cse.fivestarhotel.CEO.Announcement;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Locale;

public class RoomServiceWorkerDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> announcementsCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<Announcement> AnnouncementTableView;

    @javafx.fxml.FXML
    public void initialize() {


        announcementsCol.setCellValueFactory(new PropertyValueFactory<>("announcement"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));




        FileInputStream fis=null;
        ObjectInputStream ois=null;




        try{
            File f = new File("AnnoncementsDetails.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            AnnouncementTableView.getItems().clear();

            while(true) {
                AnnouncementTableView.getItems().add((Announcement) ois.readObject());


                //CheckinTableView.setItems(CheckinTabledataList);
            }
            //ois.close();

        }
        catch(Exception e) {
            try {
                if (ois != null) ois.close();

            } catch (Exception e2) {
                //

            }

        }




    }
}