package cse.fivestarhotel.Electrician;

import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ElectricianDashboardController {
    @javafx.fxml.FXML
    private BorderPane CeoDashBoardBorderPane;
    @javafx.fxml.FXML
    private TableColumn<MaintainenceLogs, String> TaskTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintainenceLogs, String> StatusTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintainenceLogs, String> DateTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintainenceLogs, String> ObservationTableCol;
    @javafx.fxml.FXML
    private TableView<MaintainenceLogs> MaintainenceReportTableView;

    @javafx.fxml.FXML
    public void initialize() {
        TaskTableCol.setCellValueFactory(new PropertyValueFactory<>("task"));
        StatusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        DateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        ObservationTableCol.setCellValueFactory(new PropertyValueFactory<>("observations"));
    }
    @javafx.fxml.FXML
    public void ViewMaintainenceLogsOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("MaintainenceLogs.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            MaintainenceReportTableView.getItems().clear();

            while(true) {
                MaintainenceReportTableView.getItems().add((MaintainenceLogs) ois.readObject());


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

//    @javafx.fxml.FXML
//    public void ViewMaintainenceLogsOnAction(ActionEvent actionEvent) {
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//
//        try {
//            File file = new File("MaintainenceLogs.bin");
//            if (file.exists()) {
//                fis = new FileInputStream(file);
//                ois = new ObjectInputStream(fis);
//
//                MaintainenceReportTableView.getItems().clear();
//
//                while (true) {
//                    try {
//                        MaintainenceLogs log = (MaintainenceLogs) ois.readObject();
//                        MaintainenceReportTableView.getItems().add(log);
//                    } catch (Exception e) {
//                        break; // Break loop on EOFException or other issues
//                    }
//                }
//            } else {
//                // File does not exist, handle accordingly
//                System.out.println("No logs found.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); // Debugging purpose
//        } finally {
//            try {
//                if (ois != null) ois.close();
//                if (fis != null) fis.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//    }
        }}

    @javafx.fxml.FXML
    public void LogoutOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void MaintainenceLogsOnAction(ActionEvent actionEvent) {
    }
}