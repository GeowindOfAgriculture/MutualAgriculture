package com.usc.bean;

import java.io.Serializable;

/**
 * 农机主表实体
 * 
 * @author lilin
 * @time 2016年1月8日 下午10:24:55
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
@SuppressWarnings("serial")
public class MachineOwner implements Serializable {
	private int id;
	private String name;// 姓名
	private String password;// 密码
	private String location;// 位置
	private String tel;// 电话
	private String remarks1;
	private String remarks2;
	private String remarks3;

	public MachineOwner() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取农机主姓名
	 * 
	 * @return 农机主姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置农机主姓名
	 * 
	 * @param name
	 *            农机主姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取农机主的密码
	 * 
	 * @return 农机主的密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置农机主的密码
	 * 
	 * @param password
	 *            农机主的密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取农机主的地址
	 * 
	 * @return 农机主的地址
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 设置农机主的地址
	 * 
	 * @param location
	 *            农机主的地址
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 获取农机主的电话号码
	 * 
	 * @return 农机主的电话号码
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置农机主的电话号码
	 * 
	 * @param tel
	 *            农机主的电话号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
		return "MachineOwner [id=" + id + ", name=" + name + ", password=" + password + ", location=" + location
				+ ", tel=" + tel + ", remarks1=" + remarks1 + ", remarks2=" + remarks2 + ", remarks3=" + remarks3 + "]";
	}

}
