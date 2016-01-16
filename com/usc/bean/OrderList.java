package com.usc.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 订单队列  查询的所有订单都会使用该订单队列封装成json数据
 * 
 * @author lilin
 * @time 2016年1月16日 下午10:21:37
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class OrderList implements Serializable {

	private ArrayList<Order> oders;

	public OrderList() {

	}

	public ArrayList<Order> getOders() {
		return oders;
	}

	public void setOders(ArrayList<Order> oders) {
		this.oders = oders;
	}

	@Override
	public String toString() {
		return "OderList [oders=" + oders + "]";
	}

}
