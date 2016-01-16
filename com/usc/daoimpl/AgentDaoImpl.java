package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usc.bean.Agent;
import com.usc.dao.AgentDAO;
import com.usc.util.Constant;
import com.usc.util.DBHelper;

/**
 * 经纪人实现类
 * 
 * @author zhao
 * 
 */
public class AgentDaoImpl implements AgentDAO {

	@Override
	public boolean login(String username, String password) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select " + Constant.PASSWORD_AGENT + "from"
				+ Constant.TB_AGENT + "where" + Constant.NAME_AGENT + "="
				+ username;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String psd = rs.getString(Constant.PASSWORD_AGENT);
				if (psd.equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}
		return false;
	}

	@Override
	public boolean regist(Agent agent) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into " + Constant.TB_AGENT
				+ "(name,password,location,tel) values(?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, agent.getName());
			pstmt.setString(2, agent.getPassword());
			pstmt.setString(3, agent.getLocation());
			pstmt.setString(4, agent.getTel());
			int i = pstmt.executeUpdate();
			connection.commit();
			if (i > 0) {
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
	public Agent getAgentInfoById(int id) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from agent where id=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Agent agent = new Agent();
				agent.setId(rs.getInt("id"));
				agent.setName(rs.getString("name"));
				agent.setPassword(rs.getString("password"));
				agent.setLocation(rs.getString("location"));
				agent.setTel(rs.getString("tel"));
				return agent;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}

		return null;
	}

	@Override
	public boolean isAgentRegisted(String username) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from agent where name=?";
		try {

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}
		return false;
	}

	@Override
	public boolean updateAgentInfo(Agent agent) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String updateSql = "update agent set name=?,password=?,location=?,tel=?"
				+ " where id=?";

		try {
			connection.setAutoCommit(false);
			pstmt = connection.prepareStatement(updateSql);
			pstmt.setString(1, agent.getName());
			pstmt.setString(2, agent.getPassword());
			pstmt.setString(3, agent.getLocation());
			pstmt.setString(4, agent.getTel());
			pstmt.setInt(5, agent.getId());
			// 修改信息前，判断用户名是否已被注册
			// if(!isAgentRegisted(agent.getName())){
			int i = pstmt.executeUpdate();
			connection.commit();
			if (i == 1) {

				return true;
			} else {
				return false;
			}
			// }else {
			// System.out.println("用户名已经被注册，请重新选择");
			// }
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

	

}
