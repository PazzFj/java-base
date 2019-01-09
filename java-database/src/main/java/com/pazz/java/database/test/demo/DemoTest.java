package com.pazz.java.database.test.demo;

import com.pazz.java.database.test.DefaultDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DemoTest {
    public static void main(String[] args) throws SQLException {
        DefaultDataSource dataSource = new DefaultDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("sa123");
        dataSource.setInitialSize(5);
        dataSource.setMaxIdle(20);
        Connection connection1 = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();
        System.out.println(connection1);
        System.out.println(connection2);

    }
}
