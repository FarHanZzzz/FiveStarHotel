package cse.fivestarhotel.FrontDeskStaff;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class ViewBookEventController
{
    @javafx.fxml.FXML
    private TableColumn<Book, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Book,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Book,String> emailCol;
    @javafx.fxml.FXML
    private TableColumn<Book,String> timingCol;
    @javafx.fxml.FXML
    private TableColumn<Book,String> eventtypeCol;
    @javafx.fxml.FXML
    private TableColumn<Book,String> additionalNotesCol;
    @javafx.fxml.FXML
    private TableView<Book> BookTable;



    ObservableList<Book> Booklist = FXCollections.observableArrayList();




    @javafx.fxml.FXML

    //String name, String email, LocalDate date, String timing, String additionalNotes
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timingCol.setCellValueFactory(new PropertyValueFactory<>("timing"));
        additionalNotesCol.setCellValueFactory(new PropertyValueFactory<>("additionalNotes"));





    }

    @javafx.fxml.FXML
    public void ViewBookEventDetailsOnAction(ActionEvent actionEvent) {
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

            BookTable.getItems().clear();

            while(true) {
                BookTable.getItems().add((Book) ois.readObject());


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
