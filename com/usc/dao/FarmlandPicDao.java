package com.usc.dao;
/**
 * 
 * @author   zhao
 * @CreateTime  2016-1-10
 * @Description  农田图片数据接口
 */
public interface FarmlandPicDao {
	/**
	 * 通过存储url，存储农田图片
	 * @param url 图片url
	 * @return 刚插入记录id 若返回-1，则表示插入失败 
	 */
	public int storeFarmlandPicToURL(String url);
	/**
	 * 
	 * @param farmlandId
	 * @return url
	 */
	public String getFarmlandPicURLByFarmlandId(int farmlandId);
}
