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

public class ResturantReviewController implements Serializable {

    @javafx.fxml.FXML
    private ComboBox<String> ResratingComboBox;

    @javafx.fxml.FXML
    private TextField ResreviewnameTextField;

    @javafx.fxml.FXML
    private TextArea ResreviewTextArea;

    @javafx.fxml.FXML
    private Label ResturantreviewDetailsLabel;

    ObservableList<Reviews> resreviews = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        ResratingComboBox.getItems().addAll("★", "★★", "★★★", "★★★★","★★★★★");
    }

    @javafx.fxml.FXML
    public void RessubmitreviewButtonOnAction(ActionEvent actionEvent) {

        String name = ResreviewnameTextField.getText();
        String rating = ResratingComboBox.getValue();
        String reviewText = ResreviewTextArea.getText();


        if (name.isEmpty() || rating == null || reviewText.isEmpty()) {
            ResturantreviewDetailsLabel.setText("Please fill all the fields");
            return;
        }

        Reviews rev = new Reviews(name, rating, reviewText);
        resreviews.add(rev);

        try {
            File f = new File("RestaurantReview.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(rev);

            ResturantreviewDetailsLabel.setText("Thank you for your feedback!");

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResreviewnameTextField.clear();
        ResreviewTextArea.clear();
        ResratingComboBox.setValue(null);
    }
}
