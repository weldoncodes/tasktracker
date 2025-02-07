package com.weldonyang;

import java.sql.*;


public class TaskManager {
    private static final String DB_URL = "jdbc:sqlite:tasktracker.db";

    public TaskManager() {
        initializeDatabase();
    }

    // Create the tasks table if it doesn't exist
    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                    "id TEXT PRIMARY KEY, " +
                    "description TEXT NOT NULL, " +
                    "status TEXT NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }


}
