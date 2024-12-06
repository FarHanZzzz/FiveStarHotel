package cse.fivestarhotel.CEO;

import cse.fivestarhotel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class CEODashBoardController
{
    @javafx.fxml.FXML
    private BorderPane CeoDashBoardBorderPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sponsershipCampaignButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/sponsershipCampaigns.fxml"));


            CeoDashBoardBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void ManageUserAccountsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void monthlyGoalsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/UpdateMonthlygoals.fxml"));


            CeoDashBoardBorderPane.setRight(fxmlLoader.load());
        }
        catch(Exception e){}
    }
}