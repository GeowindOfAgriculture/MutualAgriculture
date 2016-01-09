package com.usc.daoimpl;

import java.util.List;

import com.usc.bean.Agent;
import com.usc.bean.Order;
import com.usc.dao.AgentDAO;

public class AgentDaoImpl implements AgentDAO {

	@Override
	public boolean login(String username, String password) {
		return false;
	}

	@Override
	public boolean regist(Agent agent) {
		return false;
	}

	@Override
	public boolean publishOrder(Order order) {
		return false;
	}

	@Override
	public List<Order> getOrdersFinished() {
		return null;
	}

	@Override
	public List<Order> getOrdersUnFininshed() {
		return null;
	}

	@Override
	public String getOrderState(Order order) {
		return null;
	}

	@Override
	public boolean undoOrder(Order order) {
		return false;
	}

	@Override
	public List<Order> getOrdersHistory() {
		return null;
	}

	@Override
	public boolean GiveMoneyToCompany() {
		return false;
	}

	@Override
	public Agent getAgentInfo(String agentName) {
		return null;
	}

	@Override
	public boolean isAgentRegisted(String username) {
		return false;
	}

	@Override
	public boolean updateAgentInfo(String username) {
		return false;
	}

}
