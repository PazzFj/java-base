package com.pazz.java.thinking.datasource;

import com.pazz.java.thinking.datasource.DefaultDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class $_Main {
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
