package cse.fivestarhotel.Login;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import cse.fivestarhotel.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

import static cse.fivestarhotel.FrontDeskStaff.alert.showAlert;

public class CreateanAccountController implements Serializable
{

    @javafx.fxml.FXML
    private PasswordField CreateAnAccountPasswordPasswordField;
    @javafx.fxml.FXML
    private DatePicker CreateAnAccountBirthdayDatepicker;
    @javafx.fxml.FXML
    private TextField CreateAnAccountNameTextField;
    @javafx.fxml.FXML
    private TextField CreateAnAccountemailTextField;

    ObservableList<CreateAccount> createlist = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private Label StatusLabel;


    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void CreateAccountOnAction(ActionEvent actionEvent) {
        String name = CreateAnAccountNameTextField.getText();
        String password = CreateAnAccountPasswordPasswordField.getText();
        LocalDate date = CreateAnAccountBirthdayDatepicker.getValue();
        String email = CreateAnAccountemailTextField.getText();

        if (name.isEmpty() || password.isEmpty() || date == null || email.isEmpty()){
            showAlert("error", "please fill all the fields");
        }

        if (!isValidEmail(email)) {
            showAlert("error","Invalid email address.");
            return;
        }


        if (date.isAfter(LocalDate.now())) {
            showAlert("invalid birthday","are you from the future?");
            return;
        }

        //int num = 8;

        if (password.length() < 8) {
           showAlert("error","password must be at least 8 letter");
            return;
        }


        //String name, String email, String password, LocalDate birthdate
        CreateAccount c = new CreateAccount(name,email,password,date);
        createlist.add(c);

        try {
            File f = new File("CreateAccountOfGuest.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;


            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            // Write the object
            oos.writeObject(c);

            StatusLabel.setText("Account Successfully Created!!!");
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


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

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }




}