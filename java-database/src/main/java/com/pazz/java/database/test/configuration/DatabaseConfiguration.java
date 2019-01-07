package com.pazz.java.database.test.configuration;

import lombok.Data;

/**
 * 
* <p>Copyright： Copyright (c) 2017</p>
* <p>Company： 熠道大数据</p>
* @ClassName: DatabaseConfiguration  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author liuhonbin
* @date 2018年4月24日
 */
@Data
public class DatabaseConfiguration {

	private String username;
	private String password;
	private String driverClass;
	private String jdbcUrl;
	private int initialSize = 0;
	private int minIdle = 0;
	private int maxIdle = 0;
	private int maxActive = 0;
	private long maxWait = 0;

	public DatabaseConfiguration() {
		// TODO Auto-generated constructor stub
	}

}
