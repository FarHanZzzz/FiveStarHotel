package cse.fivestarhotel.RestaurantManager;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SubmitPerformanceReportController
{
    @javafx.fxml.FXML
    private Label Status;
    @javafx.fxml.FXML
    private TextField totalSpentTextField;
    @javafx.fxml.FXML
    private TextField attendenceTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField SummaryTextField;
    @javafx.fxml.FXML
    private ComboBox<String> satisfactionComboBox;
    @javafx.fxml.FXML
    private Label StatusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> MonthComboBox;

    ObservableList<PerformanceReport> performanceList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        satisfactionComboBox.getItems().addAll("★", "★★", "★★★", "★★★★","★★★★★");
        MonthComboBox.getItems().addAll("January", "February", "March", "April" , "May", "June", "July", "August", "September", "October", "November", "December");



    }

    @javafx.fxml.FXML
    public void submitPerformanceReportOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String summary = SummaryTextField.getText();
        int totalSpent;
        int attendence;
        String satisfaction = satisfactionComboBox.getValue();
        String month = MonthComboBox.getValue();

        if (name.isEmpty() || summary.isEmpty()  || satisfaction.isEmpty() || month.isEmpty()){
            StatusLabel.setText("Please fill all the fields");
        }


               try {
                    totalSpent = Integer.parseInt(totalSpentTextField.getText());
                    attendence = Integer.parseInt(attendenceTextField.getText());

                } catch (NumberFormatException e) {
                    StatusLabel.setText("invalid input");
                    return;
                }


        PerformanceReport p = new PerformanceReport(name,satisfaction,month,totalSpent,attendence,summary);
        performanceList.add(p);

        try{
            File f = new File("RestaurantManagerPerformance.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);

            }else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(p);

            StatusLabel.setText("Sumitted Successfully : "+ p.toString());

            nameTextField.clear(); SummaryTextField.clear(); totalSpentTextField.clear();
            attendenceTextField.clear(); satisfactionComboBox.setValue(null);
            MonthComboBox.setValue(null);




        }catch (Exception e ){
            e.printStackTrace();
        }











    }
}