package cse.fivestarhotel.HotelHeadManager;

import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import cse.fivestarhotel.RestaurantManager.Menu;

import java.io.*;

public class ViewBudgetController implements Serializable {

    @javafx.fxml.FXML
    private Label viewTransportBudget;
    @javafx.fxml.FXML
    private Label viewEleBudget;
    @javafx.fxml.FXML
    private Label viewRoomBudget;
    @javafx.fxml.FXML
    private Label viewResBudget;
    @javafx.fxml.FXML
    private Label viewbudlabel;
    @javafx.fxml.FXML
    private Label ViewTotalBudget;

    @javafx.fxml.FXML
    public void loadResBudgetOnAction() {
        File f = new File("ResBudgets.bin");

        if (!f.exists()) {
            viewResBudget.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Budget a = (Budget) ois.readObject();

            // Display the Budget object in the label
            viewResBudget.setText("Budget Details:\n" + a.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            viewResBudget.setText("Error reading budget file.");
        }
    }



    @javafx.fxml.FXML
    public void loadRoomBudgetOnAction(ActionEvent actionEvent) {
        File f = new File("RoomBudgetUp.bin");

        if (!f.exists()) {
            viewRoomBudget.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Budget b = (Budget) ois.readObject();

            // Display the Budget object in the label
            viewRoomBudget.setText("Budget Details:\n" + b.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            viewRoomBudget.setText("Error reading budget file.");
        }
    }

    @javafx.fxml.FXML
    public void loadEleBudgetOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void loadTransportBudgetOnAction(ActionEvent actionEvent) {
        File f = new File("TransBudgetUp.bin");

        if (!f.exists()) {
            viewTransportBudget.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Budget c = (Budget) ois.readObject();

            // Display the Budget object in the label
            viewTransportBudget.setText("Budget Details:\n" + c.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            viewTransportBudget.setText("Error reading budget file.");
        }
    }

    @javafx.fxml.FXML
    public void loadTotalBudgetOnAction(ActionEvent actionEvent) {
        File f = new File("TotalBudgetUp.bin");

        if (!f.exists()) {
            ViewTotalBudget.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Budget d = (Budget) ois.readObject();

            // Display the Budget object in the label
            ViewTotalBudget.setText("Budget Details:\n" + d.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            ViewTotalBudget.setText("Error reading budget file.");
        }
    }
}
