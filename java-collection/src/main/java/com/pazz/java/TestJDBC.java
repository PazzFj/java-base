package com.pazz.java;

import com.pazz.java.jdbc.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @describe 连接测试
 */
public class TestJDBC {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    @Test
    public void testJdbc() {
        try {
            ps = connection.prepareStatement("select * from province");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("p_id" + rs.getInt(1) + " province_name" + rs.getString(2) + " describe" + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        connection = DBHelper.getConnection();
        System.out.println("connection: " + connection);
    }

    @After
    public void after() {
        DBHelper.myClose(connection, ps, rs);
    }
}
