package cse.fivestarhotel.Login;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateanAccountController
{

    @javafx.fxml.FXML
    private PasswordField CreateAnAccountPasswordPasswordField;
    @javafx.fxml.FXML
    private DatePicker CreateAnAccountBirthdayDatepicker;
    @javafx.fxml.FXML
    private TextField CreateAnAccountNameTextField;
    @javafx.fxml.FXML
    private TextField CreateAnAccountNidTextField;

    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void CreateAccountOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackToGuestLoginOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/GuestLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }
}