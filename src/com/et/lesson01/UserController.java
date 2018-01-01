package com.et.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.et.lesson01.dao.imp.UserDao;
import com.et.lesson01.entity.User;
@Controller
public class UserController {
	@Autowired
	private UserDao  userDao;

	//����
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(User user,HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		userDao.addUser(Integer.parseInt(user.getId()),user.getName(),user.getSex());
		out.println(user.getName()+"addAccuess");
		request.setAttribute("username", user.getName());
		return "/lesson01/user.jsp";
	}
	//�޸�
	@RequestMapping(value="/user/{userId}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable(value="userId")User user,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int sum = userDao.updateUser(Integer.parseInt(user.getId()),user.getName(),user.getSex());
		
		return null;
	}
	//ɾ��
	@RequestMapping(value="/user/{userId}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable(value="userId") String id,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int sum = userDao.deleteUser(Integer.parseInt(id));
		
		return null;
		
	}
	//�鿴
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String queryUser(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<User>list=userDao.queryUser();
		out.printf("<table border=1>");
		out.print("<tr><th>�û�id</th><th>�û���</th><th>�û��Ա�</th></tr>");
		for (User user : list) {
			out.printf("<tr>");
			out.print("<td>");
			out.print(user.getId());
			out.print("</td>");
			out.print("<td>");
			out.print(user.getName());
			out.print("</td>");
			out.print("<td>");
			out.print(user.getSex());
			out.print("</td>");
			out.printf("</tr>");
		}
		out.printf("</table>");
		System.out.println(list);
		return null;
	}
	
	
}
