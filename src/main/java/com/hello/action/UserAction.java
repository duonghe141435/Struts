package com.hello.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.hello.model.User;
import com.hello.service.UserService;

public class UserAction extends MappingDispatchAction {

	public ActionForward addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = (User)form;
		UserService userService = new UserService();
		User userList = new User("a",22,"zz","bbb",24);
		int result = userService.saveUser(userList);
		if(result<=0){
			request.setAttribute("message", "Something wrong! Cannot add product");
		}else{
			request.setAttribute("message", "Add new product successfully!");
		}
		return mapping.findForward("addUser");
	}

	public ActionForward deleteUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = (User) form;
		return mapping.findForward("deleteUser");
	}
	

	
	public ActionForward updateUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = (User) form;
		return mapping.findForward("updateUser");
	}
	
	public ActionForward viewUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		User user = (User) form;
//		user.setName(name);
//		user.setAge(Integer.valueOf(age));
		String name = request.getParameter("userName");
		UserService userService = new UserService();
		User user = userService.getUserByName("B");
//		User viewUser = (User) form;
//		viewUser.setName(name);
		request.setAttribute("user", user);
		return mapping.findForward("viewUser");
	}
	
	public ActionForward listUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("listUser");
	}
}
