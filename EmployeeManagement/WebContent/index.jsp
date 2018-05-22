<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EmployeeController" method="post">
<br><br><br><br><br><br>
<hr>  
<div align="center">
<h3>Employee Login</h3>
        <table border='0'>
            <tr>
                <td class="f1_label">User Name :</td><td><input type="text" name="txtuname" value="" />
                </td>
            </tr>
            <tr>
                <td class="f1_label">Password     :</td><td><input type="password" name="txtpwd" value=""  />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="login" value="Log In"/><td><a href="EmployeReg.jsp">Click here for Employee Registration</a></td>
                </td>                
            </tr>
        </table>
        </div>
<hr>
</form>  
</body>
</html>