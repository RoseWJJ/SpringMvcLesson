package com.et.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ��������ύ��ʽ�������@RequestMapping ָ������Դ��������һ�� �����׳� 405 �쳣
 * @author THINK
 *
 */
@Controller
public class RestController {
//	@Autowired
//	UserDao userDao;
//	
//	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
//	public String index(@PathVariable(value="userId") String userId,HttpServletRequest request) throws IOException {
//		request.setAttribute("userId", userId);
//		return "/lesson01/user.jsp";
//	}
//	//����
//	@RequestMapping(value="/user",method=RequestMethod.POST)
//	public String addUser(String name1,HttpServletResponse response) throws IOException {
//		response.getWriter().println("add success"+name1);
//		return null;
//	}
//	//�޸�
//	@RequestMapping(value="/user/{userId}",method=RequestMethod.PUT)
//	public String updateUser(@PathVariable(value="userId") String userId,HttpServletResponse response) throws IOException {
//		response.getWriter().println("updateUser success"+userId);;
//		return null;
//	}
//	//ɾ��
//	@RequestMapping(value="/user/{userId}",method=RequestMethod.DELETE)
//	public String deleteUser(@PathVariable(value="userId") String userId,HttpServletResponse response) throws IOException {
//		response.getWriter().println("deleteUser success"+userId);;
//		return null;
//	}
//	//�鿴
//	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
//	public String queryUser(@PathVariable(value="userId") String userId,HttpServletResponse response) throws IOException {
//		response.getWriter().println("queryUser success"+userId);;
//		return null;
//	}
//	
	
	
	
	
	
}
