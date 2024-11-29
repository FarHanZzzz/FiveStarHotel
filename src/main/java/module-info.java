module hotel.fivestarhotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse.fivestarhotel to javafx.fxml;
    opens cse.fivestarhotel.FrontDeskStaff to javafx.fxml;
    opens cse.fivestarhotel.RestaurantManager to javafx.fxml;
    opens cse.fivestarhotel.Login to javafx.fxml;
    opens cse.fivestarhotel.Img to javafx.fxml;


    exports cse.fivestarhotel;
}

