package cse.fivestarhotel.HotelHeadManager;

import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import cse.fivestarhotel.RestaurantManager.Menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

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

    @Deprecated
    public void loadResBudgetOnAction(ActionEvent actionEvent) {

        ObservableList<Budget> budgets = FXCollections.observableArrayList();

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("ResBudgetUp.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
                viewbudlabel.setText("error");
                return;
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Budget b = (Budget) ois.readObject();
                } catch (Exception e) {
                    break;
                }
            }
            viewbudlabel.setText(budgets.toString());

        } catch (Exception e) {
            viewbudlabel.setText("not yet uploaded");
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {

            }
        }
    }

    @javafx.fxml.FXML
    public void loadRoomBudgetOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadEleBudgetOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTransportBudgetOnAction(ActionEvent actionEvent) {
    }

}
