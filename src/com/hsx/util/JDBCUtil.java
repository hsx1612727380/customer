package com.hsx.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类：1、获取数据库相关的配置文件；2、加载数据库驱动；3、得到连接；4、关闭资源
 * @author hsx
 *
 */
public class JDBCUtil {

	private static String driverClassName = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	/**
	 * 获取数据库相关的配置文件，加载数据库驱动
	 */
	static {
		try {
			InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			driverClassName = properties.getProperty("driverClassName");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			Class.forName(driverClassName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 得到连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void release(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultSet = null;
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			statement = null;
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}
	
}
