package com.usc.util;

/**
 * 数据库的表字段常量
 * 
 * @author lilin
 * @time 2016年1月9日 下午3:30:46
 * @email gaosi0812@gmail.com
 * @blog gaosililin.iteye.com
 * @school USC
 */
public final class Constant {
	// FarmlandPic FARMLANDPIC
	/** 农机图片表 ID */
	public static final String ID_FARMLANDPIC = "id";
	/** 农机图片表 农机图片路径 */
	public static final String URL_FARMLANDPIC = "url";// 农机图片路径
	/** 农机图片表 预留字段1 */
	public static final String REMARKS1_FARMLANDPIC = "remarks1";
	/** 农机图片表 预留字段2 */
	public static final String REMARKS2_FARMLANDPIC = "remarks2";
	/** 农机图片表 预留字段3 */
	public static final String REMARKS3_FARMLANDPIC = "remarks3";

	// Machine MACHINE
	/** 农机表 ID */
	public static final String ID_MACHINE = " id";
	/** 农机表 农机图片ID */
	public static final String MACHINEPICID_MACHINE = "machinePicId";// 农机图片id
	/** 农机表 农机型号 */
	public static final String MODEL_MACHINE = "model";// 型号
	/** 农机表 农机使用年限 */
	public static final String USERAGE_MACHINE = "userAge";// 使用年限
	/** 农机表 农机描述 */
	public static final String DES_MACHINE = "des";// 描述
	/** 农机表 预留字段1 */
	public static final String REMARKS1_MACHINE = "remarks1";
	/** 农机表 预留字段2 */
	public static final String REMARKS2_MACHINE = "remarks2";
	/** 农机表 预留字段3 */
	public static final String REMARKS3_MACHINE = "remarks3";

	// MachineOwner MACHINEOWNER
	/** 农机主表 ID */
	public static final String ID_MACHINEOWNER = "id";
	/** 农机主表姓名 */
	public static final String NAME_MACHINEOWNER = "name";// 姓名
	/** 农机主表 密码 */
	public static final String PASSWORD_MACHINEOWNER = "password";// 密码
	/** 农机主表 位置 */
	public static final String LOCATION_MACHINEOWNER = "location";// 位置
	/** 农机主表 电话 */
	public static final String TEL_MACHINEOWNER = "tel";// 电话
	/** 农机主表 预留字段1 */
	public static final String REMARKS1_MACHINEOWNER = "remarks1";
	/** 农机主表 预留字段2 */
	public static final String REMARKS2_MACHINEOWNER = "remarks2";
	/** 农机主表预留字段3 */
	public static final String REMARKS3_MACHINEOWNER = "remarks3";
	// MachinePic MACHINEPIC
	/** 农田图片表 ID */
	public static final String ID_MACHINEPIC = "id";// 主键
	/** 农田图片表 农机图片路径 */
	public static final String URL_MACHINEPIC = "url";// 农机图片路径
	/** 农田图片表 预留字段1 */
	public static final String REMARKS1_MACHINEPIC = "remarks1";
	/** 农田图片表 预留字段2 */
	public static final String REMARKS2_MACHINEPIC = "remarks2";
	/** 农田图片表 预留字段3 */
	public static final String REMARKS3_MACHINEPIC = "remarks3";
	// RelationMandMO RELATIONMANDMO
	/** 农机与农机主关系表 ID */
	public static final String ID_RELATIONMANDMO = "id";
	/** 农机与农机主关系表 农机ID */
	public static final String MACHINEID_RELATIONMANDMO = "machineId";// 农机id
	/** 农机与农机主关系表 农机主ID */
	public static final String MACHINEOWNERID_RELATIONMANDMO = "machineOwnerId";// 农机主id
	/** 农机与农机主关系表 预留字段1 */
	public static final String REMARKS1_RELATIONMANDMO = "remarks1";
	/** 农机与农机主关系表 预留字段2 */
	public static final String REMARKS2_RELATIONMANDMO = "remarks2";
	/** 农机与农机主关系表 预留字段3 */
	public static final String REMARKS3_RELATIONMANDMO = "remarks3";

}
