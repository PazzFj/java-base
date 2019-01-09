package com.pazz.java.database.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.PooledConnection;

import com.pazz.java.database.test.configuration.DataConfiguration;
import com.pazz.java.database.test.pool.DefaultConnectionPool;
import com.pazz.java.database.test.pool.DefaultConnectionWrapper;
import com.pazz.java.database.test.uitl.StringUtils;
import lombok.Data;

/**
 * 
 * <p>
 * Copyright： Copyright (c) 2017
 * </p>
 * <p>
 * Company： 熠道大数据
 * </p>
 * 
 * @ClassName: SuperConnectionPool
 * @Description: TODO(数据库连接池)
 * @author liuhonbin
 * @date 2018年4月24日
 */

@Data
public class DefaultDataSource extends DefaultCommonDataSource implements DataSource, ConnectionPoolDataSource {

	private DefaultConnectionPool defaultConnectionPool = DefaultConnectionPool.getInstance();

	protected volatile String username;
	protected volatile String password;
	protected volatile String jdbcUrl; //jdbc:mysql://127.0.0.1:3306/test
	protected volatile String driverClass; //com.mysql.jdbc.Driver
	protected volatile int initialSize = 0;
	protected volatile int minIdle = 0;
	protected volatile int maxIdle = 0;
	protected volatile int maxActive = 0;
	protected volatile long maxWait = 0;
	protected volatile long waitTime = 1000L;

	public DefaultDataSource() {

	}

	public DefaultDataSource(String username, String password, String jdbcUrl) {
		super();
		this.username = username;
		this.password = password;
		this.jdbcUrl = jdbcUrl;
	}

	public DefaultConnectionWrapper getDefaultConnection() {
		init();
		try {
			return defaultConnectionPool.getDefaultConnection(getWaitTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getConnection() throws SQLException {
		DefaultConnectionWrapper defaultConnectionWrapper = getDefaultConnection();
		if (defaultConnectionWrapper != null) {
			return defaultConnectionWrapper;
		} else {
			throw new UnsupportedOperationException("Not supported by DefaultDataSource");
		}
	}

	public Connection getConnection(String username, String password) throws SQLException {
		if (this.username == null && this.password == null && username != null && password != null) {
			this.username = username;
			this.password = password;
			return getConnection();
		}

		if (!StringUtils.equals(username, this.username)) {
			throw new UnsupportedOperationException("Not supported by DefaultDataSource");
		}

		if (!StringUtils.equals(password, this.password)) {
			throw new UnsupportedOperationException("Not supported by DefaultDataSource");
		}
		return getConnection();
	}

	private void init() {
		if (defaultConnectionPool.getConfiguration() == null) {
			DataConfiguration configuration = new DataConfiguration();
			configuration.setDriverClass(getDriverClass());
			configuration.setJdbcUrl(getJdbcUrl());
			configuration.setUsername(getUsername());
			configuration.setPassword(getPassword());
			configuration.setInitialSize(getInitialSize());
			configuration.setMaxActive(getMaxActive());
			configuration.setMaxIdle(getMaxIdle());
			configuration.setMaxWait(getMaxWait());
			configuration.setMinIdle(getMinIdle());
			defaultConnectionPool.setConfiguration(configuration);
		}
	}

	public PooledConnection getPooledConnection() throws SQLException {
		DefaultConnectionWrapper defaultConnectionWrapper = getDefaultConnection();
		if (defaultConnectionWrapper != null) {
			return defaultConnectionWrapper;
		} else {
			throw new UnsupportedOperationException("Not supported by DefaultDataSource");
		}
	}

	public PooledConnection getPooledConnection(String user, String password) throws SQLException {
		if (this.username == null && this.password == null && username != null && password != null) {
			this.username = username;
			this.password = password;
			return getPooledConnection();
		}

		if (!StringUtils.equals(username, this.username)) {
			throw new UnsupportedOperationException("Not supported by DefaultDataSource");
		}

		if (!StringUtils.equals(password, this.password)) {
			throw new UnsupportedOperationException("Not supported by DefaultDataSource");
		}
		return getPooledConnection();
	}

	// 关闭连接池的时候这里要去进行连接集合的清理，目前未做实现
	public void close() throws SQLException {
		// 开始回收连接
		for (Connection connection : defaultConnectionPool.getUse()) {
			connection.close();
		}
		defaultConnectionPool.setUse(null);
		for (Connection connection : defaultConnectionPool.getDuse()) {
			connection.close();
		}
		defaultConnectionPool.setDuse(null);
	}

}
