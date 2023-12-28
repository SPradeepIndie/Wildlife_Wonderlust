module com.example.home {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.home to javafx.fxml;
    exports com.example.home;
}