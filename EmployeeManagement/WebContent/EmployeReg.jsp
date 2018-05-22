<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Employee.Model.EmployeeModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<FORM action="EmployeeRegistration" method="post">
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<center><tr>
   <td><h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Employee Registration</h1></td>
</tr><center>
 
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<tr>
    <td align='right'>Employee ID:</td>
    <td>
  <%
    EmployeeModel EmpModelObj = new EmployeeModel();
    int Emp_id;
    Emp_id = EmpModelObj.GetEmpID(0);
    String Emp_idStr = String.valueOf(Emp_id);
    
  %>
    <input type='text' name='txtEmp_id' value="<%=Emp_idStr %>" readonly="readonly"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Full Name:</td>
    <td><input type='text' name='txtEmp_Fname'></td>
    <td><font color="Red"><%= request.getAttribute("NameValidation")%></font></td>    
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Gender:</td>
    <td><input type="radio" name="rdgender" value="male"> Male
<input type="radio" name="rdgender" value="female"> Female</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Date Of Birth:</td>
    <td><input type='text' name='txtdob'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Mobile Number:</td>
    <td><input name="txtPhoneNo" type="text" /></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Email ID:</td>
    <td><input type='text' name='txtEmail'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Address:</td>
    <td><textarea type='text' name='txtaddress'></textarea></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Designation:</td>
    <td> <select id = "id" name="designation">
    		   <option value = "Select">Select</option>
               <option value = "Trainer">Trainer</option>
               <option value = "Tech support">Tech support</option>
               <option value = "HR">HR</option>
               <option value = "GM">GM</option>
             </select></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Join date:</td>
    <td><input type='text' name='txtjoindate'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Select your Max Qualification:</td>
    <td><select id = "qualifaication" name="qualifaication">
    		   <option value = "Select">Select</option>
               <option value = "Bachelor Degree">Bachelor Degree</option>
               <option value = "Master Degree">Master Degree</option>
               <option value = "MPhil">MPhil</option>
               <option value = "Phd">Phd</option>
             </select></td>
</tr>
<tr> <td>&nbsp;</td> </tr>

<tr>
    <td align='right'>Password:</td>
    <td><input type='password' name='txtpwd'></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'>Confirm Password:</td>
    <td><input type='password' name='txtCnfmPwd'></td>
    <td><td><%= request.getAttribute("PwdValidation")%></td></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr> <td>&nbsp;</td> </tr>
<table border='0' cellpadding='0' cellspacing='0' width='480px' align='center'>
<tr>
    <td align='center'><input type='submit' name='REGISTER' value="Register"></td>
</tr>
</table>
</table>
 
</table>
</body>
</html>