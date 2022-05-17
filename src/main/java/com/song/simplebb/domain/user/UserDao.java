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

    public User getUserById (String id) throws ClassNotFoundException, SQLException {
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

    public void setUser (User user) throws ClassNotFoundException, SQLException {
        Connection c = DBConnection.getConnection();
        String insertUserQuery = "insert into users (uid, name) values (?, ?)";
        PreparedStatement pstmt = c.prepareStatement(insertUserQuery);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.executeUpdate();

        pstmt.close();
        return;
    }

    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        User usr = new User();
        usr.setId("123d451");
        usr.setName("song");

        UserDao userDao = UserDao.getUserDao();

        try {
            userDao.setUser(usr);
            System.out.println("set usr!");
        }
        catch (SQLException e) {
            System.out.println("set user fail... SQL Exception");
        }

        User usr2 = userDao.getUserById(usr.getId());
        System.out.println("get usr2!");
        System.out.println("Your name: " + usr2.getName());
    }
}
