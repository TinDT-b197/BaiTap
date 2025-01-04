module com.example.btcuoiki {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.btcuoiki to javafx.fxml;
    exports com.example.btcuoiki;
    opens com.example.btcuoiki.Database to javafx.fxml;
    exports com.example.btcuoiki.Database;
}