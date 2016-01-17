package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usc.dao.FarmlandPicDao;
import com.usc.util.Constant;
import com.usc.util.DBHelper;

public class FarmlandPicDaoImpl implements FarmlandPicDao {

	@Override
	public int storeFarmlandPicToURL(String url) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="insert into "+Constant.TB_FARMLANDPIC+"(url) values(?)";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, url);
			int i= pstmt.executeUpdate();
			if(i==1){
				rs= connection.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
				while(rs.next()){
					return rs.getInt("LAST_INSERT_ID()");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(rs, pstmt, connection);
		}
		
		return -1;
	}

	@Override
	public String getFarmlandPicURLByFarmlandId(int farmlandId) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//String sql ="select url from  where id=?";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, farmlandId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
