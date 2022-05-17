package com.song.simplebb.domain.article;

import com.song.simplebb.db.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class articleDao {
    article get(String aid) throws ClassNotFoundException, SQLException {

        dbConnection db = new dbConnection();
        Connection c = db.getConnection();

        return new article();
    }
}
