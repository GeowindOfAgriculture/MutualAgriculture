package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usc.bean.Agent;
import com.usc.bean.Order;
import com.usc.dao.AgentDoOrdersDao;
import com.usc.util.Constant;
import com.usc.util.DBHelper;

/**
 * 
 * @author zhao
 * @CreateTime 2016-1-10
 * @Description 经纪人操作订单实现类
 */
public class AgentDoOrdersDaoImpl implements AgentDoOrdersDao {

	@Override
	public List<Order> getOrders_PubAndUnCom(int agentId) {
		List<Order> orders = new ArrayList<Order>();
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from orders where state!= '"
				+ Constant.ORDER_STATE_ACCEPTED_ACCOM + "' and agentId=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, agentId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setAgentId(rs.getInt("agentId"));
				order.setCommission(rs.getDouble("commission"));
				order.setEndTime(rs.getDate("endTime"));
				order.setFarmlandId(rs.getInt("farmlandId"));
				order.setMachineOwnerId(rs.getInt("machineOwnerId"));
				order.setNum(rs.getInt("num"));
				order.setStartTime(rs.getDate("startTime"));
				order.setState(rs.getString("state"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}

		return orders;
	}

	@Override
	public List<Order> getOrders_PubAndCom(int agentId) {
		List<Order> orders = new ArrayList<Order>();
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from orders where state= '"
				+ Constant.ORDER_STATE_ACCEPTED_ACCOM + "' and agentId=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, agentId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setAgentId(rs.getInt("agentId"));
				order.setCommission(rs.getDouble("commission"));
				order.setEndTime(rs.getDate("endTime"));
				order.setFarmlandId(rs.getInt("farmlandId"));
				order.setMachineOwnerId(rs.getInt("machineOwnerId"));
				order.setNum(rs.getInt("num"));
				order.setStartTime(rs.getDate("startTime"));
				order.setState(rs.getString("state"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}

		return orders;
	}

	@Override
	public boolean publishOrder(Order order) {

		// 发布订单前需要先将外键信息对应的表给出入数据，获取外键id再进行订单的发布
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into "
				+ Constant.TB_ORDERS
				+ "(num,commission,state,startTime,endTime,farmlandId,agentId,machineOwnerId) values(?,?,?,?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, order.getNum());
			pstmt.setDouble(2, order.getCommission());
			pstmt.setString(3, order.getState());
			pstmt.setDate(4, order.getStartTime());
			pstmt.setDate(5, order.getEndTime());
			pstmt.setInt(6, order.getFarmlandId());
			pstmt.setInt(7, order.getAgentId());
			pstmt.setInt(8, order.getMachineOwnerId());
			int i = pstmt.executeUpdate();
			connection.commit();
			if (i == 1) {
				return true;
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBHelper.closeAll(rs, pstmt, connection);

		}

		return false;
	}

	@Override
	public boolean cancelOrder(int agentId, int id) {
		// 此处要判断订单有没有被委派给农机主，如果已被委派，那么就不能取消，只能取消审核中的订单
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete  from orders where id=? and agentId=?";
		try {
			connection.setAutoCommit(false);
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, agentId);

			// 订单已被农机主接受，不能取消
			// isOrderAcceptedByMachineOwner()
//			if (isOrderAcceptedByMachineOwner()) {
//				return false;
//			} else {
//				int i = pstmt.executeUpdate();
//				connection.commit();
//				if (i == 1)
//					return true;
//			}
			
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBHelper.closeAll(rs, pstmt, connection);
		}

		return false;
	}

	@Override
	public List<Order> getOrdersHistory(int agentId) {
		List<Order> orders = new ArrayList<Order>();
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from orders where agentId=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, agentId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setAgentId(rs.getInt("agentId"));
				order.setCommission(rs.getDouble("commission"));
				order.setEndTime(rs.getDate("endTime"));
				order.setFarmlandId(rs.getInt("farmlandId"));
				order.setMachineOwnerId(rs.getInt("machineOwnerId"));
				order.setNum(rs.getInt("num"));
				order.setStartTime(rs.getDate("startTime"));
				order.setState(rs.getString("state"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}

		return orders;
	}

}
