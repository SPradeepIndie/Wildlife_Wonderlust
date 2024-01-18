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
import java.security.PrivateKey;

public class HomeController {

    protected String n="Location1_details.fxml";
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
        Parent root = FXMLLoader.load(getClass().getResource(n));
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
        n="Location1_details.fxml";
    }
    @FXML
    private void handleLoc2ButtonClick(ActionEvent event) {
        loc_name.setText("Location2");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        n="Location2_details.fxml";
    }
    @FXML
    private void handleLoc3ButtonClick(ActionEvent event) {
        loc_name.setText("Location3");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        n="Location3_details.fxml";
    }
    @FXML
    private void handleLoc4ButtonClick(ActionEvent event) {
        loc_name.setText("Location4");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        n="Location4_details.fxml";
    }
    @FXML
    private void handleLoc5ButtonClick(ActionEvent event) {
        loc_name.setText("Location5");
        seeMore_btn.setOpacity(1);
        seeMore_btn.setText("See more");
        n="Location5_details.fxml";
    }
}