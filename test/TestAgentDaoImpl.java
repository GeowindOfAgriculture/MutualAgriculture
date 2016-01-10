package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usc.bean.Agent;
import com.usc.dao.AgentDAO;
import com.usc.daoimpl.AgentDaoImpl;

public class TestAgentDaoImpl {
	
	AgentDAO agentDAO = new AgentDaoImpl();

	@Test
	public void testIsAgentRegisted() {

		boolean flag = agentDAO.isAgentRegisted("zhaoxin1");
		assertEquals(false, flag);
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
		agent.setName("zhao");
		agent.setPassword("123");
		agent.setLocation("南京");
		agent.setTel("12346489");
		boolean f= agentDAO.updateAgentInfo(agent);
		assertEquals(true, f);
	}
}
