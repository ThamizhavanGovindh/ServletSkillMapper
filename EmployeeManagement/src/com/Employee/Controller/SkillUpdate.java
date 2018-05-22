package com.Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class SkillUpdate
 */
@WebServlet("/SkillUpdate")
public class SkillUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillUpdate() {
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
		
		String cerificate=request.getParameter("txtCertification");
		String skill =request.getParameter("txtSkill");
		HttpSession session=request.getSession(false);  
		int skill_id = Integer.parseInt((String)session.getAttribute("skill_id"));
		try
	    {
	      // create a mysql database connection
	      String h2Driver = "org.h2.Driver";
	      String dbUrl = "jdbc:h2:tcp://localhost/~/test";
	      Class.forName(h2Driver);
	      Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
	    
	      // create a sql date object so we can use it in our INSERT statement
	      
	      // the mysql insert statement
	      String insertquery = " insert into SKILLSDTLS(skill_reg_id, skills, certification)"
	        + " values (?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(insertquery);
	      preparedStmt.setInt(1, skill_id);
	      preparedStmt.setString(3, cerificate);
	      preparedStmt.setString(2, skill);

	      preparedStmt.execute();
	      
	      conn.close();
	      PrintWriter out = response.getWriter();
	      out.println("<h1>Register Successfully</h1>");
	      out.println("<a href=SkillUpdate.jsp>Click here update skill again</a><br>");
	      out.println("<a href=index.jsp>Clic here to logout</a>");
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
