package com.example.home;

import java.util.HashMap;

public class DetailsHndling {

    private static final HashMap<String, String> locNameToTtitle = new HashMap<>();

    //hold the location name
    private static String locName;
    private static String dScrlPaneContentScene;
    private static String cScrlPaneContentScene;

    public static String getdScrlPaneContentScene() {
        return dScrlPaneContentScene;
    }

    public static void setdScrlPaneContentScene(String dScrlPaneContentScene) {
        DetailsHndling.dScrlPaneContentScene = dScrlPaneContentScene;
    }

    public static String getcScrlPaneContentScene() {
        return cScrlPaneContentScene;
    }

    public static void setcScrlPaneContentScene(String cScrlPaneContentScene) {
        DetailsHndling.cScrlPaneContentScene = cScrlPaneContentScene;
    }

    public static String getLocName() {
        return locName;
    }
    public static void setLocName(String locName) {
        DetailsHndling.locName = locName;
    }
    //select loaction detail fxml or climate fxml according to the loc name
    public void select(){
        //for initialize the hashmap
        dataMap(getLocNameToTtitle());

        switch (getLocName()) {
            case "Location1" :
                setdScrlPaneContentScene("Location1_details.fxml");
                setcScrlPaneContentScene("Location1_climate.fxml");
                break;
            case "Location2":
                setdScrlPaneContentScene("Location2_details.fxml");
                setcScrlPaneContentScene("Location2_climate.fxml");
                break;
            case "Location3" :
                setdScrlPaneContentScene("Location3_details.fxml");
                setcScrlPaneContentScene("Location3_climate.fxml");
                break;
            case "Location4" :
                setdScrlPaneContentScene("Location4_details.fxml");
                setcScrlPaneContentScene("Location4_climate.fxml");
                break;
            case "Location5" :
                setdScrlPaneContentScene("Location5_details.fxml");
                setcScrlPaneContentScene("Location5_climate.fxml");
                break;
            default:
                System.out.println("location not set");
                break;
        }
    }

    //getter for hashmap
    public static HashMap<String, String> getLocNameToTtitle() {
        return locNameToTtitle;
    }

    //method for initilize the hashmap fo rkey values
    public void dataMap(HashMap<String, String> l){
        l.put("Location1","YALA NATIONAL PARK");
        l.put("Location2","KUMANA NATIONAL PARK");
        l.put("Location3","WILPATTU NATIONAL PARK");
        l.put("Location4","SINHARAJA RAIN FOREST");
        l.put("Location5","UDAWALAWE NATIONAL PARK");
    }

    //give the value for specific key value
    public static String getTitle(String key){
        return getLocNameToTtitle().get(key);
    }
}
