package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.RestaurantManager.BookTable;
import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

import cse.fivestarhotel.RestaurantManager.BookTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ResturantPAGEController implements Serializable {

    @FXML
    private TextField resNamefield;
    @FXML
    private TextField ResTimefield;
    @FXML
    private DatePicker ResDatepicker;
    @FXML
    private ComboBox<String> ResPeoplecombobox;

    @FXML
    private Label ResLabel;

    ObservableList<BookTable> bookedtabels = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        ResPeoplecombobox.getItems().addAll("1", "2", "3", "4", "5", "6");
    }

    @javafx.fxml.FXML
    public void BookATableOnAction(ActionEvent actionEvent) {
        String name = resNamefield.getText();
        LocalDate date = ResDatepicker.getValue();
        String time = ResTimefield.getText();
        String noofPeople = ResPeoplecombobox.getValue();

//String name, String time, LocalDate date, String noofPeople
        if (name.isEmpty() || time.isEmpty() || date == null || noofPeople == null ) {
            ResLabel.setText("Please input all the details."); // Show error message
            return;
        }

        BookTable table = new BookTable(name, time, date, noofPeople);
        bookedtabels.add(table);


        // Step 4: Write the reviews to a file
        try {
            File f = new File("BookTableDetails.bin");
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
            oos.writeObject(table);

            ResLabel.setText("Event Booked!");

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        resNamefield.clear();
        ResTimefield.clear();
        ResDatepicker.setValue(null);
        ResPeoplecombobox.setValue(null);

    }

}


