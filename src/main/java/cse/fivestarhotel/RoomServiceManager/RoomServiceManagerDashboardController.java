package cse.fivestarhotel.RoomServiceManager;

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

public class RoomServiceManagerDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> announcementsCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<Announcement> AnnouncementTableView;
    @javafx.fxml.FXML
    private BorderPane RoomServiceManagerBorderPane;

    @javafx.fxml.FXML
    public void initialize() {

        announcementsCol.setCellValueFactory(new PropertyValueFactory<>("announcement"));
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
    public void submitQueriesOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RoomServiceManager/SubmitInquiryPage.fxml"));

            RoomServiceManagerBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}

    }

    @Deprecated
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SpecialRequestsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RoomServiceManager/SpecialRequestPage.fxml"));

            RoomServiceManagerBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void ViewReviewsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RoomServiceManager/ViewReviews.fxml"));

            RoomServiceManagerBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @Deprecated
    public void ViewBudgetOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void AnnouncementOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void LostAndFoundOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void WorkerScheduleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitPerformanceReportOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RoomServiceManager/SubmitPerformanceReportt.fxml"));

            RoomServiceManagerBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }


    @javafx.fxml.FXML
    public void RoomServiceManagerLogoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void ViewElectricianReportOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RoomServiceManager/ViewElectricianReport.fxml"));

            RoomServiceManagerBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }
}