package com.example.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LocSilverOptionSceneController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage/Welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void details(ActionEvent event) throws IOException {
        // Load the FXML loader for the target scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LocDetailScene.fxml"));

        //Using Setter Method dynamically load location details
        LocDetailSceneController controller = new LocDetailSceneController();  // Create controller instance
        fxmlLoader.setController(controller);  // Set controller to the loader

        root = fxmlLoader.load();  // Load the scene
        controller.addDetailContent();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gold(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LocGoldOptionScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void platinum(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LocPlatinumOptionScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
