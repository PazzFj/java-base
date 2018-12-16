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
//        PreparedStatement ps = connection.prepareStatement("select * from person");
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            System.out.println("pid： " + rs.getInt(1) + " pname： " + rs.getString(2) + " page： " + rs.getInt(3));
//        }
//        Jdbc_Helper.myClose(connection, ps, rs);
        String name = "qwer";
        String code = "1000";
        PreparedStatement ps = null;
        for (int i = 0; i < 100000; i++) {
            ps = connection.prepareStatement("insert into test (name, code, time) values ('" + name + i + "', '" + code + i + "', now())");
            ps.execute();
        }
        Jdbc_Helper.myClose(connection, ps);
        System.out.println("关闭成功" + ps.isClosed() + "___" + connection.isClosed());

    }

}
