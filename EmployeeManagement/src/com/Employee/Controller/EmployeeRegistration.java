package com.Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/EmployeeRegistration")
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistration() {
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
		System.out.println("Invoked");
		int Emp_Id = Integer.parseInt(request.getParameter("txtEmp_id"));
		String Emp_Name = request.getParameter("txtEmp_Fname");
		String Emp_Gender = request.getParameter("rdgender");
		String DOB = request.getParameter("txtdob");
		String Mobile_no = request.getParameter("txtPhoneNo");
		String Email = request.getParameter("txtEmail");
		String address = request.getParameter("txtaddress");
		String designation = request.getParameter("designation");
		String joinDate = request.getParameter("txtjoindate");
		String Qualification = request.getParameter("qualifaication");
		String Password	= request.getParameter("txtpwd");	
		String CnfmPassword = request.getParameter("txtCnfmPwd");
		
		//Password Validation
		if(Password.isEmpty() || CnfmPassword.isEmpty()) {
			System.out.print("Cnfm password");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");
			request.setAttribute("PwdValidation","Password should not be empty");
			requestdispatcher.include(request,response);
		}
		else if(!Password.equals(CnfmPassword)) {			
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");
			request.setAttribute("PwdValidation","Password and Confirm password should be same");
			requestdispatcher.include(request,response);
		}
		
		//Name Validation	
		if(Emp_Name.isEmpty()) {
			System.out.print("Name valid");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");			
			request.setAttribute("NameValidation","Name should not be empty");
			requestdispatcher.include(request,response);
		}		
		
		//Mobile Validation
		if(Mobile_no.isEmpty()) {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");
			request.setAttribute("MobileValidation","Mobile number should not be empty");
			requestdispatcher.include(request,response);		
		}
		

		try
	    {
	      // create a mysql database connection
	      String h2Driver = "org.h2.Driver";
	      String dbUrl = "jdbc:h2:tcp://localhost/~/test";
	      Class.forName(h2Driver);
	      Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
	    
	      // create a sql date object so we can use it in our INSERT statement
	      
	      // the mysql insert statement
	      String insertquery = " insert into employee (emp_id, emp_name, gender, dob, mobile_no, Email_id, join_date, "
	      		+ "designation, address, qualification, uname, password)"
	        + " values (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(insertquery);
	      preparedStmt.setInt(1, Emp_Id);
	      preparedStmt.setString(2, Emp_Name);
	      preparedStmt.setString(3, Emp_Gender);
	      preparedStmt.setString(4, DOB);
	      preparedStmt.setString (5, Mobile_no);

	      preparedStmt.setString(6, Email);
	      preparedStmt.setString(7, joinDate);
	      preparedStmt.setString (8, designation);
	      
	      preparedStmt.setString(9, address);
	      preparedStmt.setString(10, Qualification);
	      preparedStmt.setString (11, Email);
	      preparedStmt.setString (12, Password);
	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	      PrintWriter out = response.getWriter();
	      out.println("<h1>Register Successfully</h1>");
	      out.println("<a href=index.jsp>Clic here to login again</a>");
	      //response.sendRedirect("index.jsp");
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
		System.out.println("Data inserted");
	}
}

