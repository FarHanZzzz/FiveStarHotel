package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.FrontDeskStaff.Event;
import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EventReservationPAGEController implements Serializable {

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
    private Label eventstatusLabel;

    ObservableList<Event> events = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        // Populate the ComboBox with star ratings
        eventTypeComboBox.getItems().addAll("Birthday", "Wedding", "Work Event", "Other");
        eventtimingComboBox.getItems().addAll("1 pm", "5 pm", "7 pm");
    }

    @FXML
    public void bookeventOnAction(ActionEvent actionEvent) {
        String name = eventnameField.getText();
        String email = eventemailField.getText();
        LocalDate date = eventdatePicker.getValue();
        String timing = eventtimingComboBox.getValue();
        String eventType = eventTypeComboBox.getValue();
        String additionalNotes = eventadditionalNotesField.getText();


        if (name.isEmpty() || email.isEmpty() || date == null || timing == null || eventType == null || additionalNotes.isEmpty()) {
            eventstatusLabel.setText("Please input all the details."); // Show error message
            return;
        }

        Event event = new Event(name, email, eventType, date, timing, additionalNotes);
        events.add(event);


        // Step 4: Write the reviews to a file
        try {
            File f = new File("BookEventDetails.bin");
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
            oos.writeObject(event);

            eventstatusLabel.setText("Event Booked!");

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        eventnameField.clear();
        eventemailField.clear();
        eventdatePicker.setValue(null);
        eventtimingComboBox.setValue(null);
        eventTypeComboBox.setValue(null);
        eventadditionalNotesField.setText(null);

        }
    }


