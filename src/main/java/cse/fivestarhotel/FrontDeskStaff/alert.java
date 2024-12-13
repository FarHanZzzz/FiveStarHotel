package cse.fivestarhotel.FrontDeskStaff;

import javafx.scene.control.Alert;

public class alert {



    public static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
