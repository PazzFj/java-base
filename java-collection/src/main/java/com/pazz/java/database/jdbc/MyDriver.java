package com.pazz.java.database.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author: 彭坚
 * @create: 2019/1/7 21:39
 * @description:
 */
public class MyDriver extends com.mysql.jdbc.Driver {

    static {
        System.out.println("------start!!!");
    }

    /**
     * Construct a new driver and register it with DriverManager
     *
     * @throws SQLException if a database error occurs.
     */
    public MyDriver() throws SQLException {
        super();
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return super.connect(url, info);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return super.acceptsURL(url);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return super.getPropertyInfo(url, info);
    }

    @Override
    public int getMajorVersion() {
        return super.getMajorVersion();
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
