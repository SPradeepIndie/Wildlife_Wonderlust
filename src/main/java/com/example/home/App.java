package com.example.home;

import com.example.home.dbInteraction.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("WelcomePage/Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        scene.getStylesheets().add(getClass().getResource("/com/example/home/CSS/Welcome.css").toExternalForm());//Insert the Welcome.css stylesheet

        Image icon=new Image(Objects.requireNonNull(App.class.getResourceAsStream("Image/logo.png"))); //set the stage title icon
        stage.getIcons().add(icon);
        stage.setTitle("Wildlife Wanderlust!");//set the stage title icon
        stage.setScene(scene);
        stage.setResizable(false);//close resize option
        stage.show();
    }

    public static void main(String[] args) {
        DatabaseCreate databaseCreate=new DatabaseCreate();
        HotelTableCreate hotelTableCreate=new HotelTableCreate();
        LocationTableCreate locationTableCreate=new LocationTableCreate();
        PackageTableCreate packageTableCreate=new PackageTableCreate();
        PriceTableCreate priceTableCreate=new PriceTableCreate();
        databaseCreate.createDatabase();
        hotelTableCreate.createTable();
        locationTableCreate.createTable();
        packageTableCreate.createTable();
        priceTableCreate.createTable();
        launch(args);
    }
}