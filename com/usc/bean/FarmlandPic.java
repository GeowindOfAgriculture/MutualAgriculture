package com.usc.bean;

import java.io.Serializable;

/**
 * 农田图片表实体
 * 
 * @author lilin
 * @time 2016年1月8日 下午10:30:48
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public class FarmlandPic implements Serializable {
	private int id;
	private String url;// 农机图片路径
	private String remarks1;
	private String remarks2;
	private String remarks3;

	public FarmlandPic() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取 农机图片路径
	 * 
	 * @return 农机图片路径
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置农机图片路径
	 * 
	 * @param url
	 *            农机图片路径
	 */
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

	@Override
	public String toString() {
		return "FarmlandPic [id=" + id + ", url=" + url + ", remarks1=" + remarks1 + ", remarks2=" + remarks2
				+ ", remarks3=" + remarks3 + "]";
	}

}
