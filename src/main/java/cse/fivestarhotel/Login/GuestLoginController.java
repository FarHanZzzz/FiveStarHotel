package cse.fivestarhotel.Login;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GuestLoginController
{
    @javafx.fxml.FXML
    private TextField GuestIdTextfield;
    @javafx.fxml.FXML
    private TextField GuestPasswordTextField;

    @javafx.fxml.FXML
    public void initialize() {


    }


    @javafx.fxml.FXML
    public void SwitchToCreateAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/CreateanAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();




    }

    @javafx.fxml.FXML
    public void GuestLoginOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FromGuestReturnToSigninOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }
}