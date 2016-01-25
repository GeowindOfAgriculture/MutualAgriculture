package com.usc.dao;

import com.usc.bean.Agent;

/**
 * 纪经人数据库访问层接口
 * 
 * @author zhao
 * 
 */
public interface AgentDAO {
	/**
	 * 登陆
	 * 
	 * @param tel
	 * @param password
	 * @return
	 */
	public boolean login(String tel, String password);

	/**
	 * 注册
	 * 
	 * @param agent
	 *            经纪人
	 * @return
	 */
	public boolean regist(Agent agent);

	/**
	 * 获取经纪人信息
	 * 
	 * @param tel
	 *            经纪人tel
	 * @return
	 */
	public Agent getAgentInfoByTel(String tel);

	/**
	 * 查看经纪人用户名是否被注册
	 * @param tel
	 * @return
	 */
	public boolean isAgentUsernameRegisted(String tel);

	/**
	 * 查看经纪人手机号是否被注册过，手机号具有唯一性
	 * 
	 * @param tel
	 * @return
	 */
	public boolean isAgentTelRegisted(String tel);

	/**
	 * 更新经纪人信息
	 * 
	 * @return
	 */
	public boolean updateAgentInfo(Agent agent);

}
