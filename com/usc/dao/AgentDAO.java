package com.usc.dao;

import java.util.List;

import com.usc.bean.Agent;
import com.usc.bean.Order;

/**
 * 纪经人数据库访问层接口
 * 
 * @author zhao
 * 
 */
public interface AgentDAO {
	/**
	 * 登陆
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);

	/**
	 * 注册
	 * 
	 * @param agent
	 *           经纪人
	 * @return
	 */
	public boolean regist(Agent agent);

	/**
	 * 发布订单
	 * 
	 * @param order
	 *            订单
	 * @return
	 */
	public boolean publishOrder(Order order);

	/**
	 * 获取已完成订单
	 * 
	 * @return
	 */
	public List<Order> getOrdersFinished();

	/**
	 * 获取未完成订单
	 * 
	 * @return
	 */
	public List<Order> getOrdersUnFininshed();

	/**
	 * 获取订单状态״̬
	 * 
	 * @param order
	 * @return
	 */
	public String getOrderState(Order order);

	/**
	 * 撤销订单
	 * 
	 * @param order
	 * @return
	 */
	public boolean undoOrder(Order order);

	/**
	 * 获取订单历史纪录
	 * 
	 * @return
	 */
	public List<Order> getOrdersHistory();

	/**
	 * 经纪人上传金额去公司平台
	 * @return
	 */
	public boolean GiveMoneyToCompany();
	/**
	 * 获取经纪人信息
	 * @param agentName 经纪人用户名
	 * @return
	 */
	public Agent getAgentInfo(String agentName);
	/**
	 * 查看经纪人是否被注册，用户名具有唯一性
	 * @return
	 */
	public boolean isAgentRegisted(String username);
	/**
	 * 更新经纪人信息
	 * @return
	 */
	public boolean updateAgentInfo(String username);
}
