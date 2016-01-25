package com.usc.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.usc.bean.Agent;
import com.usc.bean.AgentResponse;
import com.usc.bean.Farmland;
import com.usc.bean.FarmlandPic;
import com.usc.bean.Order;
import com.usc.bean.OrdersJson;
import com.usc.dao.AgentDAO;
import com.usc.dao.AgentDoOrdersDao;
import com.usc.dao.FarmlandDao;
import com.usc.dao.FarmlandPicDao;
import com.usc.dao.OrderDao;
import com.usc.daoimpl.AgentDaoImpl;
import com.usc.daoimpl.AgentDoOrdersDaoImpl;
import com.usc.daoimpl.FarmlandDaoImpl;
import com.usc.daoimpl.FarmlandPicDaoImpl;
import com.usc.daoimpl.OrdersDaoImpl;
import com.usc.util.Constant;

/**
 * 
 * @author zhao
 * @CreateTime 2016-1-18
 * @Description 经纪人移动端访问接口
 */
public class AgentAction extends SuperAction {
	private AgentResponse agentResponse = new AgentResponse();
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private static final long serialVersionUID = 1L;

	/**
	 * 经纪人登陆
	 */
	public void loginAgent() {
		// 获取客户端发来的json数据
		String agenString = request.getParameter("agent");
		try {
			agenString = URLDecoder.decode(agenString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (agenString == null) {
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		} else {
			Agent agent = gson.fromJson(agenString, Agent.class);
			AgentDAO agentDAO = new AgentDaoImpl();
			// 登录手机号如果不存在，反馈手机号码不存在
			boolean isTelExist = agentDAO.isAgentTelRegisted(agent.getTel());

			if (!isTelExist) {
				agentResponse.setSuccess(false);
				agentResponse.setMessage(Constant.TELNOTEXIST);
			} else {
				boolean isLoginSuccess = agentDAO.login(agent.getTel(),
						agent.getPassword());
				// 如果登录成功
				if (isLoginSuccess) {
					agentResponse.setSuccess(true);
					agentResponse.setMessage(Constant.LOGIN_SUCCESS);

				} else {
					agentResponse.setSuccess(false);
					agentResponse.setMessage(Constant.PSWWRONG);
				}
			}
		}

		String resultString = gson.toJson(agentResponse);
		out.println(resultString);
		out.flush();
		out.close();
	}

	/**
	 * 注册经纪人
	 */
	public void registerAgent() {

		// agent为客户端发给服务器的经纪人json数据，包含经纪人的所有注册信息
		String agentString = request.getParameter("agent");
		try {
			agentString = URLDecoder.decode(agentString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (agentString == null) {
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		} else {
			//System.out.println(agentString);
			Agent agent = gson.fromJson(agentString, Agent.class);
			// System.out.println(agent);
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
					//System.out.println("注册成功");
					agentResponse.setSuccess(true);
					agentResponse.setMessage(Constant.REGISTER_SUCCESS);
				} else {
					// 注册失败
					agentResponse.setSuccess(false);
					agentResponse.setMessage(Constant.REGISTER_FAILURE);
				}
			}
		}
		String resultString = gson.toJson(agentResponse);
		out.println(resultString);
		out.flush();
		out.close();

	}

	/**
	 * 查看经纪人个人信息
	 */
	public void getAgentInfo() {
		String agentString = request.getParameter("agent");
		// System.out.println(agentString);
		AgentDAO agentDAO = new AgentDaoImpl();

		if (agentString == null) {
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		} else {
			Agent agent = gson.fromJson(agentString, Agent.class);
			Agent agentInfo = agentDAO.getAgentInfoByTel(agent.getTel());
			// 数据库不含有该经纪人信息
			if (agentInfo == null) {
				agentResponse.setSuccess(true);
				agentResponse.setMessage(Constant.GETINFO_FAILUR);
			} else {
				agentResponse.setSuccess(true);
				agentResponse.setMessage(agentInfo);
			}
		}
		String resultString = gson.toJson(agentResponse);
		out.println(resultString);
		out.flush();
		out.close();

	}

	/**
	 * 经纪人发布订单
	 */
	public void publishOrder() {
		// 获取从客户端发来的订单json数据
		String orderString = request.getParameter("agent");
		Order order = null;
		Farmland farmland = null;
		List<FarmlandPic> pics = null;
		FarmlandDao farmlandDao = new FarmlandDaoImpl();
		FarmlandPicDao farmlandPicDao = new FarmlandPicDaoImpl();
		AgentDoOrdersDao agentDoOrdersDao = new AgentDoOrdersDaoImpl();
		int farmlandId;// 向农田表插入数据后，该记录的id
		if (orderString == null) {
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		} else {
			order = gson.fromJson(orderString, Order.class);
			// 获取所有的order，farmland，farmlandpic信息
			farmland = order.getFarmland();
			pics = farmland.getFarmlandPics();

			// order订单里包含农田对象，农田对象又包含农田图片对象集合
			// 插入订单信息分三个步骤：1、先插入农田信息到农田表产生农田id 2、向农田图片表插入农田图片信息 3、向订单表插入订单信息

			// 向农田表插入农田信息
			farmlandId = farmlandDao.addFarmlandInfo(farmland);
			if (farmlandId != -1) {
				// 向农田图片表插入农田图片url
				for (int i = 0; i < pics.size(); i++) {
					FarmlandPic pic = pics.get(i);
					pic.setFarmlandId(farmlandId);
					boolean istrue = farmlandPicDao.storeFarmlandPicToURL(pic);
					if (!istrue) {
						agentResponse.setSuccess(false);
						agentResponse.setMessage(Constant.INSERTPIC_WRONG);
					}
				}

				// 插入order信息
				order.setFarmlandId(farmlandId);
				boolean isPublishSuccess = agentDoOrdersDao.publishOrder(order);
				if (isPublishSuccess) {
					agentResponse.setSuccess(true);
					agentResponse.setMessage(Constant.PUBLISH_ORDER_SUCCESS);
				} else {
					agentResponse.setSuccess(false);
					agentResponse.setMessage(Constant.PUBLISH_ORDER_FAILURE);
				}

			} else {
				agentResponse.setSuccess(false);
				agentResponse.setMessage(Constant.SQLWRONG);
			}

		}
		String resultString = gson.toJson(agentResponse);
		out.println(resultString);
		out.flush();
		out.close();
	}

	/**
	 * 查看历史订单信息，包含已经完成的和未完成的订单
	 */
	public void getHistoryOrders() {
		String agentString = request.getParameter("agent");
		String resultString;
		OrdersJson ordersJson = new OrdersJson();
		List<Order> orders = new ArrayList<Order>();
		AgentDoOrdersDao agentDoOrdersDao = new AgentDoOrdersDaoImpl();
		if (agentString == null) {
			// agentResponse.setSuccess(false);
			// agentResponse.setMessage(Constant.PARA_NULL);
			ordersJson.setOrders(null);
			ordersJson.setOrdersNum(0);
		} else {
			Agent agent = gson.fromJson(agentString, Agent.class);
			orders = agentDoOrdersDao.getOrdersHistory(agent.getId());
			if (orders.size() == 0) {
				// agentResponse.setSuccess(false);
				// agentResponse.setMessage(Constant.NO_ORDERS);
				ordersJson.setOrders(null);
				ordersJson.setOrdersNum(0);
			} else {
				// agentResponse.setSuccess(true);
				// agentResponse.setMessage(orders);
				ordersJson.setOrders(orders);
				ordersJson.setOrdersNum(orders.size());
			}
		}
		resultString = gson.toJson(ordersJson);
		out.println(resultString);
		out.flush();
		out.close();
	}

	/**
	 * 查看订单状态
	 */
	public void getOrderState() {
		// 向客户端反馈json数据
		String resultString = null;
		// 从客户端接受请求参数
		String stateString = request.getParameter("agent");
		if (stateString == null) {
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		} else {
			Order order = null;
			order = gson.fromJson(stateString, Order.class);
			OrderDao orderDao = new OrdersDaoImpl();
			String state = orderDao.getOrderState(order.getId());
			if (Constant.STATE_ORDER_ACCEPT.equals(state)
					|| Constant.STATE_ORDER_ASSIGNMENT.equals(state)
					|| Constant.STATE_ORDER_COMPLETE.equals(state)
					|| Constant.STATE_ORDER_PENDING.equals(state)
					|| Constant.STATE_ORDER_PUSHED.equals(state)) {

				agentResponse.setSuccess(true);
				agentResponse.setMessage(state);
			} else {
				agentResponse.setSuccess(false);
				agentResponse.setMessage(Constant.GET_ORDERSTATE_FAILURE);
			}
			resultString = gson.toJson(agentResponse);
			out.println(resultString);
			out.flush();
			out.close();
		}
	}

	/**
	 * 取消订单
	 */
	public void cancelOrder() {
		String orderString=request.getParameter("agent");
		AgentDoOrdersDao agentDoOrdersDao=new AgentDoOrdersDaoImpl();
		if(orderString==null){
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		}else {
			Order order= gson.fromJson(orderString, Order.class);
				
			boolean flag= agentDoOrdersDao.cancelOrder(order.getId());
			if(flag){
				agentResponse.setSuccess(true);
				agentResponse.setMessage(Constant.CANCELORDER_SUCCESS);
			}else {
				agentResponse.setSuccess(true);
				agentResponse.setMessage(Constant.CANCELORDER_FAILURE);
			}
		}
		String resultString = gson.toJson(agentResponse);
		out.println(resultString);
		out.flush();
		out.close();
	}

	/**
	 * 经纪人更新个人信息
	 */
	public void updateAgentInfo() {
		String agentString=request.getParameter("agent");
		Agent agent;
		AgentDAO agentDAO=new AgentDaoImpl();
		if(agentString==null){
			agentResponse.setSuccess(false);
			agentResponse.setMessage(Constant.PARA_NULL);
		}else {
			 agent= gson.fromJson(agentString, Agent.class);
			 //更新经纪人信息前，先要判断当前经纪人的手机号码是否存在，存在那么给予更新
			 if(agentDAO.isAgentTelRegisted(agent.getTel())){
				boolean istrue= agentDAO.updateAgentInfo(agent);
				if(istrue){
					agentResponse.setSuccess(true);
					agentResponse.setMessage(Constant.UPDATEAGENTINFO_SUCCESS);
				}
			 }else {
				agentResponse.setSuccess(false);
				agentResponse.setMessage(Constant.TELNOTEXIST);
			}
		}
		
		String resultString = gson.toJson(agentResponse);
		out.println(resultString);
		out.flush();
		out.close();
	}
}
