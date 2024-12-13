module hotel.fivestarhotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;



//    requires java.base;


    opens cse.fivestarhotel to javafx.fxml;
    opens cse.fivestarhotel.FrontDeskStaff to javafx.fxml,java.base;
    opens cse.fivestarhotel.RestaurantManager to javafx.fxml;
    opens cse.fivestarhotel.Login to javafx.fxml;
    opens cse.fivestarhotel.Img to javafx.fxml;
    opens cse.fivestarhotel.HotelHeadManager to javafx.fxml;
    opens cse.fivestarhotel.CEO to javafx.fxml;
    opens cse.fivestarhotel.RoomServiceWorker to javafx.fxml;
    opens cse.fivestarhotel.RoomServiceManager to javafx.fxml;
    opens cse.fivestarhotel.HotelGuest to javafx.fxml;





    exports cse.fivestarhotel;
    exports cse.fivestarhotel.FrontDeskStaff;
    exports cse.fivestarhotel.RestaurantManager;
    exports cse.fivestarhotel.HotelGuest;
    exports cse.fivestarhotel.HotelHeadManager;
    exports cse.fivestarhotel.CEO;
    exports cse.fivestarhotel.RoomServiceManager;
    exports cse.fivestarhotel.RoomServiceWorker;
    exports cse.fivestarhotel.Login;






}

