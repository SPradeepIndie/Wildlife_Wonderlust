package com.example.home.dbInteraction;

import com.example.home.databaseConfig.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PriceTableCreate implements CreateTable {
    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Price(h_id char(3), l_id char(9), p_name char(20), price int,PRIMARY KEY(h_id,l_id,p_name));";
        Connection conn = DbConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
