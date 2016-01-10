package com.usc.daoimpl;

import java.security.acl.Owner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.usc.bean.MachineOwner;
import com.usc.util.Constant;
import com.usc.util.DBUtil;

/**
 * 农机主查看个人信息
 * 
 * @author lilin
 * @time 2016年1月10日 上午11:30:35
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class MachineOwnerDao {
	private static Connection connection = null;

	public MachineOwnerDao() {
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
	}

	/**
	 * 查询农机主的信息 根据农机主的id查询
	 * 
	 * @param mOwner
	 *            农机主对象，农机主的id必须不为空
	 * @return 返回农机主对象 包含全部的查询到的属性值
	 */
	public MachineOwner selectMachineOwerInfo(MachineOwner mOwner) {
		// 返回查询农机主信息的对象实体
		MachineOwner machineOwner = null;
		// 若需要查询的对象不为空
		if (mOwner != null) {
			// 拼接查询语句sql
			String sql = "select * from " + Constant.TB_MACHINEOWNER + " where " + Constant.ID_MACHINEOWNER + " = "
					+ mOwner.getId() + ";";
			try {
				// 链接数据库
				Statement statement = connection.createStatement();
				// 向数据库中发送sql执行查询事务
				ResultSet resultSet = statement.executeQuery(sql);
				// 查询数据库获得数据记录
				if (resultSet.next()) {
					// 将返回的对象实例化
					machineOwner = new MachineOwner();

					// 提取数据并封装数据到返回的实体当中
					// 封装id
					machineOwner.setId(mOwner.getId());
					// 获取地址
					machineOwner.setLocation(resultSet.getString(Constant.LOCATION_MACHINEOWNER));
					// 获取姓名
					machineOwner.setName(resultSet.getString(Constant.NAME_MACHINEOWNER));
					// 获取密码
					machineOwner.setPassword(resultSet.getString(Constant.PASSWORD_MACHINEOWNER));
					// 获取电话号码
					machineOwner.setTel(resultSet.getString(Constant.TEL_MACHINEOWNER));
					// 获取预留字段内容
					machineOwner.setRemarks1(resultSet.getString(Constant.REMARKS1_MACHINEOWNER));
					// 获取预留字段内容
					machineOwner.setRemarks2(resultSet.getString(Constant.REMARKS2_MACHINEOWNER));
					// 获取预留字段内容
					machineOwner.setRemarks3(resultSet.getString(Constant.REMARKS3_MACHINEOWNER));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return machineOwner;
	}

	/**
	 * 农机主注册
	 * 
	 * @param machineOwner
	 *            封装了农机主信息的实体类
	 * @return 返回是否注册成功
	 */
	public boolean register(MachineOwner machineOwner) {
		boolean canRegister = false;
		// 参数为空 不给予操作
		if (machineOwner == null) {
			canRegister = false;
		} else {
			// 判断是否改电话号码已被注册了
			if (isExist(machineOwner.getTel())) {
				canRegister = false;
			} else {
				// 拼接sql
				String sql = "insert into " + Constant.TB_MACHINEOWNER + " (" + Constant.NAME_MACHINEOWNER + ","
						+ Constant.PASSWORD_MACHINEOWNER + "," + Constant.LOCATION_MACHINEOWNER + ","
						+ Constant.TEL_MACHINEOWNER + "," + Constant.REMARKS1_MACHINEOWNER + ","
						+ Constant.REMARKS2_MACHINEOWNER + "," + Constant.REMARKS3_MACHINEOWNER + " ) values('"
						+ machineOwner.getName() + "','" + machineOwner.getPassword() + "','"
						+ machineOwner.getLocation() + "','" + machineOwner.getTel() + "','"
						+ machineOwner.getRemarks1() + "','" + machineOwner.getRemarks2() + "','"
						+ machineOwner.getRemarks3() + "');";
				try {
					// 获取链接
					Statement statement = connection.createStatement();
					// 向数据库中插入数据
					int update = statement.executeUpdate(sql);
					// 判断受影响的行数，大于0则是插入成功
					if (update > 0) {
						canRegister = true;
					} else {
						canRegister = false;
					}

				} catch (Exception e) {
					e.printStackTrace();
					canRegister = false;
				}

				canRegister = true;
			}

		}

		return canRegister;
	}

	/**
	 * 查询该电话号码是否已经注册为用户
	 * 
	 * @param tel
	 *            需要检测的电话号码
	 * @return 返回是否存在，true为应存在是平台的用户，false为未存在表中
	 */
	public boolean isExist(String tel) {
		// 是否存在的临时变量
		boolean isExist = true;
		// 拼接收sql
		String sql = "select * from " + Constant.TB_MACHINEOWNER + " where " + Constant.TEL_MACHINEOWNER + " ='" + tel
				+ "';";
		try {
			// 链接数据库
			Statement statement = connection.createStatement();
			// 向数据库表中获取结果集
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println(resultSet);
			// 判断返回的结果集是否存在记录。若有记录则是已经是用户了
			if (resultSet.next()) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isExist;
	}

	/**
	 * 农机主登陆 必须存在用户名 密码数据
	 * 
	 * @param machineOwner
	 *            农机主的信息
	 * @return 是否登陆成功
	 */
	public boolean login(MachineOwner machineOwner) {
		// 是否登陆成功
		boolean isLogin = false;
		// 农机主信息对象为空 不给予操作
		if (machineOwner == null) {
			isLogin = false;
		} else {
			// 用户名已经存在
			if (useNameIsExist(machineOwner.getName())) {
				// 拼接sql
				String sql = "SELECT * FROM " + Constant.TB_MACHINEOWNER + " where " + Constant.NAME_MACHINEOWNER
						+ " = '" + machineOwner.getName() + " ' and " + Constant.PASSWORD_MACHINEOWNER + " ='"
						+ machineOwner.getPassword() + "';";
				try {
					// 获取链接
					Statement statement = connection.createStatement();
					// 向数据库查询并获取结果集
					ResultSet resultSet = statement.executeQuery(sql);
					// 结果集存在记录，则登陆成功
					if (resultSet.next()) {
						isLogin = true;
					} else {
						isLogin = false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
					isLogin = false;
				}
				// 用户名不存在
			} else {
				isLogin = false;
			}
		}
		return isLogin;
	}

	/**
	 * 根据用户名判断是否存在该用户
	 * 
	 * @param name
	 *            用户名
	 * @return 返回该用户名是否存在
	 */
	private boolean useNameIsExist(String name) {
		// 是否存在的临时变量
		boolean isExist = false;
		// 名字为空
		if (name == null || name.equals("")) {
			isExist = false;
		} else {
			// 拼接sql
			String sql = "select * from " + Constant.TB_MACHINEOWNER + " where " + Constant.NAME_MACHINEOWNER + "='"
					+ name.trim() + "';";
			try {
				// 链接数据库
				Statement statement = connection.createStatement();
				// 向数据库查询获取结果集
				ResultSet resultSet = statement.executeQuery(sql);
				// 结果集存在结果记录，级用户名已经存在
				if (resultSet.next()) {
					isExist = true;
				} else {
					isExist = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				isExist = false;
			}
		}

		return isExist;
	}

}
