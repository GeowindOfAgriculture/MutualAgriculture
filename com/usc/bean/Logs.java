package com.usc.bean;

import java.io.Serializable;
import java.sql.Date;
	/**
	 * 
	 * @author zhao
	 *	��־��
	 */
public class Logs implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;//����
	private int adminsId;//����Աid
	private int ordersId;//����id
	private int machineOwnerId;//ũ����id
	private Date optime;//����ʱ��
	private String records;//������¼
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
