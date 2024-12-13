package cse.fivestarhotel.CEO;

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


    @javafx.fxml.FXML
    public void initialize() {
        ResmonthComboBox.getItems().addAll("January", "February", "March", "April" , "May", "June", "July", "August", "September", "October", "November", "December");

    }

    @javafx.fxml.FXML
    public void postRESbudgetOnAction(ActionEvent actionEvent) {
        String budget = RESbudgetTextField.getText();
        String month = ResmonthComboBox.getValue();

        if (budget.isEmpty() || month.isEmpty()){
            budgetStatusLabel.setText("Please fill all the fields");

        }


        Budget b  = new Budget(budget, month);
        budgets.add(b);

        try {
            File f = new File("ResBudgetUp.bin");
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
            budgetStatusLabel.setText("Budget posted" + "\n"+ b.toString());
            oos.writeObject(b);


            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RESbudgetTextField.clear();
        ResmonthComboBox.setValue(null);

    }

    @javafx.fxml.FXML
    public void roomBudgetOnAction(ActionEvent actionEvent) {


        String budget = RoombudgetTextField.getText();
        String month = RoommonthComboBox.getValue();

        if (budget.isEmpty() || month.isEmpty()){
            budgetStatusLabel.setText("Please fill all the fields");

        }


        Budget b  = new Budget(budget, month);
        budgets.add(b);

        try {
            File f = new File("RoomBudgetUp.bin");
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
            budgetStatusLabel.setText("Budget posted" + "\n"+ b.toString());
            oos.writeObject(b);


            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RESbudgetTextField.clear();
        ResmonthComboBox.setValue(null);

    }

}
