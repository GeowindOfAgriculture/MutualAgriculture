package com.usc.dao;
/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-10
 * @Description  管理员相关操作数据接口
 */
public interface AdminDao {
	/**
	 * 管理员登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean loginAdmin(String username,String password);
	/**
	 * 管理员修改个人信息
	 * @param adminId
	 * @return
	 */
	public boolean updateAdmin(int adminId);
	
}
