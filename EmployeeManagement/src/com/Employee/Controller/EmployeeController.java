package com.Employee.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Employee.Model.EmployeeModel;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("txtuname");
		String password =request.getParameter("txtpwd");
		
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
				stmt = connection.createStatement();
				
				ResultSet rsltsset;
			
				rsltsset = stmt.executeQuery("select * from employee where uname ='"+uname+"'  and password = '"+password+"' ");
			
				if(rsltsset.next())
				{
					
					int Emp_ID = rsltsset.getInt("Emp_id"); 
					String designation = rsltsset.getString("Designation");					
					HttpSession session=request.getSession();  			   
					
					System.out.println("Employee id is"+Emp_ID);
									
					System.out.println("After query execution");
					int skill_id = 0;
					
					EmployeeModel modelObj = new EmployeeModel();
					skill_id = modelObj.ChecSkillSet(Emp_ID);
				
			        session.setAttribute("Emp_id",""+Emp_ID+"");
			        session.setAttribute("skill_id",""+skill_id+"");
			        
			        if(designation.equals("HR"))
			        		response.sendRedirect("HRHome.jsp");
			        else if(designation.equals("Manager"))
			        	response.sendRedirect("EmployeeSearch.jsp");
 			        else if(skill_id > 1)
 			        {
			        	response.sendRedirect("SkillUpdate.jsp");
			        	System.out.print("Skill id is"+skill_id);
 			        }
			        else
			        	response.sendRedirect("SkillSetReg.jsp");
				}
				else
				{
					PrintWriter out = response.getWriter();
				      out.println("<h1>Invalid data</h1>");
				      out.println("<a href=index.jsp>Clic here to login again</a>");
					
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
	}

}
