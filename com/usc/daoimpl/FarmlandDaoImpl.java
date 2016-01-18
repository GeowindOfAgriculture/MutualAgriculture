package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usc.bean.Farmland;
import com.usc.dao.FarmlandDao;
import com.usc.util.Constant;
import com.usc.util.DBHelper;

public class FarmlandDaoImpl implements FarmlandDao {

	@Override
	public int addFarmlandInfo(Farmland farmland) {
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into "
				+ Constant.TB_FARMLAND
				+ "(location,size,maturity,perPrice,type,des,harvestTime) values(?,?,?,?,?,?,?);";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, farmland.getLocation());
			pstmt.setInt(2, farmland.getSize());
			pstmt.setInt(3, farmland.getMaturity());
			pstmt.setDouble(4, farmland.getPerPrice());
			pstmt.setString(5, farmland.getType());
			pstmt.setString(6, farmland.getDescription());
			pstmt.setDate(7, farmland.getHarvestTime());
			
			int i= pstmt.executeUpdate();
			if(i==1){
				rs= connection.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
				while(rs.next()){
					//返回刚插入记录的id
					return rs.getInt("LAST_INSERT_ID()");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
