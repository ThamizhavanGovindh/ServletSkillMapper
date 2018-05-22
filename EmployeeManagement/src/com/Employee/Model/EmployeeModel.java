package com.Employee.Model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeModel {
	
	public int GetEmpID(int flag) {
		
		try {

			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Where is h2 Driver?");
			e.printStackTrace();
			return 0;

		}
		System.out.println("h2 Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return 0;
		}			
		if (connection != null) {
                        
			Statement stmt;
			try {
				stmt = connection.createStatement();
			ResultSet rs;
			if(flag == 0)
				rs = stmt.executeQuery("select max(emp_id) as id from employee");
			else
				rs = stmt.executeQuery("select max(skill_reg_id) as id from skill_set");
				if(!rs.next())
				{
					System.out.println("Invalid data");
					return 1;
					
				}
				else
				{					
					int id=  Integer.parseInt(rs.getString("id"));
					System.out.println("Employee id is"+id);
					return id+1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	  	}
		else {
			System.out.println("Failed to make connection!");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	public void RegisterSkil(int skillrgID, String skill, String Certification) {
		
			
		try
	    {
	      // create a mysql database connection
	      String h2Driver = "org.h2.Driver";
	      String dbUrl = "jdbc:h2:tcp://localhost/~/test";
	      Class.forName(h2Driver);
	      Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
	    
	      // create a sql date object so we can use it in our INSERT statement
	      
	      // the mysql insert statement
	      String insertquery = " insert into skillsDtls(skill_reg_id, skills,Certification)"
	        + " values (?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(insertquery);	      
	      preparedStmt.setInt(1, skillrgID);
	      preparedStmt.setString(3, Certification);
	      preparedStmt.setString(2, skill);

	      // execute the preparedstatement
	      preparedStmt.execute();
	       
	      conn.close();
	      
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
		System.out.println("Data inserted");

	}
	
	public void approveEmployee(int EmployeeID)
	{
		try
	    {
	      // create a mysql database connection
	      String h2Driver = "org.h2.Driver";
	      String dbUrl = "jdbc:h2:tcp://localhost/~/test";
	      Class.forName(h2Driver);
	      Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
	    
	      // create a sql date object so we can use it in our INSERT statement
	      Statement stmt = null;    
	      stmt = conn.createStatement();
			String query = "UPDATE skill_set SET Status= 'Approved'\r\n" + 
					"WHERE Emp_ID = "+EmployeeID+"";
		
			stmt.executeUpdate(query);	       
	      conn.close();
	}
		catch(Exception e) {
			System.out.println("Exception" + e);
		}
}


public int ChecSkillSet(int emp_id)
{
	try {

		Class.forName("org.h2.Driver");

	} catch (ClassNotFoundException e) {
		System.out.println("Where is h2 Driver?");
		e.printStackTrace();
		return 0;

	}
	System.out.println("h2 Driver Registered!");
	Connection connection = null;
	try {
		connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return 0;
	}			
	if (connection != null) {
                    
		Statement stmt;
		try {
			stmt = connection.createStatement();
		ResultSet rs;
		
			rs = stmt.executeQuery("select skill_reg_id as id from skill_set where emp_id="+emp_id+"");
		
			if(!rs.next())
			{
				System.out.println("Invalid data");
				return 1;
				
			}
			else
			{					
				int id=  rs.getInt("id");
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	}
	else {
		System.out.println("Failed to make connection!");
	}
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;

}
}