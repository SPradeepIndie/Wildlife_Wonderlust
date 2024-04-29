package com.example.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LocClimateSceneController extends DetailsHndling {
    @FXML
    private ScrollPane scrllPaneContent;
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LocDetailScene.fxml"));

        //Using Setter Method
        LocDetailSceneController controller = new LocDetailSceneController();  // Create controller instance
        fxmlLoader.setController(controller);  // Set controller to the loader

        root = fxmlLoader.load();  // Load the scene
        controller.addDetailContent();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void plan(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LocPlanScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addClimateContent(){
        super.select();
        try{
            FXMLLoader scrolPaneContentLaoder =new FXMLLoader(getClass().getResource(DetailsHndling.getcScrlPaneContentScene()));
            Pane itemNode=scrolPaneContentLaoder.load();
            scrllPaneContent.setContent(itemNode);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
