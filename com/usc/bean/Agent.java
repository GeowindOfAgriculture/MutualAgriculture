package com.usc.bean;

import java.io.Serializable;

/**
 * 经纪人实体类
 * 
 * @author zhao
 * 
 */
public class Agent implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;// 主键
	private String name;// 姓名
	private String password;// 密码
	private String location;// 地址
	private String tel;// 电话

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", password=" + password
				+ ", location=" + location + ", tel=" + tel + "]";
	}

}
