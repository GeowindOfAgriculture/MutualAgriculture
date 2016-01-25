package com.usc.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 农田实体类
 * 
 * @author zhao
 * 
 */
public class Farmland implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;// 主键
	private String location;// 农田地理位置
	private int size;// 农田大小
	private int maturity;// 成熟度
	private double perPrice;// 单价
	private String type;// 种类
	private String description;// 农田描述
	private Date harvestTime;// 预计收割时间
	
	private List<FarmlandPic> farmlandPics;//农田相关的农田图片
	
	

	public List<FarmlandPic> getFarmlandPics() {
		return farmlandPics;
	}

	public void setFarmlandPics(List<FarmlandPic> farmlandPics) {
		this.farmlandPics = farmlandPics;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Farmland [id=" + id + ", location=" + location + ", size="
				+ size + ", maturity=" + maturity + ", perPrice=" + perPrice
				+ ", type=" + type + ", description=" + description
				+ ", harvestTime=" + harvestTime + "]";
	}

	
}
