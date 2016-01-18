package com.usc.dao;

import java.util.List;

import com.usc.bean.FarmlandPic;

/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-10
 * @Description  农田图片数据接口
 */
public interface FarmlandPicDao {
	/**
	 * 存储农田图片信息
	 * @param pic 农田图片实体类
	 * @return
	 */
	public boolean storeFarmlandPicToURL(FarmlandPic pic);
	/**
	 * 获取农田所有图片的url
	 * @param farmlandId
	 * @return url的集合
	 */
	public List<String> getFarmlandPicURLByFarmlandId(int farmlandId);
}
