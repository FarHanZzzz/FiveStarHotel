package cse.fivestarhotel.CEO;

import cse.fivestarhotel.HotelGuest.Reviews;
import cse.fivestarhotel.HotelHeadManager.Revenue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;

import java.io.*;

public class ViewRevenueReportController implements Serializable {

    @javafx.fxml.FXML
    private Label viewResrev;
    @javafx.fxml.FXML
    private Label viewtotalrev;
    @javafx.fxml.FXML
    private Label viewTransrev;
    @javafx.fxml.FXML
    private Label viewRoomrev;

    @javafx.fxml.FXML
    public void loadResRevOnAction() {
        File f = new File("ResBudgets.bin");

        if (!f.exists()) {
            viewResrev.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Revenue r = (Revenue) ois.readObject();

            // Display the Budget object in the label
            viewResrev.setText("Budget Details:\n" + r.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            viewResrev.setText("Error reading budget file.");
        }
    }



    @javafx.fxml.FXML
    public void loadRoomRevOnAction(ActionEvent actionEvent) {
        File f = new File("Roomrev.bin");

        if (!f.exists()) {
            viewRoomrev.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Revenue s = (Revenue) ois.readObject();

            // Display the Budget object in the label
            viewRoomrev.setText("Room Service revenue:\n" + s.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            viewRoomrev.setText("Error reading budget file.");
        }
    }

    @javafx.fxml.FXML
    public void loadTransRevOnAction(ActionEvent actionEvent) {
        File f = new File("Transrev.bin");

        if (!f.exists()) {
            viewTransrev.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Revenue u = (Revenue) ois.readObject();

            // Display the Budget object in the label
            viewTransrev.setText("Transport revenue:\n" + u.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            viewTransrev.setText("Error reading budget file.");
        }
    }


    @javafx.fxml.FXML
    public void loadTotalRevOnAction(ActionEvent actionEvent) {
        File f = new File("Totalrev.bin");

        if (!f.exists()) {
            viewtotalrev.setText("No budget data found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the single Budget object
            Revenue t = (Revenue) ois.readObject();

            // Display the Budget object in the label
            viewtotalrev.setText("total revenue:\n" + t.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            viewtotalrev.setText("Error reading budget file.");
        }
    }

}
