<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form:form action="./loginUser.htm" method="post"
		modelAttribute="command">
		<table>
			<tr>
				<td><p>Username:</p> <form:input class="table_input"
						path="userName" placeholder="" /></td>
			</tr>
			<tr>
				<td><p>Password:</p> <form:password class="table_input"
						path="password" placeholder="" /></td>
			</tr>
			<tr>
				<td style="text-align:right" ><input class="table_button" type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>
	<a href="./registration.htm">New User? Register Here.</a>
	

</body>
</html>