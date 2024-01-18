package com.example.home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Test extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Test.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        scene.getStylesheets().add(getClass().getResource("/home.css").toExternalForm());//Insert the home.css stylesheet

        //Image icon=new Image('logo.png'); //set the stage title icon
        //stage.getIcons().add(icon);
        stage.setTitle("Wildlife Wonderlust!");//set the stage title icon
        stage.setScene(scene);
        stage.setResizable(false);//close resize option
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}