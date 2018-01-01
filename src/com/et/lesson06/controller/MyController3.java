package com.et.lesson06.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.et.lesson06.dao.MyFoodDaoImpl;



@Controller
public class MyController3 {
	@Autowired 
	MyFoodDaoImpl myFoodDaoImpl;
	@RequestMapping(value="/showFood3")
	public String query(String foodname,OutputStream os) throws Exception{
		if(foodname==null){
			foodname="";
		}
		System.out.println(foodname);
		//将数据存到List集合中
		List<Map<String, Object>> list =myFoodDaoImpl.queryFood(foodname);
		//将数据存到json中
		JSONArray array =  JSONArray.fromObject(list);
		//由于javascript 只接受字符串 所以将json数据转换成字符串，然后输出到页面；
		String jsonString = array.toString();
		
		os.write(jsonString.getBytes("UTF-8"));
		return null;
	}

}
