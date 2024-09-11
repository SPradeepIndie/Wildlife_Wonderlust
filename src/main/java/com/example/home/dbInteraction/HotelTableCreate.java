package com.example.home.dbInteraction;

import com.example.home.databaseConfig.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelTableCreate implements CreateTable {

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Hotel(h_id char(3) PRIMARY KEY, h_name varchar(20));";
        Connection conn = DbConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
