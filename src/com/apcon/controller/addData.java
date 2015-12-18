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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 * Servlet implementation class addData
 */
@WebServlet("/addData")
public class addData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	DBConnectionManager db= new DBConnectionManager();
	PreparedStatement ps=null;
	ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int Id= Integer.parseInt(request.getParameter("Id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mbnum = request.getParameter("mbnum");
		String dob = request.getParameter("dob");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		try {
				Connection con=db.getConnection();
				String query = "Insert into person(name,email,mbnum,dob,currentdatetime) values(?,?,?,?,?)";
				ps=con.prepareStatement(query);
				ps.setString(1,name);
				ps.setString(2,email);
				ps.setString(3, mbnum);
				ps.setString(4,dob);
				ps.setString(5, dateFormat.format(date));
				ps.executeUpdate();
				con.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//GsonBuilder gsonBuilder= new GsonBuilder();
		//Gson gson=gsonBuilder.create();				
		String data="[{\"message\":\"your data inserted successfully\"}]";
		//String d="[{'message':'your data inserted successfully'}]";
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(data);
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
