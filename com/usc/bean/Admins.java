package com.usc.bean;

import java.io.Serializable;
/**
 * ����Ա��
 * @author zhao
 *
 */
public class Admins implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;//����
	private String name;//����
	private String password;//����
	private String tel;//�绰
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Admins [id=" + id + ", name=" + name + ", password=" + password
				+ ", tel=" + tel + "]";
	}
	
}
