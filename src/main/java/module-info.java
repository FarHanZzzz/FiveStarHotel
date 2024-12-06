module hotel.fivestarhotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse.fivestarhotel to javafx.fxml;
    opens cse.fivestarhotel.FrontDeskStaff to javafx.fxml;
    opens cse.fivestarhotel.RestaurantManager to javafx.fxml;
    opens cse.fivestarhotel.Login to javafx.fxml;
    opens cse.fivestarhotel.Img to javafx.fxml;
    opens cse.fivestarhotel.HotelHeadManager to javafx.fxml;
    opens cse.fivestarhotel.CEO to javafx.fxml;
    opens cse.fivestarhotel.RoomServiceWorker to javafx.fxml;
    opens cse.fivestarhotel.RoomServiceManager to javafx.fxml;
    opens cse.fivestarhotel.HotelGuest to javafx.fxml;




    exports cse.fivestarhotel;
}

