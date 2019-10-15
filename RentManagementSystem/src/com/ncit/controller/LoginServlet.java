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

public class LoginServlet extends HttpServlet {
	
	ServletContext context;
	RequestDispatcher disp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserService usrService = new UserServiceImpl();
		boolean isValid = usrService.isUserValid(user);
		
		if(isValid){
			disp = context.getRequestDispatcher("/home.jsp");
		} 
		else {
			disp = context.getRequestDispatcher("/index.jsp");
		}
		
		disp.forward(req, resp);
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
	}

}
