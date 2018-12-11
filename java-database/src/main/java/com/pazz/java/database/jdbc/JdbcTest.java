package com.pazz.java.database.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @describe 连接测试
 */
public class JdbcTest {

    public static void main(String[] args) throws Exception {
        Connection connection = Jdbc_Helper.getConnection();
        System.out.println("connection: " + connection);

        PreparedStatement ps = connection.prepareStatement("select * from province");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("p_id" + rs.getInt(1) + " province_name" + rs.getString(2) + " describe" + rs.getString(3));
        }
        Jdbc_Helper.myClose(connection, ps, rs);

    }

}
