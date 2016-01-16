package com.usc.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.bean.MOIsAccept;
import com.usc.bean.MOResponses;
import com.usc.bean.MachineOwner;
import com.usc.bean.Order;
import com.usc.bean.OrderList;
import com.usc.daoimpl.MachineOwnerDao;
import com.usc.daoimpl.OrdersDao;
import com.usc.util.Constant;

/**
 * 农机主 action操作 登陆，注册 等
 *
 * 
 * @author lilin
 * @time 2016年1月16日 下午4:48:34
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class MachineOwnerAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private ServletRequest request;
	private ServletResponse response;

	/**
	 * action中登陆操作
	 */
	public void login() {
		// 获取请求中的JSon数据
		String machineOwerJson = request.getParameter("machineOwerJson");

		// 获取GSON对象
		Gson gson = new Gson();
		// 从json数据解析成对象
		MachineOwner machineOwner = gson.fromJson(machineOwerJson, MachineOwner.class);

		// 获取数据库操作dao层对象
		MachineOwnerDao machineOwnerDao = new MachineOwnerDao();
		// 判断该用户使用的电话号码是否存在
		boolean telIsExist = machineOwnerDao.useTelIsExist(machineOwner.getTel());

		// 实例化用户请求的相应对象
		MOResponses responses = new MOResponses();

		// 根据是否存在电话号码进行一下操作
		if (telIsExist) {
			// 登陆是否成功
			boolean isLogin = machineOwnerDao.login(machineOwner);
			// 登陆成功
			if (isLogin) {
				responses.setSuccess(true);
			} else {
				responses.setSuccess(false);
				responses.setReason(Constant.PSWWRONG);
			}
		} else {
			responses.setSuccess(false);
			responses.setReason(Constant.TELNOTEXIST);
		}

		// 将相应的对象变成json数据格式·
		String responsesJson = new Gson().toJson(responses);
		try {
			// 向客户端写出相应对象的json数据
			response.getWriter().write(responsesJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * action中注册操作
	 */
	public void register() {
		// 获取请求中的JSon数据
		String machineOwerJson = request.getParameter("machineOwerJson");
		System.out.println(machineOwerJson);
		Gson gson = new Gson();// 获取GSON对象
		MachineOwner machineOwner = gson.fromJson(machineOwerJson, MachineOwner.class);// 从json数据解析成对象
		MachineOwnerDao machineOwnerDao = new MachineOwnerDao();// 获取数据库操作dao层对象
		boolean exist = machineOwnerDao.isExist(machineOwner.getTel());// 判断该用户使用的电话号码是否存在
		MOResponses responses = new MOResponses();// 实例化用户请求的相应对象
		if (exist) {// 电话号码已被注册
			responses.setSuccess(false);
			responses.setReason(Constant.TELEXIST);
		} else {// 电话号码未被注册
			boolean register = machineOwnerDao.register(machineOwner);// 注册操作
			if (register) {// 是否注册成功
				responses.setSuccess(true);
			} else {
				responses.setSuccess(false);
				responses.setReason(Constant.SQLWRONG);
			}
		}
		System.out.println(responses);
		String responsesJson = new Gson().toJson(responses);
		try {
			System.out.println(responsesJson);
			response.getWriter().write(responsesJson);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 农机主查看个人信息
	 */
	public void selectMachineOwerInfo() {
		// 获取请求中的JSon数据
		String machineOwerJson = request.getParameter("machineOwerJson");
		// 获取GSON对象
		Gson gson = new Gson();
		// 从json数据解析成对象
		MachineOwner machineOwner = gson.fromJson(machineOwerJson, MachineOwner.class);
		// 获取数据库操作dao层对象
		MachineOwnerDao machineOwnerDao = new MachineOwnerDao();
		// 向数据库中查信息
		MachineOwner machineOwerInfo = machineOwnerDao.selectMachineOwerInfo(machineOwner);
		// 获取到的查询对象形成json格式数据
		String machineOwerInfoJson = new Gson().toJson(machineOwerInfo);
		try {
			// 向客户端写出相应数据
			response.getWriter().write(machineOwerInfoJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 农机主是否接受被推送的订单任务
	 */
	public void MOIsAccept(){
		//解析出请求过来的json数据
		String moIsAcceptJson = request.getParameter("MOIsAccept");
		//json数据封装成对象
		MOIsAccept moIsAccept = new Gson().fromJson(moIsAcceptJson, com.usc.bean.MOIsAccept.class);
		//获取数据库操作对象实例
		OrdersDao ordersDao = new OrdersDao();
		//获取农机主是否接收该推送的订单
		boolean accept = moIsAccept.isAccept();
		//获取订单
		Order order = moIsAccept.getOrder();
		//实例化向客户请求的数据对象
		MOResponses responses = new MOResponses();
		if(accept){//接收
			//向数据库中执行接收的相关操作
			boolean isSusscee = ordersDao.acceptOrder(order);
			//向相应对象中设置相关的属性，表示是否修改成功
			responses.setSuccess(isSusscee);
		}else{//拒绝
			boolean isSusscee = ordersDao.refuseOrder(order);
			responses.setSuccess(isSusscee);
		}
	}

	/**
	 * action中操作 查看被推送的订单
	 */
	public void selectPushedOrder() {
		// 获取请求中的JSon数据
		String machineOwerJson = request.getParameter("machineOwerJson");
		// 获取GSON对象
		Gson gson = new Gson();
		// 从json数据解析成对象
		MachineOwner machineOwner = gson.fromJson(machineOwerJson, MachineOwner.class);
		// 获取数据库操作dao层对象
		OrdersDao ordersDao = new OrdersDao();
		//获取被推送的订单
		ArrayList<Order> pushedOrders = ordersDao.selectPushedOrder(machineOwner);
		//实例化订单队列对象 
		OrderList orderList = new OrderList();
		//将获取的订单队列封装到订单队列对象中的队列
		orderList.setOders(pushedOrders);
		//将订单队列封装为json格式数据
		String orderListJson = new Gson().toJson(orderList);
		try {
			//向服务器写出相应结果
			response.getWriter().write(orderListJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 农机主action操作中
	 * 农机主查看历史订单
	 */
	public void selectOrderHistory(){
		// 获取请求中的JSon数据
				String machineOwerJson = request.getParameter("machineOwerJson");
				// 获取GSON对象
				Gson gson = new Gson();
				// 从json数据解析成对象
				MachineOwner machineOwner = gson.fromJson(machineOwerJson, MachineOwner.class);
				// 获取数据库操作dao层对象
				OrdersDao ordersDao = new OrdersDao();
				//获取被历史订单
				ArrayList<Order> pushedOrders = ordersDao.selectOrderHistory(machineOwner);
				//实例化订单队列对象 
				OrderList orderList = new OrderList();
				//将获取的订单队列封装到订单队列对象中的队列
				orderList.setOders(pushedOrders);
				//将订单队列封装为json格式数据
				String orderListJson = new Gson().toJson(orderList);
				try {
					//向服务器写出相应结果
					response.getWriter().write(orderListJson);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * 获取ServletResponse对象
	 */
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	/**
	 * 获取ServletRequest对象
	 */
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

}
