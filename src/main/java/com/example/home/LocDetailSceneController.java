package com.example.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LocDetailSceneController extends DetailsHndling{
    @FXML
    private ScrollPane scrllPaneContent;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public ScrollPane getScrllPaneContent() {
        return scrllPaneContent;
    }


    public void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage/Welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void climate(ActionEvent event) throws IOException {
        // Load the FXML loader for the target scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LocClimateScene.fxml"));

        //Using Setter Method dynamically load location details
        LocClimateSceneController controller = new LocClimateSceneController();  // Create controller instance
        fxmlLoader.setController(controller);  // Set controller to the loader

        root = fxmlLoader.load();  // Load the scene
        controller.addClimateContent();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void silver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LocSilverOptionScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addDetailContent(){
        super.select();
        try{
            FXMLLoader scrolPaneContentLaoder =new FXMLLoader(getClass().getResource(DetailsHndling.getdScrlPaneContentScene()));
            VBox itemNode=scrolPaneContentLaoder.load();
            scrllPaneContent.setContent(itemNode);//this scollpane id knows only that controller file

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
