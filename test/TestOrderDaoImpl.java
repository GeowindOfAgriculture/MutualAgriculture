package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usc.dao.OrderDao;
import com.usc.daoimpl.OrdersDaoImpl;

public class TestOrderDaoImpl {

	@Test
	public void TestGetOrderState() {
		OrderDao orderDao=new OrdersDaoImpl();
		String stateString=orderDao.getOrderState(3);
		System.out.println(stateString);
	}

}
