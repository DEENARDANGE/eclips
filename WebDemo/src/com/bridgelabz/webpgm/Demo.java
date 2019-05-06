package com.bridgelabz.webpgm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Demo {

	public static void main(String[] srgs) throws ClassNotFoundException, SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT?user=root&password=root");
			//DISPLAY
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from STUDENTS");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+" "+rs.getString(4));
			
			
			//INSERT
			PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("insert into STUDENTS values(?,?,?,?)");  
			stmt1.setInt(1,9);//1 specifies the first parameter in the query  
			stmt1.setString(2,"Ratan");  
			stmt1.setInt(3,52); 
			stmt1.setString(4,"XYZ"); 
			int i=stmt1.executeUpdate();  
			System.out.println(i+" records inserted"); 
			
			// DELETE
			PreparedStatement stmt3=(PreparedStatement) con.prepareStatement("delete from STUDENTS where id=?");  
			stmt3.setInt(1,7);  
			int j=stmt3.executeUpdate();  
			System.out.println(j+" records deleted");  
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
