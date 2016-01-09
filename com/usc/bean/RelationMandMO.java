package com.usc.bean;

import java.io.Serializable;
/**
 * 农机和农机主的关系表
 * @author zhao
 *
 */
public class RelationMandMO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;//主键
	private int machineId;//农机
	private int machineOwnerId;//农机主id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMachineId() {
		return machineId;
	}
	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
	public int getMachineOwnerId() {
		return machineOwnerId;
	}
	public void setMachineOwnerId(int machineOwnerId) {
		this.machineOwnerId = machineOwnerId;
	}
	@Override
	public String toString() {
		return "RelationMandMO [id=" + id + ", machineId=" + machineId
				+ ", machineOwnerId=" + machineOwnerId + "]";
	}
	
}
