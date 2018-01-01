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
		//�����ݴ浽List������
		List<Map<String, Object>> list =myFoodDaoImpl.queryFood(foodname);
		//�����ݴ浽json��
		JSONArray array =  JSONArray.fromObject(list);
		//����javascript ֻ�����ַ��� ���Խ�json����ת�����ַ�����Ȼ�������ҳ�棻
		String jsonString = array.toString();
		
		os.write(jsonString.getBytes("UTF-8"));
		return null;
	}

}
