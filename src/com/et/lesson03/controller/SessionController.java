package com.et.lesson03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.et.lesson03.entity.UserInfor;
/**
 * 请求转发：forward
 * 重定向：redirect 使用@SessionAttributes("xx")方式 用于在重定向中传值将值存储在session中 【用完要清除】
 * @author THINK
 *如果希望在多个请求之间公用某个模型属性数据 则可以在控制器类标注一个@SessionAttributes
 */
@SessionAttributes("user")
@Controller
public class SessionController {
	@ModelAttribute("user")
	public UserInfor getUser(){
		UserInfor user = new UserInfor();
		return user;
	}
	@RequestMapping(value="/session",method=RequestMethod.GET)
	public String  demo(Map map) {
		map.put("age", "100");
		return "forward:/session2";
	}
	@RequestMapping(value="/session2",method=RequestMethod.GET)
	public String demo2() {
		
	
		return "/lesson03/res.jsp";
	}
	
	
	//http://localhost:8080/springmvc/session3?userName="xx" 在res.jsp在中可以提取到userName的值
	@RequestMapping(value="/session3",method=RequestMethod.GET)
	public String demo3(@ModelAttribute("user")UserInfor user) {
		return "redirect:/session4";
	
	}
	@RequestMapping(value="/session4",method=RequestMethod.GET)
	public String demo4(Map map,SessionStatus sessionStatus) {
//		UserInfor user1 =(UserInfor)map.get("user");
		sessionStatus.setComplete();
		return "/lesson03/res.jsp";
	
	}
}
