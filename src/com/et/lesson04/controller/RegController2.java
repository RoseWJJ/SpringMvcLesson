package com.et.lesson04.controller;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.et.lesson04.entity.UserInfor;




/**
 * 后台验证步骤 1 javabean添加验证注解 2 action中@Valid 表示javabean
 * 使用Errors或者BindingResult判断是否验证失败 3 出现 jar包冲突，
 * 
 * @author THINK
 * 
 */

@Controller
public class RegController2 {

	@Autowired
	MessageSource ms;
	@RequestMapping(value = "/mid", method = RequestMethod.GET)
	
	public String mid() {
		
		return "lesson04/demo.jsp";
	}
		
	
	@RequestMapping(value = "/demo3", method = RequestMethod.POST)
	//ModelAttribute("对象名 "); 重命名 参数对象；
	// BindingResult 或者Error
	public String queryFood(@Valid UserInfor user, BindingResult error,Locale local) {
		if (user.getPassword().equals(user.getRePassword())) {
			error.addError(new FieldError("userInfor", "password", ms.getMessage("rpasswordError", null, local)));
		}
		
		try {
			if (user.getAge() != null || user.getAge() != "") {
				Pattern p = Pattern.compile("^[0-9]*$");
				Matcher m = p.matcher(user.getAge());
				if (!m.matches()) {
					error.addError(new FieldError("userInfor", "age",  ms.getMessage("ageError", null, local)));
				} else {
					Integer age = Integer.parseInt(user.getAge());
					if (age > 130 || age < 1) {
						error.addError(new FieldError("userInfor", "age",  ms.getMessage("InvalidAge", null, local)));
					}
				}
			}
		} catch (Exception e) {
			error.addError(new FieldError("userInfor", "age",  ms.getMessage("ageN", null, local)));
		}
		if (user.getUrl() != null || user.getUrl() != "") {
			Pattern p = Pattern.compile("^([A-Za-z0-9])+([-_.][A-Za-z0-9])*@([A-Za-z0-9]+[.-])+[A-Za-z]{2,5}$");
			Matcher m = p.matcher(user.getUrl());
			if (!m.matches()) {
				error.addError(new FieldError("userInfor", "url",  ms.getMessage("InvalidURL", null, local)));
			} 
		}
		if(user.getRegTime()!=null || user.getRegTime()!=""){
			String reg = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(user.getRegTime());
			if(!m.matches()){
				error.addError(new FieldError("userInfor", "regTime", ms.getMessage("InvalidTime", null, local)));
			}
		}
		if (error.hasErrors()) {
			return "/lesson04/demo.jsp";
		}
		return "/lesson04/suc.jsp";
	}
}
