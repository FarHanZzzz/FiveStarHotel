package cse.fivestarhotel.RestaurantManager;

import cse.fivestarhotel.FrontDeskStaff.CheckInTableDummyClass;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ViewMenuDetailsController implements Serializable
{
    @javafx.fxml.FXML
    private TableColumn<Menu,String> dishNameCol;
    @javafx.fxml.FXML
    private TableColumn<Menu,String> mealTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Menu,String> DishTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Menu,Integer> priceCol;
    @javafx.fxml.FXML
    private TableView<Menu> MenuTableView;

    @javafx.fxml.FXML
    public void initialize() {
        //String dishname, String dishtype, String mealtype, Integer price

        dishNameCol.setCellValueFactory(new PropertyValueFactory<>("dishname"));
        DishTypeCol.setCellValueFactory(new PropertyValueFactory<>("dishtype"));
        mealTypeCol.setCellValueFactory(new PropertyValueFactory<>("mealtype"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

    @javafx.fxml.FXML
    public void viewMenuDetailsOnAction(ActionEvent actionEvent) {

        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("MenuDetails.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            MenuTableView.getItems().clear();

            while(true) {
                MenuTableView.getItems().add((Menu) ois.readObject());


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