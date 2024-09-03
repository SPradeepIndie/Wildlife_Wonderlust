package com.example.home.model;

import java.sql.*;

public class DbConnection {
    private static DbConnection instance=null;
    private Connection connection;

    private DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wildLifeDB", "root", "");
            System.out.println("Connection successfull");
        } catch (ClassNotFoundException e) {
            System.out.println("Drivers not found");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Connection error!check database");
            throw new RuntimeException(e);
        }
    }

    public static DbConnection getInstance() {
        if(instance == null){//if instance null then create new DbConncetion instance
            instance= new DbConnection();
            return instance;
        }
        return instance;//else return exist instance without create new one
    }

    public Connection getConnection() {
        return connection;
    }

}
