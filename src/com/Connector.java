package com;
	
import java.sql.*;
public class Connector {
		
		public static Connection con;
		public  void getConnection()
		{
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
	}
