package cse.fivestarhotel.RestaurantManager;

import cse.fivestarhotel.HotelGuest.Reviews;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewRestaurantReviewController
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

    }



    @javafx.fxml.FXML
    public void viewRestaurantReviewOnAction(ActionEvent actionEvent) {




    }
}