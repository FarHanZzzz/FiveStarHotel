package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class ReviewsPAGEController implements Serializable {

    @javafx.fxml.FXML
    private ComboBox<String> ratingComboBox;

    @javafx.fxml.FXML
    private TextField reviewnameTextField;

    @javafx.fxml.FXML
    private TextArea reviewTextArea;

    @javafx.fxml.FXML
    private Label reviewDetailsLabel;

    ObservableList<Reviews> reviews = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        ratingComboBox.getItems().addAll("★", "★★", "★★★", "★★★★","★★★★★");
    }

    @javafx.fxml.FXML
    public void submitreviewButtonOnAction(ActionEvent actionEvent) {

        String name = reviewnameTextField.getText();
        String rating = ratingComboBox.getValue();
        String reviewText = reviewTextArea.getText();


        if (name.isEmpty() || rating == null || reviewText.isEmpty()) {
            reviewDetailsLabel.setText("Please fill all the fields");
            return;
        }

        Reviews review = new Reviews(name, rating, reviewText);
        reviews.add(review);

        try {
            File f = new File("HotelGuestReview.bin");
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
            oos.writeObject(review);

            reviewDetailsLabel.setText("Thank you for your feedback!");

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        reviewnameTextField.clear();
        reviewTextArea.clear();
        ratingComboBox.setValue(null);
    }
}
