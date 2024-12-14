package cse.fivestarhotel.HotelHeadManager;

import com.sun.tools.javac.Main;
import cse.fivestarhotel.CEO.Announcement;
import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class HeadManagerDashboardController {
    @javafx.fxml.FXML
    private BorderPane DashboardBorderPaneHeadManager;
    @javafx.fxml.FXML
    private TableColumn<Announcement, String> announcementsCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<Announcement> AnnouncementTableView;
    @javafx.fxml.FXML
    private TableColumn<Announcement, String> positionCol;

    @javafx.fxml.FXML
    public void initialize() {

        announcementsCol.setCellValueFactory(new PropertyValueFactory<>("announcement"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));


        FileInputStream fis = null;
        ObjectInputStream ois = null;


        try {
            File f = new File("AnnoncementsDetails.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
                //Alert: file does not exist
            }
            if (fis != null) ois = new ObjectInputStream(fis);

            AnnouncementTableView.getItems().clear();

            while (true) {
                AnnouncementTableView.getItems().add((Announcement) ois.readObject());


                //CheckinTableView.setItems(CheckinTabledataList);
            }
            //ois.close();

        } catch (Exception e) {
            try {
                if (ois != null) ois.close();

            } catch (Exception e2) {
                //

            }
        }
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
        } catch (Exception e) {
        }

    }


    @javafx.fxml.FXML
    public void PostANNOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/PostAnnouncement.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        } catch (Exception e) {
        }

    }


    @javafx.fxml.FXML
    public void performancereportsOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/PerformanceReports.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        } catch (Exception e) {
        }

    }


    @javafx.fxml.FXML
    public void viewbudgetOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/ViewBudget.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        } catch (Exception e) {
        }

    }


    @javafx.fxml.FXML
    public void hotelguestreviewsOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/ViewCustomerReviews.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        } catch (Exception e) {
        }

    }


    @javafx.fxml.FXML
    public void hotelgresreviewsOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/ViewResturantReviews.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        } catch (Exception e) {
        }

    }


    @javafx.fxml.FXML
    public void staffinquiriesOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/ViewStaffIquiries.fxml"));

            DashboardBorderPaneHeadManager.setRight(fxmlLoader.load());
        } catch (Exception e) {
        }

    }


    @javafx.fxml.FXML
    public void HeadManagerLogoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }
}