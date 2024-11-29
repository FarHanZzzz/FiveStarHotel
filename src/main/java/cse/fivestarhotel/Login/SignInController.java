package cse.fivestarhotel.Login;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController
{
    @javafx.fxml.FXML
    public void initialize() {

    }


    @javafx.fxml.FXML
    public void SignInAsStaffOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/StaffLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();



//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scene1view.fxml"));
//        Scene viewscene = new Scene(fxmlLoader.load());
//        Stage tempstage = (Stage)((Node)actionevent.getSource()).getScene().getWindow();
//        tempstage.setTitle("Hello!");
//        tempstage.setScene(viewscene);
//        tempstage.show();




    }

    @javafx.fxml.FXML
    public void SignInAsGuestOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/GuestLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();


    }
}