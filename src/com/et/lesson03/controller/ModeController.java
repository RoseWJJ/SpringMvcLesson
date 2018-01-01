package com.et.lesson03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc ��Model ��ض��� �Ǵ����������صĶ���
 * @ModelAttribute ������ ��������
 * Model ��ModelMap | Map���������ݵ���ͼ��request.setAttribute��
 * ModelAndView  �����ݵ���ͼ����ModelMap ���ڴ�������  View����������ת��
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
