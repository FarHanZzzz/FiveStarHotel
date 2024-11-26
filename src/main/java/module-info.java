module hotel.fivestarhotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens hotel.fivestarhotel to javafx.fxml;


    exports hotel.fivestarhotel;
}