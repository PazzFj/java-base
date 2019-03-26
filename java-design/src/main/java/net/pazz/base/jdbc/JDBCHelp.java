package net.pazz.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySql 数据库连接 --- 引入依赖
 */
public class JDBCHelp {

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/base", "root", "sa123");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
