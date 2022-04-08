package com.hello.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class User extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String sex;
	private String email;
	private int phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public User() {
	}

	public User(String name, int age, String sex, String email, int phoneNumber) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();
		if(getName() == null || getName().length()==0) {
			actionErrors.add("user.name.required", new ActionMessage("error.user.name.required"));
		}
		if(getAge()<=0) {
			actionErrors.add("user.age.invalid", new ActionMessage("error.user.age.invalid"));
		}
			
		return actionErrors;
	}
	
}
