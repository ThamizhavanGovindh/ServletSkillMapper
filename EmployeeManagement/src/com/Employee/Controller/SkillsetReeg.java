package com.Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Employee.Model.EmployeeModel;

/**
 * Servlet implementation class SkillsetReeg
 */
@WebServlet("/SkillsetReeg")
public class SkillsetReeg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillsetReeg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Date date = null;		 
	    try {    	
	    
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  		
			date = new Date();  
			Date today = new SimpleDateFormat("dd/MM/yyyy").parse(formatter.format(date));	
					
			
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    String Emp_Id = request.getParameter("txtEmp_id");
	    int btchCount = Integer.parseInt(request.getParameter("txthndlbtch"));
	    int stdCount = Integer.parseInt(request.getParameter("txthndlstd"));
	    int noStdPlcd = Integer.parseInt(request.getParameter("txtplcdstd"));
	    int experiance = Integer.parseInt(request.getParameter("experiance"));
	    String certification = request.getParameter("txtcerification");
		try {

			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Where is h2 Driver?");
			e.printStackTrace();
			return;

		}
		System.out.println("h2 Driver Registered!");
		Connection connection = null;
	    try {
			connection = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test","sa","");
		} catch (SQLException sqlException) {
			System.out.println("Connection Failed! Check output console");
			sqlException.printStackTrace();
			return;
		}			
		if (connection != null) {
                        
			Statement stmt;
			try {
				String insertquery = " insert into skill_set (emp_id, skill_reg_id, reg_date, no_of_yr_exp, no_of_batches_handled, "
						+ "no_of_std_placed, no_std_handled, status)"
			        + " values (?, ?, ?, ?, ?,?, ?, ?)";
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			      // create the mysql insert preparedstatement
				EmployeeModel GetSkillId = new EmployeeModel();		
				int skilRegID = GetSkillId.GetEmpID(1)+1;
			      PreparedStatement preparedStmt = connection.prepareStatement(insertquery);
			      preparedStmt.setInt(1, Integer.parseInt(Emp_Id));			      	      
			      preparedStmt.setInt(2, skilRegID);
			      preparedStmt.setString(3, dateFormat.format(date));
			      preparedStmt.setInt(4, experiance);
			      preparedStmt.setInt(5, btchCount);
			      preparedStmt.setInt (6, noStdPlcd);

			      preparedStmt.setInt(7, stdCount);
			      preparedStmt.setString (8, "Not approved");
			      preparedStmt.execute();
			      
			      String skills;
			      skills = request.getParameter("skills");
			      EmployeeModel skillReg = new EmployeeModel();
			      
			    	  skillReg.RegisterSkil(skilRegID, skills, certification);
			      
			      connection.close();
			      String indexfrm = "index.jsp";
			      String skillupdate = "SkillUpdate.jsp";
			      PrintWriter out = response.getWriter();
			      out.println("<h1>Register Successfully</h1>");	
			      out.print("<a href="+skillupdate+">Click here to update skill</a>");
			      out.print("<a href="+indexfrm+">Click here to logout</a>");
				}
				catch (SQLException e) {
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

	}

}
