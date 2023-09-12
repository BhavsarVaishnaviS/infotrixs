package Employee_Payroll_System;

import java.sql.*;

public class ConnectionClass 
{
	Connection con ;
	Statement str;
	public Object connection;
	ConnectionClass()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/payroll", "root", "shruti");
			str = con.createStatement();
			if(con.isClosed()) {
				System.out.println("Connection closed");
			}
			else 
			{
				System.out.println("Connection...");
			}
		}
		catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) 
	{
		new ConnectionClass();
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
