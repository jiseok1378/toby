package com.tody;

import com.tody.dao.UserDao;
import com.tody.util.connection.NConnectionMaker;
import com.tody.vo.User;

import java.sql.*;

public class Toby {
    public static void main(String[] args) throws SQLException {
        NConnectionMaker nConnectionMaker = new NConnectionMaker();
        UserDao dao = new UserDao(nConnectionMaker); // N사의 Connection 객체를 사용하는 UserDao

        User user1 = new User();
        user1.setName("test");
        user1.setId("1");
        user1.setPassword("1234");

        dao.add(user1);

        System.out.println(user1.getId() + " 등록 성공");

        User user2 = dao.get(user1.getId());

        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user1.getId() + " 조회 성공");
    }
}
