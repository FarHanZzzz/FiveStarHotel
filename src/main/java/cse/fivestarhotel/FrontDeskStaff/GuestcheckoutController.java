package cse.fivestarhotel.FrontDeskStaff;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GuestcheckoutController implements Serializable
{
    @javafx.fxml.FXML
    private Label StatusLabel;
    @javafx.fxml.FXML
    private TextField GuestcheckoutEmailTextfield;
    @javafx.fxml.FXML
    private TextArea checkoutTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }



    @javafx.fxml.FXML
    public void CheckoutOnAction(ActionEvent actionEvent) throws FileNotFoundException {
        String email = GuestcheckoutEmailTextfield.getText();




        if (email.isEmpty()) {
            StatusLabel.setText("Please fill the Email field");
        }

        if (!isValidEmail(email)) {
            StatusLabel.setText("Invalid email address.");
            return;
        }


        File file = new File("CheckInGuestDetails.bin");
        if (!file.exists()) {
            StatusLabel.setText("No guest details found");
            return;
        }

        List<CheckInTableDummyClass> guestlist = new ArrayList<>();


        CheckInTableDummyClass checkedoutGuest = null;

        // Step 1: Read all objects and identify the one to delete
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    CheckInTableDummyClass guest = (CheckInTableDummyClass) ois.readObject();
                    if (guest.getEmail().equalsIgnoreCase(email)) {
                        checkedoutGuest = guest; // Found the guest to remove
                    } else {
                        guestlist.add(guest); // Keep all other guests
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    StatusLabel.setText("Class not found during object deserialization.");
                    return;
                }
            }


        } catch (FileNotFoundException e) {
            StatusLabel.setText("The file does not exist.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            StatusLabel.setText("Error reading guest details: " + e.getMessage());
            e.printStackTrace();
            return;
        }


        // Check if the guest was found
        if (checkedoutGuest == null) {
            StatusLabel.setText("Guest with email " + email + " not found");
            return;
        }


        // Step 2: Rewrite the file with the remaining guests
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (CheckInTableDummyClass guest : guestlist) {
                oos.writeObject(guest);
            }


        } catch (IOException e) {
            StatusLabel.setText("Error updating guest details: " + e.getMessage());
            e.printStackTrace();
            return;
        }


        // Step 3: Show removed guest details
        checkoutTextArea.setText("Checked out guest details:\n" + checkedoutGuest.toString());
        StatusLabel.setText("Guest checked out successfully");
        GuestcheckoutEmailTextfield.clear();

    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }



}