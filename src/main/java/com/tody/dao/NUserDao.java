package com.tody.dao;

import com.tody.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {

    @Override
    public Connection getConnection() throws SQLException { // N사의 Connection 객체를 리턴시켜준다.
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Seoul&useUnicode=true&character_set_server=utf8mb4", "test","1234");
    }
}
