package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.FrontDeskStaff.Event;
import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EventReservationPAGEController {

    @FXML
    private TextField eventnameField;
    @FXML
    private TextField eventemailField;
    @FXML
    private DatePicker eventdatePicker;
    @FXML
    private ComboBox<String> eventtimingComboBox;
    @FXML
    private ComboBox<String> eventTypeComboBox;
    @FXML
    private TextField eventadditionalNotesField;


    @FXML
    public void initialize() {
        // Populate timing options
        ObservableList<String> timingOptions = FXCollections.observableArrayList("1 pm", "5 pm", "7 pm");
        eventtimingComboBox.setItems(timingOptions);

        // Populate event type options
        ObservableList<String> eventTypeOptions = FXCollections.observableArrayList("Birthday", "Wedding", "Office Party", "Other");
        eventTypeComboBox.setItems(eventTypeOptions);

    }

    @FXML
    public void bookeventOnAction(ActionEvent actionEvent) {
        String name = eventnameField.getText();
        String email = eventemailField.getText();
        LocalDate date = eventdatePicker.getValue();
        String timing = eventtimingComboBox.getValue(); // Get selected timing
        String eventType = eventTypeComboBox.getValue(); // Get selected event type
        String eventadditionalNotes = eventadditionalNotesField.getText();

        Event event = new Event(name, email, eventType, date, timing, eventadditionalNotes);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("BookEventDetails.bin");
            fos = new FileOutputStream(file, true);

            if (file.exists() && file.length() > 0) {
                oos = new AppendableObjectOutputStream(fos);
            } else {
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(event);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
