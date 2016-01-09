package com.usc.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * 日志表
 * 
 * @author zhao
 */
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;// 主键
	private int adminId;// 管理员id
	private int orderId;// 订单id
	private int machineOwnerId;// 农机主id
	private Date optime;// 操作时间
	private String record;// 操作记录

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMachineOwnerId() {
		return machineOwnerId;
	}

	public void setMachineOwnerId(int machineOwnerId) {
		this.machineOwnerId = machineOwnerId;
	}

	public Date getOptime() {
		return optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	@Override
	public String toString() {
		return "Logs [id=" + id + ", adminsId=" + adminId + ", ordersId="
				+ orderId + ", machineOwnerId=" + machineOwnerId + ", optime="
				+ optime + ", records=" + record + "]";
	}

}
