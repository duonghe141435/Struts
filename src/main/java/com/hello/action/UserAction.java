package com.hello.action;

import java.util.ArrayList;
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
		userService.saveUser(user);
		return mapping.findForward("addUser");
	}

	public ActionForward addUserPost(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = (User)form;
		UserService userService = new UserService();
		userService.saveUser(user);
		return mapping.findForward("success");
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
		String name = request.getParameter("name");
		UserService userService = new UserService();
		User user = userService.getUserByName(name);
		request.setAttribute("user", user);
		return mapping.findForward("viewUser");
	}
	
	public ActionForward listUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService userService = new UserService();
		List<User> users = userService.getListUser();
		request.setAttribute("userList", users);
		return mapping.findForward("listUser");
	}
}
