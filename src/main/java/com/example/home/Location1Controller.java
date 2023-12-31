package com.example.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Location1Controller {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void gotolocation2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("location2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotolocation3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("location3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotolocation4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("location4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotolocation5(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("location5.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void location1seemore() throws IOException {
        // Load the next.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("next.fxml"));
        Parent root = loader.load();

        // Create a new stage for the next.fxml content
        Stage nextStage = new Stage();
        nextStage.setScene(new Scene(root));
        nextStage.setTitle("Next Window");

        // Show the next stage
        nextStage.show();

        // Close the current stage (this.fxml window)
        Stage thisStage = (Stage) root.getScene().getWindow();
        thisStage.close();
    }
}
