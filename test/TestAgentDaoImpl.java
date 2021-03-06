package test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.usc.bean.Agent;
import com.usc.bean.Order;
import com.usc.dao.AgentDAO;
import com.usc.dao.AgentDoOrdersDao;
import com.usc.daoimpl.AgentDaoImpl;
import com.usc.daoimpl.AgentDoOrdersDaoImpl;
/**
 * 
 * @author zhao
 *
 */
public class TestAgentDaoImpl {
	
	AgentDAO agentDAO = new AgentDaoImpl();
	AgentDoOrdersDao agentDoOrdersDao=new AgentDoOrdersDaoImpl();
	
	@Test
	public void testAgentLogin(){
		boolean flag= agentDAO.login("123456", "123456");
		System.out.println(flag);
	}
	
	
	@Test
	public void testRegist() {
		Agent agent=new Agent();
		agent.setName("zhaoxin");
		agent.setPassword("123");
		agent.setLocation("北京");
		agent.setTel("12346489");
		
		agentDAO.regist(agent);
	}
	
	@Test
	public void testUpdateInfo(){
		Agent agent=new Agent();
		agent.setId(7);
		agent.setName("zhaoxin");
		agent.setPassword("123456");
		agent.setLocation("南京");
		agent.setTel("12346489");
		boolean f= agentDAO.updateAgentInfo(agent);
		//assertEquals(true, f);
		if(f){
			System.out.println("update ok");
		}
	}
	
	@Test
	public void testGetAgentByTel(){
		Agent agent= agentDAO.getAgentInfoByTel("123456");
		System.out.println(agent);
	}
	
	@Test
	public void TestPublishOrder(){
		Order order=new Order();
		order.setAgentId(7);
		order.setId(1);
		order.setCommission(1000000);
		order.setEndTime(new Date(new java.util.Date().getTime()));
		order.setFarmlandId(1);
		//order.setMachineOwnerId(1);
		order.setNum(10);
		order.setStartTime(new Date(new java.util.Date().getTime()));
		
		
		agentDoOrdersDao.publishOrder( order);
	}
	
	@Test
	public void TestGetOrders_PubAndUnCom(){
		List<Order> orders= agentDoOrdersDao.getOrders_PubAndUnCom(7);
		System.out.println(orders);
	}
	
	@Test
	public void TestGetOrders_PubAndCom(){
		List<Order> orders= agentDoOrdersDao.getOrders_PubAndCom(7);
		System.out.println(orders);
	}
	
	@Test
	public void TestCancelOrder(){
		boolean flag= agentDoOrdersDao.cancelOrder(1);
		assertEquals(true, flag);
	}
	
	@Test
	public void TestgetOrdersHistory(){
		List<Order> orders= agentDoOrdersDao.getOrdersHistory(7);
		System.out.println(orders);
	}
}
