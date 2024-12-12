package cse.fivestarhotel.HotelHeadManager;

import cse.fivestarhotel.FrontDeskStaff.Query;
import cse.fivestarhotel.HotelGuest.Reviews;
import cse.fivestarhotel.RestaurantManager.PerformanceReport;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ViewStaffIquiriesController implements Serializable {


    @javafx.fxml.FXML
    private TableColumn<Query,String> QnameCol;
    @javafx.fxml.FXML
    private TableColumn<Query,String> QpositionCol;
    @javafx.fxml.FXML
    private TableColumn<Query,String> QquiryCol;
    @javafx.fxml.FXML
    private TableView<Query> QueryTableView;

    @javafx.fxml.FXML
    public void initialize() {

//String name, String position, String description

        QnameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        QpositionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        QquiryCol.setCellValueFactory(new PropertyValueFactory<>("description"));

    }

    @javafx.fxml.FXML
    public void LoadQuiryOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("QueryReview.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            QueryTableView.getItems().clear();

            while(true) {
                QueryTableView.getItems().add((Query) ois.readObject());


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