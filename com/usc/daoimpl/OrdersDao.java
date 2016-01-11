package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.usc.bean.MachineOwner;
import com.usc.bean.Order;
import com.usc.util.Constant;
import com.usc.util.DBUtil;
import com.usc.util.SQlUtil;

/**
 * 关于订单表的相关操作
 * 
 * @author lilin
 * @time 2016年1月10日 下午8:04:52
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class OrdersDao {

	private static Connection connection;

	public OrdersDao() {
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
	}

	/**
	 * 农机主查看历史订单
	 * 
	 * @param machineOwner
	 *            农机主实体类 ID必须不为空
	 * @return 返回历史订单的队列集合
	 */
	public ArrayList<Order> selectOrderHistory(MachineOwner machineOwner) {
		// 装在历史订单的集合队列
		ArrayList<Order> orders = new ArrayList<>();
		// 农机主实体不为null且id不为0
		if (machineOwner != null && machineOwner.getId() != 0) {
			// 拼接sql
			String sql = "select * from " + Constant.TB_ORDERS + " where " + Constant.MACHINEOWNERID_ORDER + " = "
					+ machineOwner.getId() + ";";
			System.out.println(sql);
			// 调用getOrders方法获取订单的队列
			orders = SQlUtil.getSQLUtil().getOrders(sql, connection);

		}

		return orders;
	}

	/**
	 * 农机主查看被推送的订单
	 * 
	 * @param machineOwner
	 *            农机主对象 必须存在ID数据
	 * @return 返回被对送的订单队列
	 */
	public ArrayList<Order> selectPushedOrder(MachineOwner machineOwner) {
		// 装在历史订单的集合队列
		ArrayList<Order> orders = new ArrayList<>();
		// 农机主对象不为空且id不为0
		if (machineOwner != null && machineOwner.getId() != 0) {
			// 拼接sql
			String sql = "select * from " + Constant.TB_ORDERS + " where " + Constant.MACHINEOWNERID_ORDER + " = "
					+ machineOwner.getId() + " and " + Constant.STATE_ORDER + " ='" + Constant.STATE_ORDER_PUSHED
					+ "'; ";
			// 调用getOrders方法获取订单的队列
			orders = SQlUtil.getSQLUtil().getOrders(sql, connection);

		}
		return orders;
	}

	/**
	 * 农机主接受被推送的订单
	 * 
	 * @param order
	 *            订单 ID必须
	 * @return 是否接收成功
	 */
	public boolean acceptOrder(Order order) {
		boolean succeed = false;
		// 订单不能为空
		if (order != null) {
			// 订单的状态是被推送
			if (order.getState().equals(Constant.STATE_ORDER_PUSHED)) {
				// 拼接sql
				String sql = "UPDATE " + Constant.TB_ORDERS + " SET " + Constant.STATE_ORDER + " = '"
						+ Constant.STATE_ORDER_ACCEPT + "' where " + Constant.ID_ORDER + " = " + order.getId()+";";
				// 修改表的字段值
				succeed = SQlUtil.getSQLUtil().update(sql, connection);
			}
		} else {
			succeed = false;
		}
		return succeed;
	}

	/**
	 * 拒绝被推送的订单
	 * 
	 * @param order
	 *            订单对象 ID必须
	 * @return 是否拒绝成功
	 */
	public boolean refuseOrder(Order order) {
		boolean succeed = false;
		// 订单不能为空
		if (order != null) {
			// 订单的状态是被推送
			if (order.getState().equals(Constant.STATE_ORDER_PUSHED)) {
				// 拼接sql
				String sql = "UPDATE " + Constant.TB_ORDERS + " SET " + Constant.STATE_ORDER + " = '"
						+ Constant.STATE_ORDER_ASSIGNMENT + "' where " + Constant.ID_ORDER + " = " + order.getId();
				System.out.println(sql);
				// 修改表的字段值
				succeed = SQlUtil.getSQLUtil().update(sql, connection);
			}
		} else {
			succeed = false;
		}
		return succeed;
	}

}
