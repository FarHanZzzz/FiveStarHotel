package cse.fivestarhotel.RestaurantManager;

import cse.fivestarhotel.FrontDeskStaff.CheckInTableDummyClass;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RemoveDishMenuController implements Serializable
{

    @javafx.fxml.FXML
    private TextArea removedGuestTextArea;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {




    }




    @javafx.fxml.FXML
    public void RemoveDIshTextField(ActionEvent actionEvent) {

        String name = nameTextField.getText();

        if (name.isEmpty()){
            statusLabel.setText("Please fill the field");
        }


        File file = new File("MenuDetails.bin");

        if (!file.exists()) {
            statusLabel.setText("This Dish Cannot be found");
            return;
        }

        List<Menu> MenuList = new ArrayList<>();
        Menu removedguest = null;


        // Step 1: Read all objects and identify the one to delete
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Menu m = (Menu) ois.readObject();
                    if (m.getDishname().equalsIgnoreCase(name)) {
                        removedguest = m; // Found the guest to remove
                    } else {
                        MenuList.add(m); // Keep all other guests
                    }
                } catch (EOFException e) {
                    break; // End of file reached


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    statusLabel.setText("Class not found during object deserialization.");
                    return;
                }
            }



        } catch (FileNotFoundException e) {
            statusLabel.setText("The file does not exist.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            statusLabel.setText("Error reading guest details: " + e.getMessage());
            e.printStackTrace();
            return;
        }


        // Check if the guest was found
        if (removedguest == null) {
            statusLabel.setText("Dish with Name " + name + " not found");
            return;
        }


        // Step 2: Rewrite the file with the remaining guests
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Menu m: MenuList) {
                oos.writeObject(m);
            }


        } catch (IOException e) {
            statusLabel.setText("Error updating guest details: " + e.getMessage());
            e.printStackTrace();
            return;
        }


        removedGuestTextArea.setText("Removed Dish name :"+"\n"+ removedguest.toString());
        statusLabel.setText("Dish is REmoved SUccessfully");
        nameTextField.clear();










    }
}