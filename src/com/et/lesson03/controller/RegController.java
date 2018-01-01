package com.et.lesson03.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.et.lesson03.entity.UserInfor;

/**
 * ��̨��֤���� 1 javabean�����֤ע�� 2 action��@Valid ��ʾjavabean
 * ʹ��Errors����BindingResult�ж��Ƿ���֤ʧ�� 3 ���� jar����ͻ��
 * 
 * @author THINK
 * 
 */

@Controller
public class RegController {

	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	//ModelAttribute("������ "); ������ ��������
	// BindingResult ����Error
	public String queryFood(@Valid UserInfor user, BindingResult error) {
		if (user.getPassword().equals(user.getRePassword())) {
			error.addError(new FieldError("userInfor", "password", "�������벻һ��"));
		}
		
		if (user.getAge() != null || user.getAge() != "") {
			Pattern p = Pattern.compile("^[0-9]*$");
			Matcher m = p.matcher(user.getAge());
			if (!m.matches()) {
				error.addError(new FieldError("userInfor", "age", "ֻ��������"));
			} else {
				Integer age = Integer.parseInt(user.getAge());
				if (age > 130 || age < 1) {
					error.addError(new FieldError("userInfor", "age", "��Ч ����"));
				}
			}
		}
		if (user.getUrl() != null || user.getUrl() != "") {
			Pattern p = Pattern.compile("^([A-Za-z0-9])+([-_.][A-Za-z0-9])*@([A-Za-z0-9]+[.-])+[A-Za-z]{2,5}$");
			Matcher m = p.matcher(user.getUrl());
			if (!m.matches()) {
				error.addError(new FieldError("userInfor", "url", "��Ч��ַ"));
			} 
		}
		if(user.getRegTime()!=null || user.getRegTime()!=""){
			String reg = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(user.getRegTime());
			if(!m.matches()){
				error.addError(new FieldError("userInfor", "regTime", "��Чʱ��"));
			}
		}
		if (error.hasErrors()) {
			return "/lesson03/demo.jsp";
		}
		return "/lesson03/suc.jsp";
	}
}
