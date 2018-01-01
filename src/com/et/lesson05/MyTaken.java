package com.et.lesson05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyTaken implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String myToken = request.getParameter("myToken");
		Object sTaken = request.getSession().getAttribute("myToken");
		//需要验证重复提交
		if (myToken != null) {
			//重复提交
			if (sTaken== null) {
				return false;
			} else {
				if (myToken.equals(sTaken)) {
					request.getSession().removeAttribute("myToken");
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}

	}

}
