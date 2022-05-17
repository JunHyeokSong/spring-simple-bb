package com.song.simplebb.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

    private Connection c;
    dbConnection () {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(

        )
    }
}
