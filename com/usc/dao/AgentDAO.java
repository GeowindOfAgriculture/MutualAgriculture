package com.usc.dao;

import com.usc.bean.Agent;

/**
 * 纪经人数据库访问层接口
 * 
 * @author zhao
 * 
 */
public interface AgentDao {
	/**
	 * 登陆
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);

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
	 * @param id
	 *            经纪人id
	 * @return
	 */
	public Agent getAgentInfoById(int id);

	/**
	 * 查看经纪人是否被注册，用户名具有唯一性
	 * 
	 * @return
	 */
	public boolean isAgentRegisted(String username);

	/**
	 * 更新经纪人信息
	 * 
	 * @return
	 */
	public boolean updateAgentInfo(Agent agent);

}
