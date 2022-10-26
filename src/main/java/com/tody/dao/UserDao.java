package com.tody.dao;

import com.tody.vo.User;

import java.sql.*;

public abstract class UserDao {
    protected abstract Connection getConnection() throws SQLException; // 추상 클래스 메소드로 다른 클래스에서 상속을 받아 확장이 가능하다.
    public void add(User user) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO USER(id, name, password) values(?, ?, ?)"
        );
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        pstmt.executeUpdate(); // 구문을 실행한 후

        // 커넥션을 닫는다.
        pstmt.close();
        conn.close();
    }

    public User get(String id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE ID = ?");

        pstmt.setString(1, id);

        ResultSet rs = pstmt.executeQuery();

        rs.next();

        User user = new User();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));

        rs.close();
        pstmt.close();
        conn.close();

        return user;
    }
}
