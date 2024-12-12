package cse.fivestarhotel.HotelGuest;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import cse.fivestarhotel.RestaurantManager.Menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ViewMenuController implements Serializable {

    @javafx.fxml.FXML
    private Label viewmenulabel;

    @javafx.fxml.FXML
    public void viewMenuOnAction(ActionEvent actionEvent) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("MenuDetails.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
                viewmenulabel.setText("error");
                return;
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            StringBuilder menuDetails = new StringBuilder();

            while (true) {
                try {
                    Menu menu = (Menu) ois.readObject();
                    menuDetails.append(formatMenuDetails(menu)).append("\n");
                } catch (Exception e) {
                    break;
                }
            }
            viewmenulabel.setText(menuDetails.toString());

        } catch (Exception e) {
            viewmenulabel.setText("oops- guess you're gonna have to be hungry");
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {

            }
        }
    }

    // Helper method to format menu details
    private String formatMenuDetails(Menu menu) {
        return "Dish Name: " + menu.getDishname() + "\n" +
                "Dish Type: " + menu.getDishtype() + "\n" +
                "Meal Type: " + menu.getMealtype() + "\n" +
                "Price: $" + menu.getPrice() + "\n" +
                "⊹------⊹------⊹------⊹------⊹------⊹";
    }
}
