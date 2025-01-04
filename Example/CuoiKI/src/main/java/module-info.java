module com.example.cuoiki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cuoiki to javafx.fxml;
    exports com.example.cuoiki;
}