package cse.fivestarhotel.FrontDeskStaff;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontDeskStaffDashboardController
{
    @javafx.fxml.FXML
    private BorderPane dashBoardBorderPane;




    //       try {
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/Guestcheckin.fxml"));
//            );
//
//            dashBoardBorderPane.setCenter(myFxmlLoader.load());
//        }
//        catch(Exception e){}



    @javafx.fxml.FXML
    public void initialize() {



    }











    @javafx.fxml.FXML
    public void roomOccupancyOnAction(ActionEvent actionEvent) {
        try {
                 FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/CheckRoomOccupancy.fxml"));


            dashBoardBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}


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

    @javafx.fxml.FXML
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


}