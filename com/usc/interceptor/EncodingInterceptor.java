package com.usc.interceptor;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 字符集拦截器 实现请求拦截转换字符集
 * 
 * @author lilin
 * @time 2016年1月17日 下午3:44:50
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class EncodingInterceptor implements Interceptor {
	

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//获取HttpServletResponse对象
		HttpServletResponse response = ServletActionContext.getResponse();
		// 字符集转换
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String invoke = arg0.invoke();
		return invoke;
	}

}
