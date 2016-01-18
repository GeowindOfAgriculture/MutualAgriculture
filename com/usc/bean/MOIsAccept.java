package com.usc.bean;

import java.io.Serializable;

/**
 * 农机主是否接收被推送的订单
 * 
 * @author lilin
 * @time 2016年1月16日 下午10:46:50
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class MOIsAccept implements Serializable {
	private boolean isAccept;
	private Order order;
	private MachineOwner machineOwner;

	public MOIsAccept() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAccept() {
		return isAccept;
	}

	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MachineOwner getMachineOwner() {
		return machineOwner;
	}

	public void setMachineOwner(MachineOwner machineOwner) {
		this.machineOwner = machineOwner;
	}

	@Override
	public String toString() {
		return "MOIsAccept [isAccept=" + isAccept + ", order=" + order + ", machineOwner=" + machineOwner + "]";
	}

}
