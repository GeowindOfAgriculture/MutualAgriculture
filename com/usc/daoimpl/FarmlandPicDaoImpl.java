package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usc.bean.FarmlandPic;
import com.usc.dao.FarmlandPicDao;
import com.usc.util.Constant;
import com.usc.util.DBHelper;

public class FarmlandPicDaoImpl implements FarmlandPicDao {

	@Override
	public boolean storeFarmlandPicToURL(FarmlandPic pic) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into " + Constant.TB_FARMLANDPIC
				+ "(url,farmlandId) values(?,?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, pic.getUrl());
			pstmt.setInt(2, pic.getFarmlandId());
			int i = pstmt.executeUpdate();
			if (i == 1) {
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
	public List<String> getFarmlandPicURLByFarmlandId(int farmlandId) {
		List<String> urls=new ArrayList<String>();
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select url from farmland f join farmlandpic fp on f.id=fp.farmlandId where f.id=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, farmlandId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String picUrl = rs.getString("url");
				urls.add(picUrl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(rs, pstmt, connection);
		}
		return urls.size()>0?urls:null;
	}

}
