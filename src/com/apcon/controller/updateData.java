package com.apcon.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apcon.db.DBConnectionManager;

/**
 * Servlet implementation class updateData
 */
@WebServlet("/updateData")
public class updateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBConnectionManager db= new DBConnectionManager();
	PreparedStatement ps=null;
	ResultSet rs=null;
	
    public updateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int Id=Integer.parseInt(request.getParameter("Id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mbnum = request.getParameter("mbnum");
		String dob = request.getParameter("dob");		
		try {
				Connection con=db.getConnection();
				String query = "UPDATE person SET name='"+name+"',email='"+email+"',mbnum='"+mbnum+"',dob='"+dob+"' where Id="+Id;
				ps=con.prepareStatement(query);				
				ps.executeUpdate();
				con.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//GsonBuilder gsonBuilder= new GsonBuilder();
		//Gson gson=gsonBuilder.create();				
		String data="[{\"message\":\"data updated successfully\"}]";
		//String d="[{'message':'your data inserted successfully'}]";
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
