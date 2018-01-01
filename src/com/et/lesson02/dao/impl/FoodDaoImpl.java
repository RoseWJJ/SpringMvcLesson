package com.et.lesson02.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.et.lesson02.dao.FoodDao;



@Repository
public class FoodDaoImpl implements FoodDao {
	@Autowired
	JdbcTemplate jdbc;
	//��ȡ����
	public Integer  getFoodCountByName(String name) {
		String sql="select count(*) as cr from food where foodname like '%"+name+"%'";
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		return Integer.parseInt(list.get(0).get("cr").toString());
	}
	
	//��ѯ����
	public List<Map<String, Object>> queryFood(String name,int startIndex,int length) {
		String sql = "select * from food  where foodname like '%"+name+"%' limit "+startIndex+","+length;
		System.out.println(sql);
		List<Map<String, Object>>  list = jdbc.queryForList(sql);
		return list;
	}
	//����id��ѯ
	public Map<String, Object> getFoodById(String id){
		String sql = "select * from food  where foodid = "+id;
		System.out.println(sql);
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		return list.get(0);
	}
	//���
	public void addFood( String name,String price,String imgpath ) {

		String sql = "insert into food values((select max(foodid)+1 from food f ),'" +name+"',"+price+",'"+imgpath+"')";
				
		System.out.println(sql);
		jdbc.execute(sql);
	}

	//ɾ��
	public void deleteUser(String id) {
		String sql = "delete from Food where  foodid=" + id;
		System.out.println(sql);
		jdbc.execute(sql);
	}

	//�޸�
	public void updateUser(String id,String foodname,String price,String imgpath) {
		String sql = "update food set foodname='" + foodname + "',price="+ price+",imgpath ='"+imgpath+"' where foodid ="+id ;
		System.out.println(sql);
		jdbc.update(sql);
		
	}
}
