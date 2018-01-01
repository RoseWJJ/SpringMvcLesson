package com.et.lesson04.controller;

import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NationController {
	@Autowired
	MessageSource ms;

	@RequestMapping(value = "/nation")
	public String nationTest(OutputStream out, Locale local,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		out.write(ms.getMessage("key", null, local).getBytes("UTF-8"));
		return null;
	}
}
