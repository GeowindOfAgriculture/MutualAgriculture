package com.usc.bean;

import java.io.Serializable;

/**
 * MachineOwner农机主的相应请求实体类
 * 
 * 
 * @author lilin
 * @time 2016年1月16日 下午5:14:27
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class MOResponses implements Serializable {
	private boolean isSuccess;// 相应是否符合用户的意愿
	private String reason; // 不成功时候的原因

	public MOResponses() {
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "MOResponses [isSuccess=" + isSuccess + ", reason=" + reason + "]";
	}

}
