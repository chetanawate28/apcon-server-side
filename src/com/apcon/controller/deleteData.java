package com.apcon.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apcon.db.DBConnectionManager;


/**
 * Servlet implementation class deleteData
 */
@WebServlet("/deleteData")
public class deleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBConnectionManager db= new DBConnectionManager();
	PreparedStatement ps=null;
	Statement st=null;
	int rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int Id=Integer.parseInt(request.getParameter("Id"));
		
		try {
				Connection con = db.getConnection();
				String query="delete from person where Id="+Id;
				st=con.createStatement();				
				rs=st.executeUpdate(query); 
				System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data="[{\"message\":\"data deleted successfully\"}]";
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
