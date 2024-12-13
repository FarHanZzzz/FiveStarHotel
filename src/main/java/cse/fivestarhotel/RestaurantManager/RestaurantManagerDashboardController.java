package cse.fivestarhotel.RestaurantManager;

import cse.fivestarhotel.CEO.Announcement;
import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class RestaurantManagerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane dashBoardBorderPane;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<Announcement> AnnouncementTableView;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> AnnouncementCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> positionCol;

    @javafx.fxml.FXML
    public void initialize() {

        AnnouncementCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("announcement"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));


        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("AnnoncementsDetails.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            AnnouncementTableView.getItems().clear();

            while(true) {
                AnnouncementTableView.getItems().add((Announcement) ois.readObject());


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
    public void addDishMenuOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/AddMenuDish.fxml"));

            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void ViewRestaurantReview(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/ViewRestaurantReview.fxml"));
            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}

    }


    @javafx.fxml.FXML
    public void ViewGuestReservationTableOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/ViewguestReservationTable.fxml"));
            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}


    }

    @javafx.fxml.FXML
    public void removeDishMenuOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/RemoveDishMenu.fxml"));
            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void ViewMenuDetailsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/ViewMenuDetails.fxml"));
            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}



    }

    @javafx.fxml.FXML
    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/RestaurantManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitPerformanceReportOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/SubmitPerformanceReport.fxml"));
            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }
}