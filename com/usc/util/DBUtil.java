package com.usc.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 获取数据库链接对象 实现获取单例数据库的链接对象Connection
 * 
 * @author lilin
 * @time 2016年1月9日 下午10:55:07
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public final class DBUtil {
	// 数据库的链接对对象
	private static Connection connection = null;

	/**
	 * 获取数据库的链接对象
	 * 
	 * @return 数据库的链接对象 Connection
	 */
	public static Connection getConnection() {
		if (connection == null) {
			String name = "root";// 数据库用户名
			String psw = "mysql";// 数据库链接密码
			// 数据库链接的数据
			String url = "jdbc:mysql://localhost:3306/db_agriculture?user=" + name + "&password=" + psw
					+ "&useUnicode=true&characterEncoding=UTF-8";
			try {
				// 创建数据库的链接
				Class.forName("com.mysql.jdbc.Driver");
				// 获取链接对象
				connection = DriverManager.getConnection(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("获取数据库链接对象成功");
		}
		return connection;

	}

	

}
