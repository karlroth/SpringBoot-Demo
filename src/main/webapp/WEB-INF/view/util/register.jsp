<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<h1>Register</h1>
	<form:form action="./processRegistration.htm" method="post"
		modelAttribute="command">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input class="table_input" path="userName" placeholder="" /> </td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password class="table_input" path="password" placeholder="" /> </td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input class="table_input" path="email" placeholder="" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input class="table_input" path="firstName" placeholder="" /> </td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input class="table_input" path="lastName" placeholder="" /> </td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><form:input class="table_input" path="phoneNumber" placeholder="" /> </td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input class="table_input" path="address" placeholder="" /> </td>
			</tr>
			<tr>
				<td styel="text-align: right"><input class="table_button" type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>