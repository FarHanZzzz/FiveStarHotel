package cse.fivestarhotel.CEO;

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

public class CEODashBoardController
{
    @javafx.fxml.FXML
    private BorderPane CeoDashBoardBorderPane;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> announcementsCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> dateCol;
    @javafx.fxml.FXML
    private TableView<Announcement> AnnouncementTableView;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> positionCol;

    @javafx.fxml.FXML
    public void initialize() {

        announcementsCol.setCellValueFactory(new PropertyValueFactory<>("announcement"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
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
    public void sponsershipCampaignButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/sponsershipCampaigns.fxml"));


            CeoDashBoardBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }


    @javafx.fxml.FXML
    public void monthlyGoalsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/UpdateMonthlygoals.fxml"));


            CeoDashBoardBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void ViewRevOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/ViewRevenueReport.fxml"));


            CeoDashBoardBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void BackToDashboardCEOOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/CEODashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void CEOLogoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void CustomerReviewsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/ViewCustomerReviews.fxml"));


            CeoDashBoardBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void PostannouncementOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/Annoncement.fxml"));


            CeoDashBoardBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }
}