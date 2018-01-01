package com.et.lesson02.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.lesson02.dao.FoodDao;

import com.et.lesson02.service.FoodService;
import com.et.lesson02.util.PageTool;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDao foodDao;

	
	public void addFood(String foodname,String price,String imgpath) {
		foodDao.addFood(foodname, price, imgpath);
	}

	
	public void deleteFood(String foodid) {
		foodDao.deleteUser(foodid);
	}

	
	public void updateFood(String foodid,String foodname,String price,String imgpath) {
		foodDao.updateUser(foodid, foodname, price, imgpath);
	}

	
	public PageTool queryFood(String foodname,int curPage) {
		if(foodname==null){
			foodname="";
		}
		int count= foodDao.getFoodCountByName(foodname);
		PageTool pageTool  = new PageTool(curPage,count,2);
		List<Map<String, Object>> list = foodDao.queryFood(foodname, pageTool.getStartIndex()-1, pageTool.getPageCount());
		pageTool.setData(list);
		return pageTool;
	}

	
	public Map<String, Object> queryFoodByFoodId(String id) {
		Map<String, Object> list =  foodDao.getFoodById(id);
		return list;
	}

}
