package com.usc.bean;

import java.io.Serializable;

/**
 * 农机与农机主关系表实体
 * 
 * @author lilin
 * @time 2016年1月8日 下午10:28:06
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class RelationMandMO implements Serializable {
	private int id;
	private int machineId;// 农机id
	private int machineOwnerId;// 农机主id
	private String remarks1;
	private String remarks2;
	private String remarks3;

	public RelationMandMO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取农机id
	 * 
	 * @return 农机id
	 */
	public int getMachineId() {
		return machineId;
	}

	/**
	 * 设置农机id
	 * 
	 * @param machineId
	 *            农机id
	 */
	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	/**
	 * 获取农机主id
	 * 
	 * @return 农机主id
	 */
	public int getMachineOwnerId() {
		return machineOwnerId;
	}

	/**
	 * 设置农机主id
	 * 
	 * @param machineOwnerId
	 *            农机主id
	 */
	public void setMachineOwnerId(int machineOwnerId) {
		this.machineOwnerId = machineOwnerId;
	}

	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}

	public String getRemarks2() {
		return remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}

	public String getRemarks3() {
		return remarks3;
	}

	public void setRemarks3(String remarks3) {
		this.remarks3 = remarks3;
	}

	@Override
	public String toString() {
		return "RelationMandMO [id=" + id + ", machineId=" + machineId + ", machineOwnerId=" + machineOwnerId
				+ ", remarks1=" + remarks1 + ", remarks2=" + remarks2 + ", remarks3=" + remarks3 + "]";
	}

}
