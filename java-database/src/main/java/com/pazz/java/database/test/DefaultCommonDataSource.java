package com.pazz.java.database.test;

import java.sql.SQLException;
import java.sql.Wrapper;

/**
 * 
* <p>Copyright： Copyright (c) 2017</p>
* <p>Company： 熠道大数据</p>
* @ClassName: DefaultCommonDataSource
* @Description: TODO(管理器)  
* @author liuhonbin  
* @date 2018年4月24日
 */
public class DefaultCommonDataSource extends AbstractCommonDataSource implements Wrapper {
	
	public DefaultCommonDataSource() {

	}

	public void setLoginTimeout(int seconds) throws SQLException {

	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}
}
