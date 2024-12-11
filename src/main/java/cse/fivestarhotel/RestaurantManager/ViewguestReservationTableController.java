package cse.fivestarhotel.RestaurantManager;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class ViewguestReservationTableController
{
    @javafx.fxml.FXML
    private TableColumn<BookTable,String> numberofPeopleCol;
    @javafx.fxml.FXML
    private TableColumn<BookTable, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<BookTable,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<BookTable,String> timeCol;
    @javafx.fxml.FXML
    private TableView<BookTable> BooktableTableView;



    //String name, String time, LocalDate date, String noofPeople
    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        numberofPeopleCol.setCellValueFactory(new PropertyValueFactory<>("noofPeople"));


    }

    @javafx.fxml.FXML
    public void viewGuestReservationTableOnAction(ActionEvent actionEvent) {


        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("BookTableDetails.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            BooktableTableView.getItems().clear();

            while(true) {
                BooktableTableView.getItems().add((BookTable) ois.readObject());


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