package com.example.home.dbInteraction;

import com.example.home.databaseConfig.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationTableCreate implements CreateTable {
    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS location(l_id char(9) PRIMARY KEY, l_name varchar(40));";
        Connection conn = DbConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
