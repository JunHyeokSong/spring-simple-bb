package com.song.simplebb.domain.article;

import com.song.simplebb.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class ArticleDao {
    Article get(String aid) throws ClassNotFoundException, SQLException {

        Connection c = DBConnection.getConnection();

        return new Article();
    }
}
