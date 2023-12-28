module com.example.mainapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mainapi to javafx.fxml;
    exports com.example.mainapi;
}