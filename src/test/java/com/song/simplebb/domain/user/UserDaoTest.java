package com.song.simplebb.domain.user;

import com.song.simplebb.db.DBConnection;
import com.song.simplebb.util.DBInitializer;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void addTest() throws SQLException {
        UserDao udao = UserDao.getUserDao();

        User user1 = new User();
        user1.setName("Name4Test");
        String randString = null;

        int count = 0;
        Boolean done = false;
        while (!done) {
            try {
                randString = Integer.toString((int) (10000000 * Math.random()));
                user1.setId(randString);
                udao.addUser(user1);
                done = true;
            } catch (SQLException e) {
                if (count >= 100) {
                    throw e;
                } else {
                    count++;
                }
            }
        }
        User actual = udao.getUserById(randString);
        assertEquals("Name4Test", actual.getName());
    }
}