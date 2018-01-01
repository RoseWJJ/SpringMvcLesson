package com.et.lesson02.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {
	//统计个数
	public abstract Integer  getFoodCountByName(String name);
	//查询所有
	public abstract List<Map<String, Object>>queryFood(String name,int startIndex,int length);
	//根据id查询
	public abstract Map<String, Object>getFoodById(String id);
	//添加
	public abstract void addFood( String name,String price,String imgpath );
	//删除
	public abstract void deleteUser(String id);
	//修改
	public abstract void updateUser(String id,String foodname,String price,String imgpath);
}
