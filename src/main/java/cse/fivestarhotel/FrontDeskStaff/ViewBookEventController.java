package cse.fivestarhotel.FrontDeskStaff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class ViewBookEventController implements Serializable
{
    @javafx.fxml.FXML
    private TableColumn<Event, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Event,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Event,String> emailCol;
    @javafx.fxml.FXML
    private TableColumn<Event,String> timingCol;
    @javafx.fxml.FXML
    private TableColumn<Event,String> eventtypeCol;
    @javafx.fxml.FXML
    private TableColumn<Event,String> additionalNotesCol;


    ObservableList<Event> BookEventlist = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableView<Event> BookEventTableView;


    @javafx.fxml.FXML

    //String name, String email, LocalDate date, String timing, String additionalNotes
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timingCol.setCellValueFactory(new PropertyValueFactory<>("timing"));
        additionalNotesCol.setCellValueFactory(new PropertyValueFactory<>("additionalNotes"));
        eventtypeCol.setCellValueFactory(new PropertyValueFactory<>("eventType"));





    }

    @javafx.fxml.FXML
    public void ViewBookEventDetailsOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try{
            File f = new File("BookEventDetails.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            BookEventTableView.getItems().clear();

            while(true) {
                BookEventTableView.getItems().add((Event) ois.readObject());


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
