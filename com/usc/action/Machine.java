package com.usc.action;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Machine
 * 
 * @author lilin
 * @time 2016年1月16日 下午4:45:23
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class Machine extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private ServletResponse response;
	private ServletRequest request;

	public void logina() throws IOException {
		response.getWriter().write("gaosi");
	}

	/**
	 * 获取response 对象
	 * 
	 * @param arg0
	 */
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	/**
	 * 获取request对象
	 * 
	 * @param arg0
	 */
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

}
