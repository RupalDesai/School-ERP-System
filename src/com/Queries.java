package com;

import java.sql.*;
import java.util.*;

public class Queries {
	
	Scanner scan;
	Connector con = new Connector();
	public Queries()
	{
		scan=new Scanner(System.in);
		
		con.getConnection();
	}
	
	
	public String[][] selectAsArray() 
	{
		String data[][] = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select * from student_tbl order by stud_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			int i = 0, j = 1;
			while (rs.next()) 
			{
				i++;
			}
			
			data = new String[i][11];
			
			ResultSet rs1 = st.executeQuery("select * from student_tbl order by stud_id");
			
			//rs.beforeFirst();
			
			i = 0;
			while (rs1.next())
			{
				data[i][0] = rs1.getString(1);
				data[i][1] = rs1.getString(2);
				data[i][2] = rs1.getString(3);
				data[i][3] = rs1.getString(4);
				data[i][4] = rs1.getString(5);
				data[i][5] = rs1.getString(6);
				data[i][6] = rs1.getString(7);
				data[i][7] = rs1.getString(8);
				data[i][8] = rs1.getString(9);
				data[i][9] = rs1.getString(10);
				data[i][10] = rs1.getString(11);
				i++;
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return data;
	}
	
	public String[][] selectAsArrayBKP() 
	{
		String data[][] = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select * from student_bkp order by stud_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			int i = 0, j = 1;
			while (rs.next()) 
			{
				i++;
			}
			
			data = new String[i][11];
			
			ResultSet rs1 = st.executeQuery("select * from student_bkp");
			
			//rs.beforeFirst();
			
			i = 0;
			while (rs1.next())
			{
				data[i][0] = rs1.getString(1);
				data[i][1] = rs1.getString(2);
				data[i][2] = rs1.getString(3);
				data[i][3] = rs1.getString(4);
				data[i][4] = rs1.getString(5);
				data[i][5] = rs1.getString(6);
				data[i][6] = rs1.getString(7);
				data[i][7] = rs1.getString(8);
				data[i][8] = rs1.getString(9);
				data[i][9] = rs1.getString(10);
				data[i][10] = rs1.getString(11);
				i++;
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return data;
	}

	public String[][] selectAsArrayStaff() 
	{
		String data[][] = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select * from staff_tbl order by staff_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			int i = 0, j = 1;
			while (rs.next()) 
			{
				i++;
			}
			
			data = new String[i][8];
			
			ResultSet rs1 = st.executeQuery("select * from staff_tbl order by staff_id");
			
			//rs.beforeFirst();
			
			i = 0;
			while (rs1.next())
			{
				data[i][0] = rs1.getString(1);
				data[i][1] = rs1.getString(2);
				data[i][2] = rs1.getString(3);
				data[i][3] = rs1.getString(4);
				data[i][4] = rs1.getString(5);
				data[i][5] = rs1.getString(6);
				data[i][6] = rs1.getString(7);
				data[i][7] = rs1.getString(8);
				
				i++;
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return data;
	}
	
	public String[][] selectAsArrayStaff_BKP() 
	{
		String data[][] = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select * from staff_tbl_bkp order by staff_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			int i = 0, j = 1;
			while (rs.next()) 
			{
				i++;
			}
			
			data = new String[i][8];
			
			ResultSet rs1 = st.executeQuery("select * from staff_tbl_bkp order by staff_id");
			
			//rs.beforeFirst();
			
			i = 0;
			while (rs1.next())
			{
				data[i][0] = rs1.getString(1);
				data[i][1] = rs1.getString(2);
				data[i][2] = rs1.getString(3);
				data[i][3] = rs1.getString(4);
				data[i][4] = rs1.getString(5);
				data[i][5] = rs1.getString(6);
				data[i][6] = rs1.getString(7);
				data[i][7] = rs1.getString(8);
				
				i++;
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return data;
	}
	
	public String[][] selectAsArrayStaff_HIST() 
	{
		String data[][] = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select * from staff_tbl_hist order by staff_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			int i = 0, j = 1;
			while (rs.next()) 
			{
				i++;
			}
			
			data = new String[i][8];
			
			ResultSet rs1 = st.executeQuery("select * from staff_tbl_hist order by staff_id");
			
			//rs.beforeFirst();
			
			i = 0;
			while (rs1.next())
			{
				data[i][0] = rs1.getString(1);
				data[i][1] = rs1.getString(2);
				data[i][2] = rs1.getString(3);
				data[i][3] = rs1.getString(4);
				data[i][4] = rs1.getString(5);
				data[i][5] = rs1.getString(6);
				data[i][6] = rs1.getString(7);
				data[i][7] = rs1.getString(8);
				
				i++;
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Integer> getId()
	{
		ArrayList<Integer>id=new ArrayList<Integer>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select stud_id from student_tbl";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while(rs.next())
			{
				id.add(rs.getInt(1));
			}
		}
		catch(Exception b)
		{
			b.printStackTrace();
		}
		
		return id;
	}
	
	public ArrayList<Integer> getId_fees()
	{
		ArrayList<Integer>id=new ArrayList<Integer>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select stud_id from student_tbl";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while(rs.next())
			{
				id.add(rs.getInt(1));
			}
		}
		catch(Exception b)
		{
			b.printStackTrace();
		}
		
		return id;
	}
	
	public ArrayList<Integer> getId_staff()
	{
		ArrayList<Integer>id=new ArrayList<Integer>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
			String q = "select staff_id from staff_tbl order by staff_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while(rs.next())
			{
				id.add(rs.getInt(1));
			}
		}
		catch(Exception b)
		{
			b.printStackTrace();
		}
		
		return id;
	}
	
	

}
