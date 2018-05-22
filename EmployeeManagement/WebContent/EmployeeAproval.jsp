<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection"%>
    <%@ page import="java.sql.DriverManager"%>
    <%@ page import="java.sql.Statement"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>      
<form action="EmployeeAproval" method="post">
        <%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Class.forName("org.h2.Driver");
Connection connection = DriverManager.getConnection(
		"jdbc:h2:tcp://localhost/~/test","sa","");
       Statement statement = connection.createStatement() ;

       ResultSet resultset =statement.executeQuery("select e. emp_id , e.emp_name,e.DESIGNATION , s.no_of_yr_exp, s.no_of_std_placed, s.status from Employee e, Skill_set s where e.emp_id = s.emp_id and s.status='Not approved'");
%>

<center>
        <table>
        <tr><th>Employee ID</th>
        <th>Employee Name</th>
        <th>Designation</th>
        <th>Experience</th>
        <th>Student placed</th>
        <th>Status</th>      
        <th>Approve</th>              
        <tr>
        <%  while(resultset.next()){ %>
             <tr><td>   <%= resultset.getString(1)%></td>
             <td>   <%= resultset.getString(2)%></td>
             <td>   <%= resultset.getString(3)%></td>
             <td>   <%= resultset.getString(4)%></td>
             <td>   <%= resultset.getString(5)%></td>
             <td>   <%= resultset.getString(6)%></td>
             <td><td> <input type="checkbox" name="skills" value="<%=resultset.getString(1)%>"></td>
             </tr>
                 <% } %>
        </table>
</center>

<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
<input type='submit' value="Approval">
</form>
</body>
</html>