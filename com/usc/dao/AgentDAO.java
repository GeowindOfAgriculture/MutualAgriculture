package com.usc.dao;

import com.usc.bean.Agent;
import com.usc.bean.Order;

/**
 * �����˵����ݷ��ʲ�ӿ�
 * @author zhao
 *
 */
public interface AgentDAO {
	/**
	 * �����˵�½
	 * @param username �������û���
	 * @param password ����������
	 * @return
	 */
	public boolean login(String username,String password);
	/**
	 * ������ע��
	 * @param agent ������ʵ��
	 * @return
	 */
	public boolean regist(Agent agent);
	
	public boolean publishOrder();
	
	public Order seeOrdersFinished();
	
	public Order seeOrdersUnFininshed();
	
	public String seeOrderState();
	
	public boolean undoOrder();
}
