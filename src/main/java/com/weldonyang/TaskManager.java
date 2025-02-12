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

            String sql = "CREATE TABLE IF NOT EXISTS tasks " +
                    "(" +
                    "id TEXT PRIMARY KEY, " +
                    "description TEXT NOT NULL, " +
                    "status TEXT DEFAULT NOT_STARTED CHECK(status IN ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED')) " +
                    "deadline DATE NOT NULL" +
                    "created_at, TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    "start_date DATE NOT NULL" +
                    "priority, STRING CHECK(priority IN ('LOW', 'MEDIUM', 'HIGH')) " +
                    ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }


}
