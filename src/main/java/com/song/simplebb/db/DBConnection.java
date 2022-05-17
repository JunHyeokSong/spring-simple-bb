package com.song.simplebb.db;

import com.song.simplebb.domain.user.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static final DBConnection instance = new DBConnection();
    private DBConnection () {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/spring",
                    "postgres", "1234");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (SQLException e) {
            System.out.println("SQL Exception");
        }
    }

    public static Connection getConnection() {
        return instance.connection;
    }
}
