package com.tody.dao;

import com.tody.util.connection.ConnectionMaker;
import com.tody.util.connection.NConnectionMaker;
import com.tody.vo.User;

import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;
    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker; // 파라미터로 인터페이스를 받아오도록 함. ConnectionMaker 의 구현체중 아무것이나 받아도 상관 없다는것임.
    }
    public void add(User user) throws SQLException {
        Connection conn = this.connectionMaker.makeNewConnection();
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
        Connection conn = this.connectionMaker.makeNewConnection();
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
