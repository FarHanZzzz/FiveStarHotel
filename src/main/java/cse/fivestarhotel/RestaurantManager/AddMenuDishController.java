package cse.fivestarhotel.RestaurantManager;

import cse.fivestarhotel.FrontDeskStaff.CheckInTableDummyClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AddMenuDishController implements Serializable
{
    @javafx.fxml.FXML
    private ComboBox<String> mealTypeComboBox;
    @javafx.fxml.FXML
    private Label MenuDetailsLabel;
    @javafx.fxml.FXML
    private ComboBox<String> dishTypeComboBox;
    @javafx.fxml.FXML
    private TextField dishPriceTextField;
    @javafx.fxml.FXML
    private TextField dishNameTextField;

    ObservableList<Menu> menudetails = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        dishTypeComboBox.getItems().addAll("Vegeterian","Non- Vegeterian");
        mealTypeComboBox.getItems().addAll("Breakfast","Lunch","Dinner");



    }

    @javafx.fxml.FXML
    public void addDishToMenuOnAction(ActionEvent actionEvent) {

        String name = dishNameTextField.getText();
        Integer price = Integer.valueOf(dishPriceTextField.getText());
        String dishtype = dishTypeComboBox.getValue();
        String mealtype = mealTypeComboBox.getValue();



        if (name.isEmpty() ||  dishtype.isEmpty() || mealtype.isEmpty()){
            MenuDetailsLabel.setText("Please fill all the fields");
        }


        Menu s = new Menu(name, dishtype,mealtype,price);
        menudetails.add(s);


        try {

            File f = new File("MenuDetails.bin");

            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);


            for(Menu m : menudetails){
                oos.writeObject(m);
                MenuDetailsLabel.setText("Menu is added " + m.toString());

            }


            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }

    @javafx.fxml.FXML
    public void clearfieldsOnAction(ActionEvent actionEvent) {
        dishNameTextField.clear();
        dishPriceTextField.clear();
        dishPriceTextField.clear();
        mealTypeComboBox.setValue(null);

    }


}