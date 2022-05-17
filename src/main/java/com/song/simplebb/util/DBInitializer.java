package com.song.simplebb.util;

import com.song.simplebb.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection c = DBConnection.getConnection();
        String dropUsersQuery = "DROP TABLE IF EXISTS users";
        String dropArticlesQuery = "DROP TABLE IF EXISTS articles";

        String createUsersQuery =
                "CREATE TABLE users (" +
                    "uid VARCHAR(10) primary key," +
                    "name VARCHAR(20)" +
                ")";

        String createArticlesQuery =
                "CREATE TABLE articles (" +
                    "aid VARCHAR(10) primary key," +
                    "uid VARCHAR(10)," +
                    "title VARCHAR(20)," +
                    "body VARCHAR(200)" +
                ")";

        Statement stmt = c.createStatement();
        stmt.execute(dropUsersQuery);
        stmt.execute(dropArticlesQuery);
        stmt.execute(createUsersQuery);
        stmt.execute(createArticlesQuery);

        stmt.close();
        c.close();
    }
}
