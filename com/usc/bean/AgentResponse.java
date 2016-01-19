package com.usc.bean;

import java.io.Serializable;
/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-18
 * @Description  服务器向客户端反馈的操作信息
 */
public class AgentResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean success;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
