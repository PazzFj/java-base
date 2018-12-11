package com.pazz.java.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_Helper {

    private static final String className = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "sa123"; // 加载驱动

    static {
        try {
            Class.forName(className);
            System.out.println("加载驱动完毕!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 创建数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("创建数据库连接~~~~~");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 关闭数据库连接
    public static void myClose(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭数据库连接，执行对象
    public static void myClose(Connection con, PreparedStatement ps) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭数据库连接，执行对象.查询对象
    public static void myClose(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
