package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usc.bean.Machine;
import com.usc.bean.MachinePic;
import com.usc.util.DBHelper;

/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-17
 * @Description  农机相关操作
 */
public class MachineDao {
	/**
	 * 注册农机
	 * @return 当前注册农机的id
	 */
	public int registerMachine(Machine machine){
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into machine(machineOwnerId,model,userAge,des) values(?,?,?,?)";
		try {
			pstmt=connection.prepareStatement(sql);
			connection.setAutoCommit(false);
			pstmt.setInt(1, machine.getMachineOwnerId());
			pstmt.setString(2, machine.getModel());
			pstmt.setInt(3, machine.getUserAge());
			pstmt.setString(4, machine.getDes());
			int i= pstmt.executeUpdate();
			connection.commit();
			if(i==1){
				rs= connection.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
				while(rs.next()){
					//返回刚插入记录的id
					return rs.getInt("LAST_INSERT_ID()");
				}
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBHelper.closeAll(rs, pstmt, connection);
		}
		return -1;
	}
	/**
	 * 通过农机id获取农机的所有图片
	 * @param id 农机id
	 * @return 农机图片的url集合
	 */
	public List<String> getMachinePicByMachineId(int id){
		List<String> urls=new ArrayList<String>();
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select url from machine m join machinePic mp on m.id=mp.machineId where m.id=?";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs= pstmt.executeQuery();
			while(rs.next()){
				String url= rs.getString("url");
				urls.add(url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(rs, pstmt, connection);
		}
		if(urls.size()>0){
			return urls;
		}else {
			return null;
		}
	}
	
	/**
	 * 根据农机图片url存储农机图片
	 * @param machinePic 农机图片实体类
	 * @return
	 */
	public boolean storeMachinePicToURL(MachinePic machinePic){
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="insert into machinePic(url,machineId) values(?,?)";
		try {
			pstmt=connection.prepareStatement(sql);
			connection.setAutoCommit(false);
			pstmt.setString(1, machinePic.getUrl());
			pstmt.setInt(2, machinePic.getMachineId());
			int i= pstmt.executeUpdate();
			connection.commit();
			if(i==1){
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBHelper.closeAll(rs, pstmt, connection);
		}
		
		return false;
	}
	
	/**
	 * 通过手机号查询到当前农机主的id
	 * 
	 * @return 农机主id 若返回-1，则表示没有查到
	 */
	public int getMachineOwnerIdByTel(String tel) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from machineOwner where tel=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}

		return -1;
	}
}
