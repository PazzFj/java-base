package com.pazz.java.database.test.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

import com.pazz.java.database.test.configuration.DataConfiguration;

public class DefaultConnectionPool {

	// 已使用连接
	private ArrayBlockingQueue<DefaultConnectionWrapper> use = new ArrayBlockingQueue<DefaultConnectionWrapper>(1024);
	// 未使用连接
	private ArrayBlockingQueue<DefaultConnectionWrapper> duse = new ArrayBlockingQueue<DefaultConnectionWrapper>(1024);

	// 在DefaultDataSource.getSuperPoolConnection() 方法中进初始化设置
	private DataConfiguration configuration;

	// 驱动是否初始化标志位
	private boolean initDriver = false;

	private DefaultConnectionPool() {

	}

	// 初始化驱动方法，只会加载一次
	private void initDriver() {
		try {
			Class.forName(configuration.getDriverClass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 初始化成功设置为true
		initDriver = true;
	}

	private DefaultConnectionWrapper getConnection() {
		// 判断驱动是否初始化加载
		if (!initDriver) {
			initDriver();
		}
		Connection conn = null;
		// 自定义的一个Connection类，实现了javax.sql.PooledConnection, java.sql.Connection 接口
		DefaultConnectionWrapper defaultConnectionWrapper = null;
		try {
			conn = DriverManager.getConnection(configuration.getJdbcUrl(), configuration.getUsername(), configuration.getPassword());
			// 将获取到的连接设置到自定义的Connection实现类中
			defaultConnectionWrapper = new DefaultConnectionWrapper(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return defaultConnectionWrapper;
	}

	// 单列模式加载
	private static class Singleton {
		private static DefaultConnectionPool defaultConnectionPool;
		static {
			defaultConnectionPool = new DefaultConnectionPool();
		}

		public static DefaultConnectionPool getInstance() {
			return defaultConnectionPool;
		}
	}

	public static DefaultConnectionPool getInstance() {
		return Singleton.getInstance();
	}

	public DataConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(DataConfiguration configuration) {
		this.configuration = configuration;
	}

	// 获取连接
	public DefaultConnectionWrapper getDefaultConnection(long waitTime) throws InterruptedException {
		DefaultConnectionWrapper defaultConnectionWrapper = null;
		while (true) {
			// 如果可用连接和已用连接加起来的数量小于最大连接，才允许去获取连接，否则设置时间挂起
			if (use.size() + duse.size() <= getConfiguration().getMaxIdle()) {
				// 如果可用连接小于等于0那就新获取一个连接，返回之前把这个连接放到已用集合中去
				if (duse.size() <= 0) {
					defaultConnectionWrapper = getConnection();
					use.put(defaultConnectionWrapper);
					return defaultConnectionWrapper;
				} else {
					return duse.take();
				}
			} else {
				wait(waitTime);
			}
		}
	}

	// 增加一个连接到已用连接集合中去
	public void addUse(DefaultConnectionWrapper use) {
		this.use.add(use);
	}

	// 移除一个已用连接
	public void removeUse(DefaultConnectionWrapper use) {
		this.use.remove(use);
	}

	// 增加一个可用连接
	public void addDuse(DefaultConnectionWrapper duse) {
		this.duse.add(duse);
	}

	// 移除一个可用连接
	public void removeDuse(DefaultConnectionWrapper duse) {
		this.duse.remove(duse);
	}

	public ArrayBlockingQueue<DefaultConnectionWrapper> getUse() {
		return use;
	}

	public ArrayBlockingQueue<DefaultConnectionWrapper> getDuse() {
		return duse;
	}

	public void setUse(ArrayBlockingQueue<DefaultConnectionWrapper> use) {
		this.use = use;
	}

	public void setDuse(ArrayBlockingQueue<DefaultConnectionWrapper> duse) {
		this.duse = duse;
	}
}
