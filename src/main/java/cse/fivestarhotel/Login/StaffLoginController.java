package cse.fivestarhotel.Login;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StaffLoginController
{
    @javafx.fxml.FXML
    private TextField StaffIdTextField;
    @javafx.fxml.FXML
    private PasswordField StaffPasswordPasswordField;
    @javafx.fxml.FXML
    private ComboBox<String> positionComboBox;

    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void StaffLogInOnAction(ActionEvent actionEvent) throws IOException {

    }







    @javafx.fxml.FXML
    public void FromStaffReturnToSigninOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }
}