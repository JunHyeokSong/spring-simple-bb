package com.song.simplebb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private Connection connection;
    public dbConnection () throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/spring",
                "postgres", "1234");
    }
    public Connection getConnection() {
        return connection;
    }
}
