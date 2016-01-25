package com.usc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
	/**
	 * 
	 * @author   zhao
	 * @CreateTime  2016-1-18
	 * @Description  action的父类，实现与servlet通讯接口，可以访问request，response，application等对象
	 */
public class SuperAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, ServletContextAware {
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;
	protected PrintWriter out;
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
		response.setCharacterEncoding("utf-8");
		try {
			out=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		application = arg0;
	}

}
