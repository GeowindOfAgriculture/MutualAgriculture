package test;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.usc.util.DBHelper;

public class TestConn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBHelper dbHelper=new DBHelper();
		Connection connection =dbHelper.getConnection();
		if (connection != null) {
			System.out.println("connection ok");
		}
		
		String sql="insert into tb_test(id,name,age，birthday) values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(2);
		params.add("赵鑫");
		params.add("20");
		params.add(new Date(new java.util.Date().getTime()));
		int i= dbHelper.doUpdate(sql, params);
		if(i!=0){
			System.out.println("插入成功");
		}
	}

}
