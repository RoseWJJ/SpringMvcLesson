package com.et.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.et.lesson01.entity.User;
/**
 * springmvc 中一个路径和方法的映射 叫做一个action（动作）
 * 
 * @author THINK 
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/test")
	public String index(HttpServletResponse response,HttpServletRequest request) throws IOException{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		response.getWriter().println("hellospringmvc---------"+id+"-------"+name);
		return null;
	}
	@RequestMapping("/test1")
	public String index(User user,HttpServletResponse response) throws IOException{
		
		response.getWriter().println("hellospringmvc---------"+user.getId()+"-------"+user.getName());
		return null;
	}
	@RequestMapping("/mvn")
	public String index(HttpServletRequest request) throws IOException{
		request.setAttribute("sex", "man");

		return "/index.jsp";
	}
}
