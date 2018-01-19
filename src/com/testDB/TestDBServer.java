package com.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServer
 */
@WebServlet("/TestDBServer")
public class TestDBServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Defining data connection
		String user="springstudent";
		String pass="springstudent";
		String jdbcURL="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String drive="com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to : "+jdbcURL);
			
			Class.forName(drive);
			
			Connection connection = DriverManager.getConnection(jdbcURL,user,pass);
			
			out.println("SUCCESS!!!");
			
			connection.close();
			
		}//Close try. 
		
		catch (Exception e) {
			e.printStackTrace();
		}//Close catch.
	
	}

}
