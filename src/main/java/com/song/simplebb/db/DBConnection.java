package com.song.simplebb.db;

import com.song.simplebb.domain.user.UserDao;
import com.song.simplebb.util.EnvHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import static java.lang.System.exit;

public class DBConnection {
    private static Connection connection;
    private static final DBConnection instance = new DBConnection();
    private DBConnection () {
        try {
            HashMap<String, String> env = EnvHelper.getEnv();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    env.get("DB_URL"), env.get("DB_USER"), env.get("DB_PASSWORD"));
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            exit(1);
        }
        catch (SQLException e) {
            System.out.println("SQL Exception");
        }
    }

    public static Connection getConnection() {
        return instance.connection;
    }
}
