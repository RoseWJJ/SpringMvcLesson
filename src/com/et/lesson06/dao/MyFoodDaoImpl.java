package com.et.lesson06.dao;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyFoodDaoImpl {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	public  List<Map<String,Object>>  queryFood(String foodnaem) {
		String sql="SELECT foodname,price FROM food WHERE foodname LIKE '%"+foodnaem+"%'";
		return jdbcTemplate.queryForList(sql);
		
	}
}
