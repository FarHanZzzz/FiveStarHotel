package cse.fivestarhotel.Login;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

import static cse.fivestarhotel.FrontDeskStaff.alert.showAlert;
import static cse.fivestarhotel.Login.CreateanAccountController.isValidEmail;

public class GuestLoginController implements Serializable
{
    @javafx.fxml.FXML
    private TextField GuestPasswordTextField;
    @javafx.fxml.FXML
    private TextField GuestEmailTextfield;

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

        String email   =  GuestEmailTextfield.getText();
        String password = GuestPasswordTextField.getText();


        if (email.isEmpty() || password.isEmpty()){
            showAlert("Error","Please fill all the Fields");
        }

        if (!isValidEmail(email)) {
            showAlert("error","Invalid email address.");
            return;
        }




        try {
            File f = new File("CreateAccountOfGuest.bin");
            if (!f.exists()) {
                showAlert("error","Guest account file does not exist.");
                return;

            }

            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            boolean isMatched = false;
            while (true) {
                try {
                    // Deserialize the object
                    CreateAccount c = (CreateAccount) ois.readObject();

                    // Compare input credentials
                    if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/HotelGuestDashboard.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                        stage.setTitle("Hello");
                        stage.setScene(scene);
                        stage.show();
                        isMatched = true;
                        break;
                    }
                } catch (EOFException eof) {
                    // End of file reached
                    break;
                }
            }

            ois.close();

            if (!isMatched){
                showAlert("Error","Email or password is incorrect.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An unexpected error occurred while logging in.");
        }















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