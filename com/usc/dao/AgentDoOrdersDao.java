package com.usc.dao;

import java.util.List;

import com.usc.bean.Order;
/**
 * 经纪人操作订单相关接口
 * @author zhao
 *
 */
public interface AgentDoOrdersDao {
	/**
	 * 经纪人获取发布且未完成的订单
	 * 
	 * @return
	 */
	public List<Order> getOrders_PubAndUnCom(int agentId);

	/**
	 * 经纪人获取发布且完成的订单
	 * 
	 * @return
	 */
	public List<Order> getOrders_PubAndCom(int agentId);
	
	/**
	 * 经纪人发布订单
	 * @param order 订单
	 * @return
	 */
	public boolean publishOrder( Order order);
	/**
	 * 撤销订单
	 * 
	 * @param orderId
	 *            订单id
	 * @return
	 */
	public boolean cancelOrder(int orderId);
	/**
	 * 获取经纪人订单历史纪录(包含完成和未完成的订单)
	 * @param agentId 
	 * @return
	 */
	public List<Order> getOrdersHistory(int agentId);
}
