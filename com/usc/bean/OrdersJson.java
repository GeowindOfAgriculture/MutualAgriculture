package com.usc.bean;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-20
 * @Description  向客户端发送的json数据的订单集合
 */
public class OrdersJson implements Serializable{

	private static final long serialVersionUID = 1L;
	private int ordersNum;
	private List<Order> orders;
	public int getOrdersNum() {
		return ordersNum;
	}
	public void setOrdersNum(int ordersNum) {
		this.ordersNum = ordersNum;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "OrdersJson [ordersNum=" + ordersNum + ", orders=" + orders
				+ "]";
	}
	
}
