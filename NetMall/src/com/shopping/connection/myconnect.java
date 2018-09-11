package com.shopping.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myconnect {
	public static Connection dbcon()
	{
		Connection con=null;
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="elliot";
		String pass="robot";
		try {
			Class.forName(driver);
			System.out.println("Driver found");
			try {
				con=DriverManager.getConnection(url,user,pass);
				System.out.println("Connection Established");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Connection NOT established");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver NOT found");
			e.printStackTrace();
		}
		return con;
	}
}
