package com.usc.dao;

import java.util.List;

import com.usc.bean.Order;
/**
 * 订单数据访问接口
 * @author zhao
 *
 */
public interface OrderDao {

	/**
	 * 获取订单状态״̬
	 * 
	 * @param order
	 * @return
	 */
	public String getOrderState(Order order);

	/**
	 * 
	 * @param user
	 *            用户 分为经纪人或者农机主
	 * @return
	 */
	public List<Order> getOrdersHistory(Object user);

}
