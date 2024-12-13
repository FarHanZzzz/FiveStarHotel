package cse.fivestarhotel.CEO;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import cse.fivestarhotel.HotelHeadManager.Budget;
import cse.fivestarhotel.FrontDeskStaff.Query;
import cse.fivestarhotel.RestaurantManager.Menu;
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
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UpdateMonthlygoalsController
{

    ObservableList<Budget> budgets = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TextField RESbudgetTextField;
    @javafx.fxml.FXML
    private ComboBox<String> ResmonthComboBox;
    @javafx.fxml.FXML
    private TextField RoombudgetTextField;
    @javafx.fxml.FXML
    private ComboBox<String> RoommonthComboBox;
    @javafx.fxml.FXML
    private Label budgetStatusLabel;

    ObservableList<Budget> allbudget = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        ResmonthComboBox.getItems().addAll("January", "February", "March", "April" , "May", "June", "July", "August", "September", "October", "November", "December");

    }

    @javafx.fxml.FXML
    public void postRESbudgetOnAction(ActionEvent actionEvent) {

        String name = RESbudgetTextField.getText();
        String month = ResmonthComboBox.getValue();

        if (name.isEmpty() || month == null) {
            budgetStatusLabel.setText("error");
        }

        Budget b = new Budget(name, month);
        allbudget.add(b);


        try (FileOutputStream fos = new FileOutputStream("ResBudgets.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(b); // Write a single Budget object
            budgetStatusLabel.setText("Posted successfully:\n" + b.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        RESbudgetTextField.clear();
        ResmonthComboBox.setValue(null);

    }

    @javafx.fxml.FXML
    public void roomBudgetOnAction(ActionEvent actionEvent) {

        RESbudgetTextField.clear();
        ResmonthComboBox.setValue(null);

    }

}
