package com.tody.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {
    public Connection makeNewConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Seoul&useUnicode=true&character_set_server=utf8mb4", "test","1234");
    }
}
