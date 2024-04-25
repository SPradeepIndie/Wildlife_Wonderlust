package com.example.home;

public class DetailsHndling {
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

}
