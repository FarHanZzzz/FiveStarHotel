package cse.fivestarhotel.HotelGuest;

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
        // Populate the ComboBox with star ratings
        ratingComboBox.getItems().addAll("★", "★★", "★★★", "★★★★", "★★★★★");
    }

    @javafx.fxml.FXML
    public void submitreviewButtonOnAction(ActionEvent actionEvent) {
        // Step 1: Get data from input fields
        String name = reviewnameTextField.getText();
        String rating = ratingComboBox.getValue();
        String reviewText = reviewTextArea.getText();

        // Step 2: Validate input fields
        if (name.isEmpty() || rating == null || reviewText.isEmpty()) {
            reviewDetailsLabel.setText("Please fill all the fields");
            return;
        }

        // Step 3: Create a new Review object
        Reviews review = new Reviews(name, rating, reviewText);
        reviews.add(review);

        // Step 4: Write the reviews to a file
        try {
            File file = new File("HotelGuestReview.bin");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Reviews r : reviews) {
                oos.writeObject(r);
                reviewDetailsLabel.setText("Thank you for your feedback!");
            }

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        reviewnameTextField.clear();
        reviewTextArea.clear();
        ratingComboBox.setValue(null);
    }
}
