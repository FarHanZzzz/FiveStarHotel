package cse.fivestarhotel.RoomServiceManager;

import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ViewReviewsController implements Serializable
{
    @javafx.fxml.FXML
    private TableColumn ColReview;
    @javafx.fxml.FXML
    private TableColumn ColName;
    @javafx.fxml.FXML
    private TableColumn ColRating;
    @javafx.fxml.FXML
    private TableView ReviewTableView;

    @javafx.fxml.FXML
    public void initialize() {

        //String name, String rating, String review
        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        ColReview.setCellValueFactory(new PropertyValueFactory<>("review"));


    }


    @javafx.fxml.FXML
    public void ViewGuestReviews(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("HotelGuestReview.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            ReviewTableView.getItems().clear();

            while(true) {
                ReviewTableView.getItems().add((Reviews) ois.readObject());

            }


        }
        catch(Exception e) {
            try {
                if (ois != null) ois.close();

            } catch (Exception e2) {
                //

            }

        }
    }
}