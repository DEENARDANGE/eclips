package com.bridgelabz.webdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo2
 */
public class Demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Demo2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		String query = "select * from STUD where name= ? and password= ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("class loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DETAILS", "root", "root");
			//System.out.println("connected...");
			stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, password);

			rs = stmt.executeQuery();
			if (rs.next()) {
				//String user = rs.getString(5);
				//System.out.println("UserId: " + user);
				PrintWriter out = response.getWriter();
				out.println("Welcome   " );

			} else {
				System.out.println("invalid user");
//				RequestDispatcher rqst = request.getRequestDispatcher("/Registrion.java");
//				rqst.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}



}