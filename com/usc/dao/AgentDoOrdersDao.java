package com.usc.dao;

import java.util.List;

import com.usc.bean.Agent;
import com.usc.bean.Order;

public interface AgentDoOrdersDao {
	/**
	 * 经纪人获取发布且完成的订单
	 * 
	 * @return
	 */
	public List<Order> getOrders_PubAndUnCom(Agent agent);

	/**
	 * 经纪人获取发布但未完成的订单
	 * 
	 * @return
	 */
	public List<Order> getOrders_PubAndCom(Agent agent);
	
	/**
	 * 经纪人发布订单
	 * @param agent 经纪人
	 * @param order 订单
	 * @return
	 */
	public boolean publishOrder(Agent agent, Order order);
	/**
	 * 撤销订单
	 * 
	 * @param agent
	 *            经纪人
	 * @param order
	 *            订单
	 * @return
	 */
	public boolean cancelOrder(Agent agent, Order order);
}
