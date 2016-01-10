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
	
	//订单状态常量
	/** 订单还未被管理员委派给农机主，属于初始状态---审核中 */
	public static final String ORDER_STATE_UNDELEGATE = "审核中";
	/** 订单已被管理员委派，但未被农机主接受 */
	public static final String ORDER_STATE_DELEGATING = "委派中";
	/** 订单被接收但未完成 */
	public static final String ORDER_STATE_ACCEPTED_UNACCOM = "已被接受但未完成";
	/** 订单被接受且已经完成 */
	public static final String ORDER_STATE_ACCEPTED_ACCOM = "已被接受且完成";

	
	
	/** 管理员表 */
	public static final String TB_ADMINS = "admins";
	/** 经纪人表 */
	public static final String TB_AGENT = "agent";
	/** 农田表 */
	public static final String TB_FARMLAND = "farmland";
	/** 农田图片表 */
	public static final String TB_FARMLANDPIC = "farmlangpic";
	/** 日志表 */
	public static final String TB_LOGS = "logs";
	/** 机器表 */
	public static final String TB_MACHINE = "machine";
	/** 农机主表 */
	public static final String TB_MACHINEOWNER = "machineowner";
	/** 农机图片表 */
	public static final String TB_MACHINEPIC = "machinepic";
	/** 订单表 */
	public static final String TB_ORDERS = "orders";
	/** 农机和农机主关系表 */
	public static final String TB_RELATIONMANDMO = "relationmandmo";

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

	// Admin
	/** 管理员id */
	public static final String ID_ADMIN = "id";
	/** 管理员用户名 */
	public static final String NAME_ADMIN = "name";
	/** 管理员密码 */
	public static final String PASSWORD_ADMIN = "password";
	/** 管理员电话 */
	public static final String TEL_ADMIN = "tel";

	// Agent
	/** 经纪人id */
	public static final String ID_AGENT = "id";
	/** 经纪人地址 */
	public static final String LOCATION_AGENT = "location";
	/** 经纪人用户名 */
	public static final String NAME_AGENT = "name";
	/** 经纪人密码 */
	public static final String PASSWORD_AGENT = "password";
	/** 经纪人电话 */
	public static final String TEL_AGENT = "tel";

	// Farmland
	/** 农田id */
	public static final String ID_FARMLAND = "id";
	/** 农田描述 */
	public static final String DESCRIPTION_FARMLAND = "description";
	/** 农田图片id */
	public static final String FARMLANDPICID_FARMLAND = "farmlandPicId";
	/** 农田预计收割时间 */
	public static final String HARVESTTIME_FARMLAND = "harvestTime";
	/** 农田地址 */
	public static final String LOCATION_FARMLAND = "location";
	/** 农田成熟度 */
	public static final String MATURITY_FARMLAND = "maturity";
	/** 农田单价 */
	public static final String PERPRICE_FARMLAND = "perPrice";
	/** 农田大小 */
	public static final String SIZE_FARMLAND = "size";
	/** 农田种类 */
	public static final String TYPE_FARMLAND = "type";

	// Log
	/** 日志id */
	public static final String ID_LOG = "id";
	/** 管理员id */
	public static final String ADMINID_LOG = "adminId";
	/** 农机主id */
	public static final String MACHINEOWNERID_LOG = "machineOwnerId";
	/** 操作时间 */
	public static final String OPTIME_LOG = "optime";
	/** 订单id */
	public static final String ORDERID_LOG = "orderId";
	/** 操作记录 */
	public static final String RECORD_LOG = "record";

	// Order
	/** 订单id */
	public static final String ID_ORDER = "id";
	/** 经纪人id */
	public static final String AGENTID_ORDER = "agentId";
	/** 佣金 */
	public static final String COMMISSION_ORDER = "commission";
	/** 截止日期 */
	public static final String ENDTIME_ORDER = "endTime";
	/** 农田id */
	public static final String FARMLANDID_ORDER = "farmlandId";
	/** 农机主id */
	public static final String MACHINEOWNERID_ORDER = "machineOwnerId";
	/** 数量 */
	public static final String NUM_ORDER = "num";
	/** 开始日期 */
	public static final String STARTTME_ORDER = "startTime";
	/** 状态 */
	public static final String STATE_ORDER = "state";

}
