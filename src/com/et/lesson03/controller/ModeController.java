package com.et.lesson03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc 中Model 相关对象 是处理和数据相关的对象；
 * @ModelAttribute 重命名 参数数据
 * Model （ModelMap | Map）传递数据导视图（request.setAttribute）
 * ModelAndView  绑定数据到视图，（ModelMap 用于传递数据  View对象用于跳转）
 * @author THINK
 *
 */

@Controller
public class ModeController {
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map) {
		map.put("name", "zs");
		return "/lesson03/res.jsp";
	}
	
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2() {
		ModelAndView mView = new ModelAndView("/lesson03/res.jsp");
		mView.addObject("sex", "boy");
		return mView;
	}
}
