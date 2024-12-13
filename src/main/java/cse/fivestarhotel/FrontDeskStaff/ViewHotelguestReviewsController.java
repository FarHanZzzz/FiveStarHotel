package cse.fivestarhotel.FrontDeskStaff;

import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ViewHotelguestReviewsController implements Serializable
{
    @javafx.fxml.FXML
    private TableColumn<Reviews,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Reviews,String> ratingCol;
    @javafx.fxml.FXML
    private TableColumn<Reviews,String> reviewCol;
    @javafx.fxml.FXML
    private TableView<Reviews> ReviewTableView;


    @javafx.fxml.FXML
    public void initialize() {

        //String name, String rating, String review
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        reviewCol.setCellValueFactory(new PropertyValueFactory<>("review"));


    }


    @javafx.fxml.FXML
    public void ViewHotelGuestReviews(ActionEvent actionEvent) {
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