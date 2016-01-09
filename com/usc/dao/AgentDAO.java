package com.usc.dao;

import com.usc.bean.Agent;
import com.usc.bean.Order;

/**
 * 经纪人的数据访问层接口
 * @author zhao
 *
 */
public interface AgentDAO {
	/**
	 * 经济人登陆
	 * @param username 经纪人用户名
	 * @param password 经纪人密码
	 * @return
	 */
	public boolean login(String username,String password);
	/**
	 * 经纪人注册
	 * @param agent 经纪人实体
	 * @return
	 */
	public boolean regist(Agent agent);
	
	public boolean publishOrder();
	
	public Order seeOrdersFinished();
	
	public Order seeOrdersUnFininshed();
	
	public String seeOrderState();
	
	public boolean undoOrder();
}
