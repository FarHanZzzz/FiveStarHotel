package cse.fivestarhotel.HotelGuest;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class HotelGuestDashboardController
{
    @javafx.fxml.FXML
    private BorderPane DashboardBorderPaneHotelGuest;

    @javafx.fxml.FXML
    public void initialize() {

    }



    @javafx.fxml.FXML
    public void resturanttablebookingOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelGuest/restaurantPAGE.fxml"));


            DashboardBorderPaneHotelGuest.setRight(fxmlLoader.load());
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
}