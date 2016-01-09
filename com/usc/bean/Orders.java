package com.usc.bean;

import java.io.Serializable;
import java.sql.Date;
/**
 * ������
 * @author zhao
 *
 */
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;//����
	private int num;//����
	private double commission;//Ӷ��
	private String state;//״̬
	private Date endTime;//����ʱ��
	private Date startTime;//��ʼʱ��
	private int farmlandId;//ũ��id
	private int agentId;//������id
	private int machineOwnerId;//ũ����id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getFarmlandId() {
		return farmlandId;
	}
	public void setFarmlandId(int farmlandId) {
		this.farmlandId = farmlandId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getMachineOwnerId() {
		return machineOwnerId;
	}
	public void setMachineOwnerId(int machineOwnerId) {
		this.machineOwnerId = machineOwnerId;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", num=" + num + ", commission="
				+ commission + ", state=" + state + ", endTime=" + endTime
				+ ", farmlandId=" + farmlandId + ", agentId=" + agentId
				+ ", machineOwnerId=" + machineOwnerId + "]";
	}
	
}
