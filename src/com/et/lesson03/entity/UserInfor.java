package com.et.lesson03.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



public class UserInfor {
	/**
	 * NotNull ��������=null
	 * NotEmpty ��������=null && !������.equals("");
	 * 
	 */
	@NotEmpty(message="�û�������Ϊ��")
	private String userName;
//	@NotEmpty(message="���벻��Ϊ��")
	private String password;
//	@NotEmpty(message="�ظ����벻��Ϊ��")
	private String rePassword;
	@Pattern(message="�����ʽ����",regexp=".+@.+\\..+")
	private String email;
	//@Pattern(message="��Ч��ַ",regexp="^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$")
	private String url;
	@Size(max=11,min=11,message="�ֻ����������11λ")
	private String phone;
	
	private String age;
	private String regTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
	
	
}
