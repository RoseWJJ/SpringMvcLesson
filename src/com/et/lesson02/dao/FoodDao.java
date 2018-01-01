package com.et.lesson02.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {
	//ͳ�Ƹ���
	public abstract Integer  getFoodCountByName(String name);
	//��ѯ����
	public abstract List<Map<String, Object>>queryFood(String name,int startIndex,int length);
	//����id��ѯ
	public abstract Map<String, Object>getFoodById(String id);
	//���
	public abstract void addFood( String name,String price,String imgpath );
	//ɾ��
	public abstract void deleteUser(String id);
	//�޸�
	public abstract void updateUser(String id,String foodname,String price,String imgpath);
}
