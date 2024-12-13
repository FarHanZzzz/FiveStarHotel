package cse.fivestarhotel.FrontDeskStaff;

import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SubmitQueriesController implements Serializable
{
    @javafx.fxml.FXML
    private TextArea DescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> PositionComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label QueryStatusLabel;

    ObservableList<Query> queries = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        PositionComboBox.getItems().addAll("FrontDeskStaff","Room Service Manager","Restaurant Manager","Room Service Worker");

        
    }

    @javafx.fxml.FXML
    public void submitQueriesOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String position = PositionComboBox.getValue();
        String description = DescriptionTextArea.getText();


        if (name.isEmpty() || position.isEmpty() || description.isEmpty()){
            QueryStatusLabel.setText("Please fill all the fields");

        }

        Query q  = new Query(name,position,description);
        queries.add(q);




        try {
            File f = new File("QueryReview.bin");
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
            QueryStatusLabel.setText("Successfully Query Submitted" + "\n"+ q.toString());
            oos.writeObject(q);



            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }






    }


    @javafx.fxml.FXML
    public void clearFieldsOnAction(ActionEvent actionEvent) {
        nameTextField.clear();
        PositionComboBox.setValue(null);
        DescriptionTextArea.clear();


    }
}