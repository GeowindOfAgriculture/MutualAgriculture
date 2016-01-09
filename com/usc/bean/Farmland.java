package com.usc.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * 农田表
 * 
 * @author zhao
 * 
 */
public class Farmland implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;// 主键
	private int farmlandPicId;// 农田图片id
	private String location;// 位置
	private int size;// 尺寸
	private int maturity;// 成熟度
	private double perPrice;// 单价
	private String type;// 种类
	private String description;// 描述
	private Date harvestTime;// 预计收割时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFarmlandPicId() {
		return farmlandPicId;
	}

	public void setFarmlandPicId(int farmlandPicId) {
		this.farmlandPicId = farmlandPicId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMaturity() {
		return maturity;
	}

	public void setMaturity(int maturity) {
		this.maturity = maturity;
	}

	public double getPerPrice() {
		return perPrice;
	}

	public void setPerPrice(double perPrice) {
		this.perPrice = perPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getHarvestTime() {
		return harvestTime;
	}

	public void setHarvestTime(Date harvestTime) {
		this.harvestTime = harvestTime;
	}

	@Override
	public String toString() {
		return "Farmland [id=" + id + ", farmlandPicId=" + farmlandPicId
				+ ", location=" + location + ", size=" + size + ", maturity="
				+ maturity + ", perPrice=" + perPrice + ", type=" + type
				+ ", description=" + description + ", harvestTime="
				+ harvestTime + "]";
	}

}
