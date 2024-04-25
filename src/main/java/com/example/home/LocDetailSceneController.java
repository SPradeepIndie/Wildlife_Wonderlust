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

public class LocDetailSceneController {
    @FXML
    private ScrollPane scrllPaneContent;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    //hold the scrollpane content scene fxml file name
    private String scrlPaneContentScene;

    //get the selected location name from Welocme page
    private String locSelctor;


    public ScrollPane getScrllPaneContent() {
        return scrllPaneContent;
    }

    public String getLocSelctor() {
        return locSelctor;
    }

    public void setLocSelctor(String locSelctor) {
        this.locSelctor = locSelctor;
    }

    public void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage/Welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void climate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LocClimateScene.fxml"));
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

    public void addContent(){
      switch (locSelctor) {
        case "Location1" -> scrlPaneContentScene = "Location1_details.fxml";
        case "Location2" -> scrlPaneContentScene = "Location2_details.fxml";
        case "Location3" -> scrlPaneContentScene = "Location3_details.fxml";
        case "Location4" -> scrlPaneContentScene = "Location4_details.fxml";
        case "Location5" -> scrlPaneContentScene = "Location5_details.fxml";
        default -> System.out.println("location not set");
        }
        try{
            FXMLLoader scrolPaneContentLaoder =new FXMLLoader(getClass().getResource(scrlPaneContentScene));
            VBox itemNode=scrolPaneContentLaoder.load();
            scrllPaneContent.setContent(itemNode);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
