package com.et.lesson05.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyDaoImpl {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	public  void  changeMoeny(Integer money) {
		String sql="update mymoney set lostedmoney = lostedmoney - "+money+" where id = 1";
		jdbcTemplate.execute(sql);
	}
	public  int  queryMoeny() {
		String sql="select lostedmoney from mymoney where id = 1";
		Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
		return num;
	}
}
