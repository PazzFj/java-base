package com.pazz.java.jdbc.mysql;

import java.sql.*;

public class JdbcUtil {

    private static final String CLASSNAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "sa123"; // 加载驱动

    private static Connection connection = null;

    static {
        try {
            Class.forName(CLASSNAME);
            System.out.println("加载驱动完毕!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 创建数据库连接
    public static Connection getConnection() {
        return getConnection(URL, USER, PASSWORD);
    }

    public static Connection getConnection(String url, String user, String password) {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("创建数据库连接~~~~~");
            }
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭数据库连接
    public static void close(Connection con) {
        close(con, null);
    }

    // 关闭数据库连接，执行对象
    public static void close(Connection con, PreparedStatement ps) {
        close(con, ps, null);
    }

    // 关闭数据库连接，执行对象.查询对象
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
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
