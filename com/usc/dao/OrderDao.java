package com.usc.dao;

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
	public String getOrderState(int orderId);

	
}
