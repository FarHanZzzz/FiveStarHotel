package cse.fivestarhotel.HotelHeadManager;


import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import cse.fivestarhotel.HotelHeadManager.Budget;
import cse.fivestarhotel.FrontDeskStaff.Query;
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

public class MonthlyRevenueController
{

    ObservableList<Revenue> rev = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private ComboBox<String> resmonthComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> transMonthComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> totalBudgetComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> roommonthComboBox;
    @javafx.fxml.FXML
    private TextField RoomrevTextField;
    @javafx.fxml.FXML
    private TextField TransrevTextField;
    @javafx.fxml.FXML
    private TextField TotalrevTextField;
    @javafx.fxml.FXML
    private TextField RESrevTextField;
    @javafx.fxml.FXML
    private Label revStatusLabel;


    @javafx.fxml.FXML
    public void initialize() {
        resmonthComboBox.getItems().addAll("January", "February", "March", "April" , "May", "June", "July", "August", "September", "October", "November", "December");
        roommonthComboBox.getItems().addAll("January", "February", "March", "April" , "May", "June", "July", "August", "September", "October", "November", "December");
        transMonthComboBox.getItems().addAll("January", "February", "March", "April" , "May", "June", "July", "August", "September", "October", "November", "December");
        totalBudgetComboBox.getItems().addAll("January", "February", "March", "April" , "May", "June", "July", "August", "September", "October", "November", "December");




    }

    @javafx.fxml.FXML
    public void postRESrevOnAction(ActionEvent actionEvent) {
        String revenue = RESrevTextField.getText();
        String month = resmonthComboBox.getValue();

        if (revenue.isEmpty() || month.isEmpty()){
            revStatusLabel.setText("Please fill all the fields");

        }


        Revenue r  = new Revenue(revenue, month);
        rev.add(r);

        try {
            File f = new File("Resrev.bin");
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
            revStatusLabel.setText("restaurant revenue submitted" + "\n"+ r.toString());
            oos.writeObject(r);


            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RESrevTextField.clear();
        resmonthComboBox.setValue(null);

    }

    @javafx.fxml.FXML
    public void roomrevOnAction(ActionEvent actionEvent) {


        String revenue = RoomrevTextField.getText();
        String month = roommonthComboBox.getValue();

        if (revenue.isEmpty() || month.isEmpty()){
            revStatusLabel.setText("Please fill all the fields");

        }


        Revenue s  = new Revenue(revenue, month);
        rev.add(s);

        try {
            File f = new File("Roomrev.bin");
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
            revStatusLabel.setText("room service revenue submitted" + "\n"+ s.toString());
            oos.writeObject(s);


            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RoomrevTextField.clear();
        roommonthComboBox.setValue(null);

    }

    @javafx.fxml.FXML
    public void TotalrevOnAction(ActionEvent actionEvent) {
        String revenue = TotalrevTextField.getText();
        String month = totalBudgetComboBox.getValue();

        if (revenue.isEmpty() || month.isEmpty()){
            revStatusLabel.setText("Please fill all the fields");

        }


        Revenue t  = new Revenue(revenue, month);
        rev.add(t);

        try {
            File f = new File("Totalrev.bin");
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
            revStatusLabel.setText("total revenue submitted" + "\n"+ t.toString());
            oos.writeObject(t);


            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TotalrevTextField.clear();
        totalBudgetComboBox.setValue(null);

    }

    @javafx.fxml.FXML
    public void TransrevOnAction(ActionEvent actionEvent) {
        String revenue = TransrevTextField.getText();
        String month = transMonthComboBox.getValue();

        if (revenue.isEmpty() || month.isEmpty()){
            revStatusLabel.setText("Please fill all the fields");

        }


        Revenue u  = new Revenue(revenue, month);
        rev.add(u);

        try {
            File f = new File("Transrev.bin");
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
            revStatusLabel.setText("transportation revenue submitted" + "\n"+ u.toString());
            oos.writeObject(u);


            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TransrevTextField.clear();
        transMonthComboBox.setValue(null);
    }
}
