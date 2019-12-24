package com.pazz.java.jdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @describe 连接测试
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //Connection connection = DriverManager.getConnection("jdbc:mysql://39.106.216.100:3306/eshipping_truck", "yht", "AD9KSivrniiYFAO2W5OI");
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from test where name = ?");
        ps.setString(1, "pazz");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.print(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4));
            System.out.println();
        }

        JdbcUtil.close(connection, ps, rs);

    }

}
