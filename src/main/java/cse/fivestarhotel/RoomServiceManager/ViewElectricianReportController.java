package cse.fivestarhotel.RoomServiceManager;

import cse.fivestarhotel.Electrician.MaintainenceLogs;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ViewElectricianReportController {
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
        FileInputStream fis = null;
        ObjectInputStream ois = null;


        try {
            File f = new File("MaintainenceLogs.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
                //Alert: file does not exist
            }
            if (fis != null) ois = new ObjectInputStream(fis);

            MaintainenceReportTableView.getItems().clear();

            while (true) {
                MaintainenceReportTableView.getItems().add((MaintainenceLogs) ois.readObject());


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