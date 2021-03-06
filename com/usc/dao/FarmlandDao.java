package com.usc.dao;

import com.usc.bean.Farmland;

/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-10
 * @Description  农田数据访问接口
 */
public interface FarmlandDao {
	/**
	 * 添加农田信息到农田表
	 * @param farmland
	 * @return 刚插入农田信息的id
	 */
	public int addFarmlandInfo(Farmland farmland);
	
}
