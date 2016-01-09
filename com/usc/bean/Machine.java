package com.usc.bean;

import java.io.Serializable;

/**
 * 农机表实体
 * 
 * @author lilin
 * @time 2016年1月8日 下午10:23:41
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class Machine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int machinePicId;// 农机图片id
	private String model;// 型号
	private int userAge;// 使用年限
	private int des;// 描述
	private String remarks1;
	private String remarks2;
	private String remarks3;

	public Machine() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取 农机图片id
	 * 
	 * @return 农机图片id
	 */
	public int getMachinePicId() {
		return machinePicId;
	}

	/**
	 * 设置农机图片id
	 * 
	 * @param machinePicId
	 *            农机图片id
	 */
	public void setMachinePicId(int machinePicId) {
		this.machinePicId = machinePicId;
	}

	/**
	 * 获取型号
	 * 
	 * @return 型号
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 设置型号
	 * 
	 * @param model
	 *            型号
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * 获取使用年限
	 * 
	 * @return 使用年限
	 */
	public int getUserAge() {
		return userAge;
	}

	/**
	 * 设置使用年限
	 * 
	 * @param userAge
	 *            使用年限
	 */
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	/**
	 * 获取描述
	 * 
	 * @return 描述
	 */
	public int getDes() {
		return des;
	}

	/**
	 * 设置 描述
	 * 
	 * @param des
	 *            描述
	 */
	public void setDes(int des) {
		this.des = des;
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
		return "Machine [id=" + id + ", machinePicId=" + machinePicId + ", model=" + model + ", userAge=" + userAge
				+ ", des=" + des + ", remarks1=" + remarks1 + ", remarks2=" + remarks2 + ", remarks3=" + remarks3 + "]";
	}

}
