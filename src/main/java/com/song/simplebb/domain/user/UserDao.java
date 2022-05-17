package com.song.simplebb.domain.user;

import com.song.simplebb.db.DBConnection;

import java.sql.*;

public class UserDao {
    // Singleton Object
    private static final UserDao instance = new UserDao();
    private UserDao(){};
    public static UserDao getUserDao() {
        return instance;
    }

    public User getUserById (String id) throws SQLException {
        Connection c = DBConnection.getConnection();
        String getUserByIdQuery = "select * from users where uid=?";
        PreparedStatement pstmt = c.prepareStatement(getUserByIdQuery);
        pstmt.setString(1, id);

        ResultSet rs = pstmt.executeQuery();
        rs.next();

        String obtainedName = rs.getString("name");
        User user = new User();
        user.setId(id);
        user.setName(obtainedName);

        rs.close();
        pstmt.close();
        return user;
    }

    public void addUser (User user) throws SQLException {
        Connection c = DBConnection.getConnection();
        String insertUserQuery = "insert into users (uid, name) values (?, ?)";
        PreparedStatement pstmt = c.prepareStatement(insertUserQuery);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.executeUpdate();

        pstmt.close();
        return;
    }
}
