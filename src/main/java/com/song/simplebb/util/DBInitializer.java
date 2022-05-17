package com.song.simplebb.util;

import com.song.simplebb.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection c = DBConnection.getConnection();
        String createUsersQuery =
                "CREATE TABLE users (" +
                    "uid VARCHAR(10) primary key," +
                    "name VARCHAR(10)" +
                ")";

        String createArticlesQuery =
                "CREATE TABLE articles (" +
                    "aid VARCHAR(10) primary key," +
                    "uid VARCHAR(10)," +
                    "title VARCHAR(20)," +
                    "body VARCHAR(200)" +
                ")";

        Statement stmt = c.createStatement();
        stmt.execute(createUsersQuery);
        stmt.execute(createArticlesQuery);

        stmt.close();
        c.close();
    }

}
