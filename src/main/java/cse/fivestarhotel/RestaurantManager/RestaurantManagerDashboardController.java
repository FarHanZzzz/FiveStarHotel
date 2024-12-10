package cse.fivestarhotel.RestaurantManager;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RestaurantManagerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane dashBoardBorderPane;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void ViewAnnouncementOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/ViewAnnouncement.fxml"));
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
}