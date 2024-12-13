package cse.fivestarhotel.FrontDeskStaff;

import cse.fivestarhotel.CEO.Announcement;
import cse.fivestarhotel.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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
import java.util.PropertyPermission;

public class FrontDeskStaffDashboardController
{
    @javafx.fxml.FXML
    private BorderPane dashBoardBorderPane;
    @javafx.fxml.FXML
    private TableView<Announcement> AnnouncementTableView;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> announcementCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> positionCol;


    @javafx.fxml.FXML
    public void initialize() {
        //String announcement, LocalDate date

        announcementCol.setCellValueFactory(new PropertyValueFactory<>("position"));
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
    public void guestDetailsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/AccessGuestDetails.fxml"));
            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}


    }

    @javafx.fxml.FXML
    public void transportationDetailsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/ViewTransportationServiceDetails.fxml"));


            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}

    }

    @javafx.fxml.FXML
    public void hotelGuestReviewsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/ViewHotelguestReviews.fxml"));


            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}

    }

    @javafx.fxml.FXML
    public void checkinOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/Guestcheckin.fxml"));


            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}

    }

    @javafx.fxml.FXML
    public void checkoutOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/Guestcheckout.fxml"));


            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}

    }

    @Deprecated
    public void ViewBookeventOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/ViewBookEvent.fxml"));

            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}


    }

    @javafx.fxml.FXML
    public void FrontDeskStaffDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/FrontDeskStaffDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void BookedEventDetailsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/ViewBookEvent.fxml"));


            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}


    }


    //Submit Queries

    @javafx.fxml.FXML
    public void SubmitQueriesOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/Submit Queries.fxml"));


            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}


    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }
}