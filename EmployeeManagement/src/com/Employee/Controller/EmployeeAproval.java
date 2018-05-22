package com.Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Employee.Model.EmployeeModel;

/**
 * Servlet implementation class EmployeeAproval
 */
@WebServlet("/EmployeeAproval")
public class EmployeeAproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAproval() {
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
		
			      String[] employeeIDs;
			      employeeIDs = request.getParameterValues("skills");
			      EmployeeModel UpdateStatus = new EmployeeModel();
			      for (int employeeIndx = 0; employeeIndx < employeeIDs.length; employeeIndx++) {
			    	  UpdateStatus.approveEmployee(Integer.parseInt(employeeIDs[employeeIndx]));		    	    
			    	}
			      
			      
			      String indexfrm = "index.jsp";
			      String hrhome="HRHome";
			      PrintWriter out = response.getWriter();
			      out.println("<h1>Register Successfully</h1>");
			      out.print("<a href="+hrhome+">Click here to logout</a>");
			      out.print("<a href="+indexfrm+">Click here to logout</a>");
				

		

	}

}
