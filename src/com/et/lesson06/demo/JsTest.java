package com.et.lesson06.demo;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
/**
 * json �ַ����ļ�һ��Ҫ��˫���ţ�
 * ֵ��������֣�����Ҫ˫���š�
 * @author THINK
 *
 */
public class JsTest {
	/**
	 * {
	 * id:1,
	 * name:zs
	 * }
	 */
	public static void parseObject(){
		Map map = new HashMap();
		map.put("id", 1);
		map.put("name", "zs");
		JSONObject jo =JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	
	public static void main(String[] args) {
		parseObject();
	}
}
