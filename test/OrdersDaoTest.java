package test;

import java.util.ArrayList;

import org.junit.Test;

import com.usc.bean.MachineOwner;
import com.usc.bean.Order;
import com.usc.daoimpl.OrdersDao;

public class OrdersDaoTest {
	/**
	 * 单测获取历史订单
	 */
//	 @Test
	public void selectOrderHistory() {
		OrdersDao dao = new OrdersDao();
		MachineOwner owner = new MachineOwner();
		owner.setId(1);
		ArrayList<Order> list = dao.selectOrderHistory(owner);
		for (Order order : list) {
			System.out.println(order);
		}
	}

	/**
	 * 单测被推送的订单
	 */
//	@Test
	public void selectPushedOrder() {
		OrdersDao dao = new OrdersDao();
		MachineOwner owner = new MachineOwner();
		owner.setId(1);
		ArrayList<Order> list = dao.selectPushedOrder(owner);
		for (Order order : list) {
			System.out.println(order);
		}
	}

	/**
	 * 单测 接收订单
	 */
//	@Test
	public void acceptOrder(){
		OrdersDao dao = new OrdersDao();
		MachineOwner owner = new MachineOwner();
		owner.setId(2);
//		ArrayList<Order> list = dao.selectOrderHistory(owner);
		ArrayList<Order> list = dao.selectPushedOrder(owner);
		System.out.println(list);
		for (Order order : list) {
			System.out.println(dao.acceptOrder(order));
		}
	}
	/**
	 * 单测 拒绝
	 */
	@Test
	public void refuseOrder(){
		System.out.println("======");
		OrdersDao dao = new OrdersDao();
		MachineOwner owner = new MachineOwner();
		owner.setId(1);
//		ArrayList<Order> list = dao.selectOrderHistory(owner);
		ArrayList<Order> list = dao.selectPushedOrder(owner);
		for (Order order : list) {
			System.out.println(order);
			System.out.println(dao.refuseOrder(order));
		}
	}
	
}
