package cse.fivestarhotel.HotelHeadManager;


import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ViewResturantReviewController
{
    @javafx.fxml.FXML
    private TableColumn<Reviews,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Reviews,String> ratingCol;
    @javafx.fxml.FXML
    private TableView<Reviews> ViewRestaurantReviewTableView;
    @javafx.fxml.FXML
    private TableColumn<Reviews,String> descriptionCol;

    @javafx.fxml.FXML
    public void initialize() {
        //String name, String rating, String review
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("review"));


    }



    @javafx.fxml.FXML
    public void viewResturantReviewOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("RestaurantReview.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            ViewRestaurantReviewTableView.getItems().clear();

            while(true) {
                ViewRestaurantReviewTableView.getItems().add((Reviews) ois.readObject());


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
}