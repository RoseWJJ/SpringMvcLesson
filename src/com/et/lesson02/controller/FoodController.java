package com.et.lesson02.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.et.lesson02.service.FoodService;
import com.et.lesson02.util.PageTool;

@Controller
public class FoodController {
	@Autowired
	FoodService foodService;

	// ��ѯ
	@RequestMapping(value = "/showFood", method = RequestMethod.GET)
	public String queryFood(String foodname,Integer curPage, Model model) {
		
		if(curPage==null){
			curPage=1;
		}
		PageTool list = foodService.queryFood(foodname, curPage);
		model.addAttribute("list", list);

		return "/detail/foodList.jsp";
	}

	@RequestMapping(value = "/food/{foodid}", method = RequestMethod.GET)
	public String queryFoodById(@PathVariable String foodid, Model model) {
		model.addAttribute("list", foodService.queryFoodByFoodId(foodid));
		return "/detail/detailFood.ftl";
	}

	@RequestMapping(value = "/food/{foodId}", method = RequestMethod.POST)
	public String updateFoodById(@PathVariable String foodId, String foodName,
			String price, Model model, MultipartFile imageUrl)
			throws Exception, Exception {
		String absPath = "E:\\����ʦ\\etop1610\\5.JSP&SRV\\��ѧ���\\apache-tomcat-7.0.78\\webapps\\springmvc\\myImage";
		String name = imageUrl.getOriginalFilename();
		imageUrl.transferTo(new File(absPath + "\\" + name));
		foodService.updateFood(foodId, foodName, price, name);
		return queryFood(null, null, model);
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(String imagePath) throws Exception,
			Exception {
		String absPath = "E:\\����ʦ\\etop1610\\5.JSP&SRV\\��ѧ���\\apache-tomcat-7.0.78\\webapps\\springmvc\\myImage\\"
				+ imagePath;
		String fileName = imagePath;
		// ��Ҫ���ص�Ŀ���ļ�
		File file = new File(absPath);
		// ������Ӧͷ
		HttpHeaders hh = new HttpHeaders();
		// �������ص��ļ�����
		hh.setContentDispositionFormData("attachment", URLEncoder.encode(
				fileName, "UTF-8"));
		// ��ȡĿ���ļ�Ϊ���������飻
		byte[] fileByte = FileCopyUtils.copyToByteArray(file);
		// ����ResponseEntity ����
		ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte, hh,
				HttpStatus.CREATED);
		return re;
	}

	@RequestMapping(value = "/addFood", method = RequestMethod.POST)
	public String addFood(String foodname, String price, Model model,
			MultipartFile imageUrl) throws Exception, Exception {
		String absPath = "E:\\����ʦ\\etop1610\\5.JSP&SRV\\��ѧ���\\apache-tomcat-7.0.78\\webapps\\springmvc\\myImage";

		String name = imageUrl.getOriginalFilename();
		System.out.println(foodname + name + price);
		imageUrl.transferTo(new File(absPath + "\\" + name));
		foodService.addFood(foodname, price, name);
		return queryFood(null,null, model);
	}

	@RequestMapping(value = "/delete/{foodid}", method = RequestMethod.GET)
	public String delete(@PathVariable String foodid, Model model) {
		 foodService.deleteFood(foodid);
		 return queryFood(null,null,model);
	}

}
