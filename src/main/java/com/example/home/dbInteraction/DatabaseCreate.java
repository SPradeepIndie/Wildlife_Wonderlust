package com.example.home.dbInteraction;

import com.example.home.databaseConfig.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreate {
    public void createDatabase(){
        String sql = "CREATE DATABASE IF NOT EXISTS wildLifeDb;";
        Connection conn = DbConnection.getInstance().getConnection();
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.execute("use wildLifeDb;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
