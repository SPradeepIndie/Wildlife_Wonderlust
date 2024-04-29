package com.example.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LocPlanSceneController extends DetailsHndling implements Initializable {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    //injector for title
    @FXML
    private Label locationNameLabel;

    //injectors for button
    @FXML
    private Button silverBtn;
    @FXML
    private Button goldBtn;
    @FXML
    private Button platinumBtn;

    //injector for container
    @FXML
    private VBox planVboxContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        locationNameLabel.setText(DetailsHndling.getTitle(DetailsHndling.getLocName()));
        planVboxContainer.getStyleClass().add("silverImg");
    }

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
        planVboxContainer.getStyleClass().remove("platinumImg");
        planVboxContainer.getStyleClass().remove("silverImg");
        planVboxContainer.getStyleClass().add("goldImg");

    }

    public void platinum(ActionEvent event) throws IOException {
        planVboxContainer.getStyleClass().remove("goldImg");
        planVboxContainer.getStyleClass().remove("silverImg");
        planVboxContainer.getStyleClass().add("platinumImg");

    }
    public void silver(ActionEvent event)  {
        planVboxContainer.getStyleClass().remove("goldImg");
        planVboxContainer.getStyleClass().remove("platinumImg");
        planVboxContainer.getStyleClass().add("silverImg");
    }
}
