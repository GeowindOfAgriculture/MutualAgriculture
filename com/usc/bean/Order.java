package com.usc.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * 订单实体类
 * 
 * @author zhao
 * 
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;// 主键
	private int num;// 数量
	private double commission;// 佣金
	private String state;// 状态״
	private Date endTime;// 截至时间
	private Date startTime;// 开始时间
	private int farmlandId;// 农田id
	private int agentId;// 经纪人id
	private int machineOwnerId;// 农机主id
	
	private Farmland farmland;//和订单相关的农田信息
	
	

	public Farmland getFarmland() {
		return farmland;
	}

	public void setFarmland(Farmland farmland) {
		this.farmland = farmland;
	}

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
		return "Orders [id=" + id + ", num=" + num + ", commission=" + commission + ", state=" + state + ", endTime="
				+ endTime + ", farmlandId=" + farmlandId + ", agentId=" + agentId + ", machineOwnerId=" + machineOwnerId
				+ "]";
	}

}
