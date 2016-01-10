package com.usc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBHelper {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/db_agriculture";
	//private static final String DBURL = "jdbc:mysql://localhost:3306/tb_test";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "123456";
	/**
	 * 注册驱动
	 */
	static {
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取与数据库的联接
	 */
	public static Connection getConnection() {
		Connection con; // 获取连接
		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (SQLException e) {
			 e.printStackTrace(); // 在后台console输出异常信息
			// LogUtil.error(e);
			throw new RuntimeException(e);
		}
		return con;
	}

	/**
	 * 设置pstmt中的参数 stmt.setString(1, Encrypt.md5(pwd)); stmt.setString(2,
	 * uname);
	 * 
	 * @param pstmt
	 * @param params
	 */
	public void setParams(PreparedStatement pstmt, List<Object> params) { // 给预编译sql语句对象赋值
		if (pstmt == null || params == null || params.size() <= 0) {
			return;
		}
		try {
			for (int i = 0; i < params.size(); i++) {
				Object param = params.get(i);
				// 将所有的参数当成String来设置即可
				pstmt.setString(i + 1, param.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// LogUtil.error(e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 关闭与数据库的操作
	 */
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			 e.printStackTrace();
			//LogUtil.error(e);
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// LogUtil.error(e);
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// LogUtil.error(e);
		}
	}

	

	/**
	 * 单语句( 一条sql)的更新
	 * 
	 * @param sql
	 *            : 要执行的增删改的语句(一条)
	 * @param params
	 *            : sql语句中的 ? 对应的参数集合
	 */
	public int doUpdate(String sql, List<Object> params) {
		int r = 0;
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			setParams(stmt, params);
			r = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// LogUtil.error(e);
			throw new RuntimeException(e);
		} finally {
			closeAll(null, stmt, con);
		}
		return r;
	}

	
	
}
