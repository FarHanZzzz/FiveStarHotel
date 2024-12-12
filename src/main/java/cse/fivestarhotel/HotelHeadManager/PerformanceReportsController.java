package cse.fivestarhotel.HotelHeadManager;

import cse.fivestarhotel.RestaurantManager.Menu;
import cse.fivestarhotel.RestaurantManager.PerformanceReport;
import cse.fivestarhotel.FrontDeskStaff.CheckInTableDummyClass;
import cse.fivestarhotel.RestaurantManager.PerformanceReport;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class PerformanceReportsController
{

    @javafx.fxml.FXML
    private TableColumn eleMonthCol;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String> RescustomersatisCol;
    @javafx.fxml.FXML
    private TableColumn elerestotalspentCol;
    @javafx.fxml.FXML
    private TableColumn eleAttendanceCol;
    @javafx.fxml.FXML
    private TableColumn roomtotalspentCol;
    @javafx.fxml.FXML
    private TableColumn roomAttendanceCol;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String>  restotalspentCol;
    @javafx.fxml.FXML
    private TableColumn roomcustomersatisCol;
    @javafx.fxml.FXML
    private TableColumn elecustomersatisCol;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String>  ResAttendanceCol;
    @javafx.fxml.FXML
    private TableColumn roomMonthCol;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String>   ResMonthCol;
    @javafx.fxml.FXML
    private TableView<PerformanceReport>  resPerformanceTableView;
    @javafx.fxml.FXML
    private TableView roomPerformanceTableView;
    @javafx.fxml.FXML
    private TableView elePerformanceTableView;

    @javafx.fxml.FXML
    public void initialize() {

        ResMonthCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        RescustomersatisCol.setCellValueFactory(new PropertyValueFactory<>("customerSatisfaction"));
        restotalspentCol.setCellValueFactory(new PropertyValueFactory<>("totalSpent"));
        ResAttendanceCol.setCellValueFactory(new PropertyValueFactory<>("EmployeeAttendenceRate"));


        roomMonthCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        roomcustomersatisCol.setCellValueFactory(new PropertyValueFactory<>("customerSatisfaction"));
        roomtotalspentCol.setCellValueFactory(new PropertyValueFactory<>("totalSpent"));
        roomAttendanceCol.setCellValueFactory(new PropertyValueFactory<>("EmployeeAttendenceRate"));


        eleMonthCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        elecustomersatisCol.setCellValueFactory(new PropertyValueFactory<>("customerSatisfaction"));
        elerestotalspentCol.setCellValueFactory(new PropertyValueFactory<>("totalSpent"));
        eleAttendanceCol.setCellValueFactory(new PropertyValueFactory<>("EmployeeAttendenceRate"));



    }

    @javafx.fxml.FXML
    public void resPerformaneOnAction(ActionEvent actionEvent) {

        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("RestaurantManagerPerformance.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            resPerformanceTableView.getItems().clear();

            while(true) {
                resPerformanceTableView.getItems().add((PerformanceReport) ois.readObject());


                //CheckinTableView.setItems(CheckinTabledataList);
            }
            //ois.close();

        }
        catch(Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
                //

            }


        }
    }


    @javafx.fxml.FXML
    public void elePerformaneOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void roomPerformaneOnAction(ActionEvent actionEvent) {
    }
}