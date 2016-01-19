package com.usc.action;

import com.google.gson.Gson;
import com.usc.bean.Agent;
import com.usc.bean.AgentResponse;
import com.usc.bean.MOResponses;
import com.usc.dao.AgentDAO;
import com.usc.daoimpl.AgentDaoImpl;
import com.usc.util.Constant;

/**
 * 
 * @author zhao
 * @CreateTime 2016-1-18
 * @Description 经纪人移动端访问接口
 */
public class AgentAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	/**
	 * 经纪人登陆
	 */
	public void loginAgent() {

	}

	/**
	 * 注册经纪人
	 */
	public void registerAgent() {
		AgentResponse agentResponse = new AgentResponse();
		Gson gson = new Gson();
		// agent为客户端发给服务器的经纪人json数据，包含经纪人的所有注册信息
		String agentString = request.getParameter("agent");
		if (agentString == null) {
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		} else {
			System.out.println(agentString);
			Agent agent = gson.fromJson(agentString, Agent.class);
			System.out.println(agent);
			// 数据库访问dao层
			AgentDAO agentDAO = new AgentDaoImpl();
			// 首先判断该手机号码是否已经被注册
			boolean isregistered = agentDAO.isAgentTelRegisted(agent.getTel());
			if (isregistered) {
				agentResponse.setSuccess(false);
				agentResponse.setMessage(Constant.TELEXIST);
			} else {
				boolean isRegisterSuccess = agentDAO.regist(agent);
				// 注册成功
				if (isRegisterSuccess) {
					System.out.println("注册成功");
					agentResponse.setSuccess(true);
					agentResponse.setMessage(Constant.REGISTER_SUCCESS);
				} else {
					// 注册失败
					agentResponse.setSuccess(false);
					agentResponse.setMessage(Constant.REGISTER_FAILURE);
				}
			}
		}
		String resultString=gson.toJson(agentResponse);
		out.println(resultString);
		out.flush();
		out.close();

	}

	/**
	 * 查看经纪人个人信息
	 */
	public void getAgentInfo() {

	}

	/**
	 * 经纪人发布订单
	 */
	public void publishOrder() {

	}

	/**
	 * 查看历史订单信息，包含已经完成的和未完成的订单
	 */
	public void getHistoryOrders() {

	}

	/**
	 * 查看订单状态
	 */
	public void getOrderState() {

	}

	/**
	 * 取消订单
	 */
	public void cancelOrder() {

	}
}
