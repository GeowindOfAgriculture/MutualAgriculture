package com.usc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.usc.bean.Order;
import com.usc.dao.OrderDao;
import com.usc.util.DBHelper;
/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-10
 * @Description  订单数据操作实现类
 */
public class OrdersDaoImpl implements OrderDao {

	@Override
	public String getOrderState(int orderId) {
		//订单状态
		String state=null;
		Connection connection = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select state from orders where id=?";

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				state=rs.getString("state");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return state;
	}

}
