package com.usc.bean;

import java.io.Serializable;
import java.sql.Date;
	/**
	 * 
	 * @author zhao
	 *	日志表
	 */
public class Logs implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;//主键
	private int adminsId;//管理员id
	private int ordersId;//订单id
	private int machineOwnerId;//农机主id
	private Date optime;//操作时间
	private String records;//操作记录
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdminsId() {
		return adminsId;
	}
	public void setAdminsId(int adminsId) {
		this.adminsId = adminsId;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
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
	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records = records;
	}
	@Override
	public String toString() {
		return "Logs [id=" + id + ", adminsId=" + adminsId + ", ordersId="
				+ ordersId + ", machineOwnerId=" + machineOwnerId + ", optime="
				+ optime + ", records=" + records + "]";
	}
	
}
