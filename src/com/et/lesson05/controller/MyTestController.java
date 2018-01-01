package com.et.lesson05.controller;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.et.lesson05.dao.MoneyDaoImpl;
@Controller
public class MyTestController {

	@RequestMapping(value="/test2")
	public String test(OutputStream os) throws Exception{
		os.write("test".getBytes());
		return null;
	}

	@Autowired 
	MoneyDaoImpl mydao;
	@RequestMapping(value="/tranx")
	public String transformMoney(OutputStream os,Integer money) throws Exception{
		mydao.changeMoeny(money);
		os.write(("money:"+mydao.queryMoeny()).getBytes());
		return null;
	}

}
