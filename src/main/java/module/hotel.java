package module;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class hotel{
    private String hotel_id;
    private String hotel_name;
    private String Category_id;
    private String Location_id;

    public String getHotel_id() {
        return hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public String getCategory_id() {
        return Category_id;
    }

    public String getLocation_id() {
        return Location_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setCategory_id(String category_id) {
        Category_id = category_id;
    }

    public void setLocation_id(String location_id) {
        Location_id = location_id;
    }

    public static void main(String[] args) {
        Connection conn = Singleton.getCon();
        try{
            Statement statement  = conn.createStatement();
            ResultSet resultSet  = statement.executeQuery("SELECT * FROM hotel;");

            while(resultSet.next()){
                System.out.print(resultSet.getString( "h_id" ));
                System.out.print(resultSet.getString( "h_name")+"  ");
                System.out.print(resultSet.getString( "c_id" )+"    ");
                System.out.print(resultSet.getString( "l_id" )+"          ");
                System.out.println();
            }


        }

        catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
}
