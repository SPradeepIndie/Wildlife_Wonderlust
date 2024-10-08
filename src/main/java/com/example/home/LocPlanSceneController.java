package com.example.home;

import com.example.home.databaseConfig.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class LocPlanSceneController extends DetailsHndling implements Initializable {
    private DbConnection dbConnection;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    //for global use of package name in this class
    private String pkgNameGlobal;

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

    //injector for max price label
    @FXML
    private Label maxPriceLbl;
    private double maxPrice;

    //injector for ChoiceBox
    @FXML
    private ChoiceBox<String> hotelChoBox;
    @FXML
    private ChoiceBox<Integer> dayChoBox;
    @FXML
    private ChoiceBox<Integer> memberChoBox;
    private int maxDays;
    private int maxMembers;

    //injector for myPrice label
    @FXML
    private Label myPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        platinumBtn.getStyleClass().remove("selectedOptionBtn");
        goldBtn.getStyleClass().remove("selectedOptionBtn");
        silverBtn.getStyleClass().add("selectedOptionBtn");
        locationNameLabel.setText(DetailsHndling.getTitle(DetailsHndling.getLocName()));
        planVboxContainer.getStyleClass().add("silverImg");
        setPkgNameGlobal("silver");
        setMaxPrice();
        setHotelList();
        setDayList();
        setMemberList();
    }

    public String getPkgNameGlobal() {
        return pkgNameGlobal;
    }

    public void setPkgNameGlobal(String pkgNameGlobal) {
        this.pkgNameGlobal = pkgNameGlobal;
    }

    public void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WelcomePage/Welcome.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);//close resize option
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
        stage.getScene().setRoot(root);
        stage.show();
    }
    public void setMaxPrice(){
        query = "SELECT * FROM Package WHERE l_id = ? AND p_name=?;";

        dbConnection=DbConnection.getInstance();
        conn=dbConnection.getConnection();
        try {
            ps= conn.prepareStatement(query);
            ps.setString(1,DetailsHndling.getLocName());
            ps.setString(2,getPkgNameGlobal());
            rs=ps.executeQuery();
            if(rs.next()){
                String maxPriceStr=rs.getString("price");
                maxDays= rs.getInt("max_days");
                maxMembers= rs.getInt("max_members");
                maxPrice=Double.parseDouble(maxPriceStr);
                maxPriceLbl.setText(maxPriceStr);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setHotelList(){
        query = "SELECT h.h_name FROM Hotel h INNER JOIN Price p ON h.h_id = p.h_id WHERE p.l_id = ? AND p.p_name = ?;";
        try {
            ps= conn.prepareStatement(query);
            ps.setString(1,DetailsHndling.getLocName());
            ps.setString(2,getPkgNameGlobal());
            rs=ps.executeQuery();
            while(rs.next()){
                hotelChoBox.getItems().add((rs.getString("h_name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setDayList(){
        List<Integer> list = IntStream.rangeClosed(1, maxDays).boxed().toList();
        dayChoBox.getItems().addAll(list);
    }
    public void setMemberList(){
        List<Integer> list = IntStream.rangeClosed(1, maxMembers).boxed().toList();
        memberChoBox.getItems().addAll(list);
    }

    @FXML
    public void priceCal(ActionEvent event){
        int dayCount=1;
        int memberCount=1;
        query =  "SELECT price FROM Hotel h INNER JOIN Price p ON h.h_id = p.h_id WHERE h.h_name=? AND p.p_name =?;";
        try {
            ps= conn.prepareStatement(query);
            ps.setString(1,hotelChoBox.getValue());
            ps.setString(2,getPkgNameGlobal());
            rs=ps.executeQuery();
            if(rs.next()){
                double oneD_oneM= Double.parseDouble(rs.getString("price"));
                dayCount = dayChoBox.getSelectionModel().getSelectedItem();
                memberCount = memberChoBox.getSelectionModel().getSelectedItem();
                double calVal=oneD_oneM*memberCount*dayCount;
                if(calVal>maxPrice){
                    myPrice.setText("Price is too high,select next package");
                }
                else{
                    myPrice.setText(String.valueOf(calVal));
                }

            }else{
                myPrice.setText("please select a hotel");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //remove the choice box item before load the new items to it
    public void removeFromChoiceBox(){
        List<String> itemsToRemove = new ArrayList<>(hotelChoBox.getItems());
        hotelChoBox.getItems().removeAll(itemsToRemove);

        List<Integer> integerItemsToRemove = new ArrayList<>(dayChoBox.getItems());
        dayChoBox.getItems().removeAll(integerItemsToRemove);
        integerItemsToRemove.addAll(memberChoBox.getItems());
        memberChoBox.getItems().removeAll(integerItemsToRemove);
    }
    public void gold(ActionEvent event){
        removeFromChoiceBox();
        setPkgNameGlobal("gold");
        setMaxPrice();
        setHotelList();
        setDayList();
        setMemberList();
        planVboxContainer.getStyleClass().remove("platinumImg");
        planVboxContainer.getStyleClass().remove("silverImg");
        planVboxContainer.getStyleClass().add("goldImg");
        platinumBtn.getStyleClass().remove("selectedOptionBtn");
        goldBtn.getStyleClass().add("selectedOptionBtn");
        silverBtn.getStyleClass().remove("selectedOptionBtn");

    }
    public void platinum(ActionEvent event){
        removeFromChoiceBox();
        setPkgNameGlobal("platinum");
        setMaxPrice();
        setHotelList();
        setDayList();
        setMemberList();
        planVboxContainer.getStyleClass().remove("goldImg");
        planVboxContainer.getStyleClass().remove("silverImg");
        planVboxContainer.getStyleClass().add("platinumImg");
        platinumBtn.getStyleClass().add("selectedOptionBtn");
        goldBtn.getStyleClass().remove("selectedOptionBtn");
        silverBtn.getStyleClass().remove("selectedOptionBtn");

    }
    public void silver(ActionEvent event)  {
        removeFromChoiceBox();
        setPkgNameGlobal("silver");
        setMaxPrice();
        setHotelList();
        setDayList();
        setMemberList();
        planVboxContainer.getStyleClass().remove("goldImg");
        planVboxContainer.getStyleClass().remove("platinumImg");
        planVboxContainer.getStyleClass().add("silverImg");
        platinumBtn.getStyleClass().remove("selectedOptionBtn");
        goldBtn.getStyleClass().remove("selectedOptionBtn");
        silverBtn.getStyleClass().add("selectedOptionBtn");
    }
}
