package com.apcon.controller;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apcon.db.DBConnectionManager;
import com.apcon.model.dataBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
 * Servlet implementation class getviewData
 */
//@WebServlet("/getviewData")
public class getviewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dateTime;
       DBConnectionManager db= new DBConnectionManager();
       GsonBuilder gsonBuilder= new GsonBuilder();
       Gson gs= gsonBuilder.create();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getviewData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String check = request.getParameter("check");
			String datetimebyReuest = request.getParameter("serverDateTime");
			String datetimebyAttribute = (String) request.getAttribute("serverDateTime");
			if(!(datetimebyReuest==null)){
				 dateTime = datetimebyReuest;			
			}
			if(!(datetimebyAttribute==null))
			{
				 dateTime = datetimebyAttribute;			
			}
			PreparedStatement ps = null;
			ResultSet rs = null;
			dataBean databean=null;
			 ArrayList<dataBean> arrayList=new ArrayList<dataBean>();
			
			Connection con= db.getConnection();			
			ps = con.prepareStatement("SELECT * FROM person WHERE currentdatetime >= '"+dateTime+"'");			
			rs = ps.executeQuery();			
			if(!(rs==null)){
					while(rs.next()){
						 databean=new dataBean(rs.getInt("Id"),rs.getString("name"),rs.getString("email"),rs.getString("dob"),rs.getString("mbnum"));
						 arrayList.add(databean);
						 System.out.println(databean);
					}
			}
				
			if(check==null)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/viewData.jsp");
				request.setAttribute("getviewData", arrayList);
				dispatcher.forward(request, response);
			}
		else
			{
				//HashMap<String, ArrayList<String>> hm= new HashMap<>();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				//hm.put("currentDateTime", dateFormat.format(date));
				
				JsonObject obj = new JsonObject();
				obj.addProperty("currentDateTime", dateFormat.format(date));
				//obj.addProperty("alldata", gs.toJson(arrayList));
				
				String json = new Gson().toJson(obj);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				//response.getWriter().write(json);
				response.getWriter().write("{\"currentDateTime\":\""+ dateFormat.format(date)+"\",\"alldata\":"+gs.toJson(arrayList)+"}");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		try {
//			PreparedStatement ps = null;
//			ResultSet rs = null;
//			Connection con= db.getConnection();
//			ps = con.prepareStatement("select * from person");			
//			rs = ps.executeQuery();			
//			if(!(rs==null)){				
//					dataBean databean=new dataBean(rs.getInt("Id"),rs.getString("name"),rs.getString("email"),rs.getString("dob"),rs.getInt("mbnum"));
//					RequestDispatcher dispatcher = request.getRequestDispatcher("/viewData.jsp");
//					request.setAttribute("getviewData", databean);
//					dispatcher.forward(request, response);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
