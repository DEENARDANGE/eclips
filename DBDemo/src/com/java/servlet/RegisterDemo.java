package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterDemo
 */
// @WebServlet("/register")
public class RegisterDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterDemo() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT", "root", "root");
			PreparedStatement st = con.prepareStatement("insert into STUDENTS values(?,?,?, ?)");
			st.setInt(1, Integer.valueOf(request.getParameter("id")));
			st.setString(2, request.getParameter("name"));
			st.setInt(3, Integer.valueOf(request.getParameter("age")));
			st.setString(4, request.getParameter("address"));
			// Execute the insert command using executeUpdate()
			// to make changes in database
			int i = st.executeUpdate();
			if (i > 0)
				out.println("Successfully Inserted");
			else
				out.println("please enter details");

			// Close all the connections
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
