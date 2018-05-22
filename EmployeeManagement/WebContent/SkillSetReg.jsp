<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<FORM action="SkillsetReeg" method="post">
<br><br><br><br><hr>
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<center><tr>
   <td><h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Skill Set Registration</h1></td>
</tr><center>
 
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<tr>
<%
   String Emp_id = (String) request.getSession(false).getAttribute("Emp_id");
%>
    <td align='right'>Employee ID:</td>
    <td>   
    <input type='text' name='txtEmp_id' value="<%=Emp_id%>" readonly="readonly"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Number of Batches Handled:</td>
    <td><input type='text' name='txthndlbtch'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Number of student Handled:</td>
    <td><input type='text' name='txthndlstd'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Number of student placed:</td>
    <td><input type='text' name='txtplcdstd'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Experience:</td>
    <td><input type='text' name='experiance'></td>
</tr>

<tr>
    <td align='right'>If any International certification:</td>
    <td><input type='text' name='txtcerification'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Skills:</td>
    <td> <input type='text' name='skills'>
  </td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
<td></td>
<td align='left'><input type='submit' name='REGISTER' value="Register"></td>
</tr>
</table>
 
</table>
<hr>
</FORM>
</body>
</html>