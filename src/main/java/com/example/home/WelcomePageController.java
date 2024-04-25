package com.example.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController extends DetailsHndling{
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    //get reference to the location name and see more button;To appear when triggerSeeMore btn clicked
    @FXML
    private Label loc_name;
    @FXML
    private Button seeMore_btn;

    public void seemore(ActionEvent event) throws IOException {
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

    //Methods to handle all location trigger button
    @FXML
    private void handleLoc1ButtonClick(ActionEvent event) {
        loc_name.setText("Location1");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        DetailsHndling.setLocName("Location1");
    }
    @FXML
    private void handleLoc2ButtonClick(ActionEvent event) {
        loc_name.setText("Location2");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        DetailsHndling.setLocName("Location2");
    }
    @FXML
    private void handleLoc3ButtonClick(ActionEvent event) {
        loc_name.setText("Location3");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        DetailsHndling.setLocName("Location3");
    }
    @FXML
    private void handleLoc4ButtonClick(ActionEvent event) {
        loc_name.setText("Location4");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        DetailsHndling.setLocName("Location4");
    }
    @FXML
    private void handleLoc5ButtonClick(ActionEvent event) {
        loc_name.setText("Location5");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        DetailsHndling.setLocName("Location5");
    }
}