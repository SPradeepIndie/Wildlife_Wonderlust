package com.example.home.dbInteraction;

import com.example.home.databaseConfig.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PackageTableCreate implements CreateTable {
    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Package(l_id char(9),p_name varchar(20), price int,max_days int(10),max_members int(10),PRIMARY KEY (l_id,p_name));";
        Connection conn = DbConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
