package cse.fivestarhotel.HotelHeadManager;

import com.sun.tools.javac.Main;
import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HeadManagerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane DashboardBorderPaneHeadManager;

    @javafx.fxml.FXML
    public void initialize() {
    }




    @javafx.fxml.FXML
    public void BackToHeadManagerDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/HeadManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void monthlyrevenueOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/MonthlyRevenue.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        }
        catch(Exception e){}

    }



    @javafx.fxml.FXML
    public void postannouncementOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/PostAnnouncement.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        }
        catch(Exception e){}

    }


    @javafx.fxml.FXML
    public void performancereportsOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/PerformanceReports.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        }
        catch(Exception e){}

    }


    @javafx.fxml.FXML
    public void viewbudgetOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/ViewBudget.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        }
        catch(Exception e){}

    }


    @javafx.fxml.FXML
    public void hotelguestreviewsOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/ViewCustomerReviews.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        }
        catch(Exception e){}

    }


    @javafx.fxml.FXML
    public void staffinquiriesOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/ViewStaffIquiries.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        }
        catch(Exception e){}

    }

    @javafx.fxml.FXML
    private Button HeadManagerLogoutOnAction;


}