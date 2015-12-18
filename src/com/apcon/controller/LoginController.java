
package com.apcon.controller;
 
import java.io.IOException;
 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import com.apcon.model.Authenticator;
import com.apcon.model.User;

 
import sun.text.normalizer.ICUBinary.Authenticate;
 
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticate(username, password);
		String serverDateTime = "0000-00-00 00:00:00"; 
		if (result.equals("success")) {
			request.setAttribute("serverDateTime", serverDateTime);
			rd = request.getRequestDispatcher("/getviewData");					
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
	//	rd.include(request, response);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		
	}
 
}