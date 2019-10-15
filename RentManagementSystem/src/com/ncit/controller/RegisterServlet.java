package com.ncit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncit.model.UserServiceImpl;
import com.ncit.userservice.User;
import com.ncit.userservice.UserService;

public class RegisterServlet extends HttpServlet {
	
	ServletContext context;
	RequestDispatcher disp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String fullname = req.getParameter("fullname");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String phone = req.getParameter("mobile");
		
		User user = new User();
		user.setFullname(fullname);
		user.setAddress(address);
		user.setEmail(email);
		user.setMobile(phone);
		
		UserService usrService = new UserServiceImpl();
		boolean isValid = usrService.registerUser(user);
	
		if(isValid){
			disp = context.getRequestDispatcher("/home1.jsp");
		} 
		else {
			disp = context.getRequestDispatcher("/register.jsp");
		}
		
		disp.forward(req, resp);
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
	}

}
