package com.usc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.usc.bean.Order;

/**
 * 数据库的工具类 主要是数据库的增改操作 单例实现
 * 
 * @author lilin
 * @time 2016年1月11日 下午5:12:10
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class SQlUtil {
	private static SQlUtil sqlUtil = null;

	private SQlUtil() {
	}

	/**
	 * 获取数据库的工具类
	 * 
	 * @return
	 */
	public static SQlUtil getSQLUtil() {
		if (sqlUtil == null) {
			sqlUtil = new SQlUtil();
		}
		return sqlUtil;
	}

	/**
	 * 执行sql 修改表的属性
	 * 
	 * @param sql
	 *            需要执行的sql
	 * @param connection
	 *            数据库链接对象 Connection
	 * @return 是否修改成功
	 */
	public boolean update(String sql, Connection connection) {
		boolean succeed = false;
		// sql不为空且不为“”
		if (sql != null && !("".equals(sql))) {
			try {
				// 链接
				Statement statement = connection.createStatement();
				// 执行sql修改表的字段
				int update = statement.executeUpdate(sql);
				// 根据受影响的行数是否大于0 判断是否修改成功
				if (update > 0) {
					succeed = true;
				} else {
					succeed = false;
				}

			} catch (SQLException e) {
				succeed = false;
				e.printStackTrace();
			}
		} else {
			succeed = false;
		}

		return succeed;
	}

	/**
	 * 执行SQL获取订单
	 * 
	 * @param sql
	 *            需要执行的sql
	 * @param connection
	 *            数据库链接对象 Connection
	 * @return 返回订单的队列
	 */
	public ArrayList<Order> getOrders(String sql, Connection connection) {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			// 链接数据库
			Statement statement = connection.createStatement();
			// 向数据库中查询 获取结果集
			ResultSet resultSet = statement.executeQuery(sql);
			// 订单实体
			Order order = null;
			// 循环读取结果集
			while (resultSet.next()) {
				order = new Order();
				// 获取ID并封装
				order.setId(resultSet.getInt(Constant.ID_ORDER));
				// 获取数量并封装
				order.setNum(resultSet.getInt(Constant.NUM_ORDER));
				// 获取结果并封装
				order.setCommission(resultSet.getDouble(Constant.COMMISSION_ORDER));
				// 获取开始时间并封装
				order.setStartTime(resultSet.getDate(Constant.STARTTME_ORDER));
				// 获取结束时间并封装
				order.setEndTime(resultSet.getDate(Constant.ENDTIME_ORDER));
				// 获取农田id并封装
				order.setFarmlandId(resultSet.getInt(Constant.FARMLANDID_ORDER));
				// 获取农村经济人id并封装
				order.setAgentId(resultSet.getInt(Constant.AGENTID_ORDER));
				// 获取农机主id并封装
				order.setMachineOwnerId(resultSet.getInt(Constant.MACHINEOWNERID_ORDER));
				//获取状态并封装
				order.setState(resultSet.getString(Constant.STATE_ORDER));
				// 将数据对象保存进队列当总
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

}
