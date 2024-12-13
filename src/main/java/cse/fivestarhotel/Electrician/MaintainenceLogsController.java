package cse.fivestarhotel.Electrician;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class MaintainenceLogsController implements Serializable {

    @javafx.fxml.FXML
    private ComboBox<String> TaskComboBox;
    @javafx.fxml.FXML
    private Label budgetStatusLabel;
    @javafx.fxml.FXML
    private DatePicker DateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> StatusComboBox;
    @javafx.fxml.FXML
    private TextArea ObservationTextArea;

    private ObservableList<MaintainenceLogs> maintainenceLogs = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        TaskComboBox.getItems().addAll("Installation", "Maintenance", "Repair", "Guest Room Support");
        StatusComboBox.getItems().addAll("Completed", "In Progress", "Cancelled");
    }

    @javafx.fxml.FXML
    public void PostReportOnAction(ActionEvent actionEvent) {
        LocalDate date = DateDatePicker.getValue();
        String status = StatusComboBox.getValue();
        String task = TaskComboBox.getValue();
        String observations = ObservationTextArea.getText();

        if (date == null || status == null || task == null || observations.isEmpty()) {
            budgetStatusLabel.setText("Please fill all the fields");
            return;
        }

        MaintainenceLogs logs = new MaintainenceLogs(date, status, task, observations);
        maintainenceLogs.add(logs);

        try {
            File f = new File("MaintainenceLogs.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            // Write the object
            oos.writeObject(logs);

            budgetStatusLabel.setText("Thank you for your feedback!");

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        ObservationTextArea.clear();
        StatusComboBox.setValue(null);
        TaskComboBox.setValue(null);
        DateDatePicker.setValue(null);


    }
}
