package com.pazz.java.database.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @describe 连接测试
 */
public class JdbcTest {

    public static void main(String[] args) throws Exception {
        Connection connection = Jdbc_Helper.getConnection();
        String name = "qqww";
        String code = "3333";
        Statement statement = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//        for (int i = 0; i < 10; i++) {
//            ps = connection.prepareStatement("insert into test (name, code, time) values (?, + '" + code + "', now())");
//            ps.setString(1, name);
//            ps.execute();
//        }
        ps = connection.prepareStatement("select * from test where name = ?");
        ps.setString(1, name);
        rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getDate(4));
        }
        if (statement != null && !statement.isClosed()) {
            statement.close();
        }
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }

    }

}
