package cse.fivestarhotel.CEO;

import cse.fivestarhotel.FrontDeskStaff.AppendableObjectOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class sponsershipCampaignsController implements Serializable
{
    @javafx.fxml.FXML
    private TextField PotentialCompaniesNameTextField;
    @javafx.fxml.FXML
    private TextField ExpectedRevenueTextField;
    @javafx.fxml.FXML
    private TableColumn<SponsershipData,String> SponserNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<SponsershipData,String> RevenueGeneratedTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> SponsershipTypeComboBox;
    @javafx.fxml.FXML
    private TextField RevenueGeneratedTextField;
    @javafx.fxml.FXML
    private TableView<SponsershipData> SponserTableView;
    @javafx.fxml.FXML
    private ComboBox<String> SponserNameComboBox;
    @javafx.fxml.FXML
    private TableColumn<SponsershipData,String> SponsershipTypeTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> SponserShipStatusCombobox;
    @javafx.fxml.FXML
    private TableColumn<SponsershipData,String> SponserShipStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<SponsershipData,String> ExpectedRevenueTableColumn;

    private ObservableList<String> sponsorNames = FXCollections.observableArrayList();
    private ObservableList<SponsershipData> tableData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        SponserNameComboBox.setItems(sponsorNames);
        SponsershipTypeComboBox.getItems().addAll("Media Sponsorship", "Product Sponsorship", "Event Sponsorship");
        SponserShipStatusCombobox.getItems().addAll("Active Sponsorship", "Inactive Sponsorship", "Expired Sponsorship");

        // Set the cell value factory for each TableColumn
        SponserShipStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        ExpectedRevenueTableColumn.setCellValueFactory(new PropertyValueFactory<>("expectedRevenue"));
        RevenueGeneratedTableColumn.setCellValueFactory(new PropertyValueFactory<>("generatedRevenue"));
        SponserNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        SponsershipTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

    }

    @javafx.fxml.FXML
    public void AddSponserOnAction(ActionEvent actionEvent) {
        String name = PotentialCompaniesNameTextField.getText();
        String type = SponsershipTypeComboBox.getValue();
        String expectedRevenue = ExpectedRevenueTextField.getText();

        if (!name.isEmpty() && !type.isEmpty() && !expectedRevenue.isEmpty()) {
            sponsorNames.add(name); // Add sponsor name to the ComboBox
        } else {
            showAlert("Error", "Please fill in all fields to add a sponsor.");
        }
    }
    @FXML
    public void clearTable() {
        // Clear the table's observable list
        tableData.clear();

        // Optionally, you can clear the items in the TableView itself
        SponserTableView.getItems().clear();

    }

    @javafx.fxml.FXML
    public void clearTableOnAction(ActionEvent actionEvent) {
        clearTable();
    }

    @javafx.fxml.FXML
    public void LoadTableOnAction(ActionEvent actionEvent) {
        File file = new File("SponserDetails.bin");

        if (!file.exists() || file.length() == 0) {
            showAlert("Error", "The file 'SponserDetails.bin' does not exist or is empty.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Clear existing table data
            SponserTableView.getItems().clear();
            tableData.clear();

            // Read objects from the file and add them to the table
            while (true) {
                try {
                    SponsershipData data = (SponsershipData) ois.readObject();
                    tableData.add(data); // Add to ObservableList
                } catch (EOFException eof) {
                    // End of file reached
                    break;
                }
            }

            // Bind the ObservableList to the TableView
            SponserTableView.setItems(tableData);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to deserialize the sponsorship data. Class not found.");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to read sponsorship data from the file.");
        }
    }

    @javafx.fxml.FXML
    public void AddToTableOnAction(ActionEvent actionEvent) {
        String name = SponserNameComboBox.getValue();
        String status = SponserShipStatusCombobox.getValue();
        String type = SponsershipTypeComboBox.getValue();
        String expectedRevenue = ExpectedRevenueTextField.getText();
        String generatedRevenue = RevenueGeneratedTextField.getText();

        if (name != null && !status.isEmpty() && type != null && !expectedRevenue.isEmpty() && !generatedRevenue.isEmpty()) {
            SponsershipData s = new SponsershipData(name, status, type, expectedRevenue, generatedRevenue);
            tableData.add(s); // Add data to TableView

            try {
                File file = new File("SponserDetails.bin");
                FileOutputStream fos = new FileOutputStream(file, true);
                ObjectOutputStream oos;

                if (file.length() == 0) {
                    // First write with header
                    oos = new ObjectOutputStream(fos);
                } else {
                    // Append without header
                    oos = new AppendableObjectOutputStream(fos);
                }

                oos.writeObject(s); // Write the SponsershipData object
                oos.close();

               
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to store the sponsorship data. IOException occurred.");
            }
        } else {
            showAlert("Error", "Please fill in all fields to store the data.");
        }

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}