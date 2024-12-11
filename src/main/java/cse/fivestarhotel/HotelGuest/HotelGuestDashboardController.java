package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelGuestDashboardController
{
    @javafx.fxml.FXML
    private BorderPane DashboardBorderPaneHotelGuest;

    @javafx.fxml.FXML
    public void initialize() {

    }





































    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/HotelGuestDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }




    @javafx.fxml.FXML
    public void resturanttablebookingOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/resturantPAGE.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}


    }



    @javafx.fxml.FXML
    public void viewmenuOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/ViewMenu.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }



    @javafx.fxml.FXML
    public void GuestroomserviceOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/RoomServiceReq.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }




    @javafx.fxml.FXML
    public void laundrybookingOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/LaundryPAGE.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }





    @javafx.fxml.FXML
    public void transportationbookingOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/TransportationDetailsPAGE.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }






    @javafx.fxml.FXML
    public void GuestReviewsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/ReviewsPAGE.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }


    @Deprecated
    public void ResturantReviewOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/ReviewRESTURANTpage.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }


    @Deprecated
    public void HotelReviewOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/ReviewROOMpage.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }







    @javafx.fxml.FXML
    public void eventbookingOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/EventReservationPAGE.fxml"));

            DashboardBorderPaneHotelGuest.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }



    @javafx.fxml.FXML
    public void GuestLogoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/GuestLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }
}
