package com.Employee.Controller;

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

/**
 * Servlet implementation class SkillSearch
 */
@WebServlet("/SkillSearchController")
public class SkillSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillSearchController() {
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
		
		String skill = request.getParameter("skill");

		try {

			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Where is h2 Driver?");
			e.printStackTrace();
			return;

		}
		
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
			
			rsltsset = stmt.executeQuery("select e.EMP_ID, e.EMP_NAME ,e.designation, s.STATUS , b.SKILLS from EMPLOYEE e, SKILL_SET s, SKILLSDTLS b where e.EMP_ID = s.EMP_ID and s.SKILL_REG_ID = b.SKILL_REG_ID and skills = '"+skill+"' and s.status = 'Approved'");
			System.out.println(rsltsset);
				PrintWriter out = response.getWriter();
				out.println("<table>\r\n" + 
						"  <tr>\r\n" + 
						"    <th>Employee Id</th>\r\n" + 
						"    <th>Emplyee Name</th>\r\n" + 
						"    <th>Designation</th>\r\n" + 
						"    <th>Skill</th>\r\n" + 
						"    <th>Status</th>\r\n" + 						
						"  </tr>");
				
				while(rsltsset.next())
				{
										
					out.println("<tr>\r\n" + 
							"    <td>"+rsltsset.getString("emp_id")+"</td>\r\n" + 
							"    <td>"+rsltsset.getString("EMP_NAME")+"</td>\r\n" + 
							"    <td>"+rsltsset.getString("DESIGNATION")+"</td>\r\n" + 
							"    <td>"+rsltsset.getString("skills")+"</td>\r\n" + 
							"    <td>"+rsltsset.getString("Status")+"</td>\r\n" + 					
							"  </tr>\r\n" + 
							"");					
				}							    
			    out.println("<a href=HRHome.jsp>Clic here to go HR Home</a>");
				out.println("<a href=index.jsp>Click here logout</a>");
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
