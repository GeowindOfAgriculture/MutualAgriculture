package com.usc.bean;

import java.io.Serializable;
/**
 * ũ����ũ�����Ĺ�ϵ��
 * @author zhao
 *
 */
public class RelationMandMO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;//����
	private int machineId;//ũ��
	private int machineOwnerId;//ũ����id
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
