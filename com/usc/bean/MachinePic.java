package com.usc.bean;

import java.io.Serializable;

/**
 * 农机图片
 * 
 * @author lilin
 * @time 2016年1月8日 下午10:19:54
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class MachinePic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;// 主键
	private String url;// 农机图片路径
	private int machineId;//农机id
	private String remarks1;
	private String remarks2;
	private String remarks3;

	public MachinePic() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	@Override
	public String toString() {
		return "MachinePic [id=" + id + ", url=" + url + ", machineId="
				+ machineId + ", remarks1=" + remarks1 + ", remarks2="
				+ remarks2 + ", remarks3=" + remarks3 + "]";
	}

	

}
