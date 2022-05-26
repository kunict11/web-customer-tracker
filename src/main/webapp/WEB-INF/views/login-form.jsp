<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/processLogin" method="POST">
	<div style="display:flex; flex-direction:column;width:300px">
		<div style="margin: 50px 0 0 37px">
			<label>E-mail</label>
			<input type="email" name="username"/>
		</div>
		
		<div style="margin: 10px 0 0 20px">
			<label>Password</label>
			<input type="password" name="password" />
		</div>
		<div style="margin: 20px 0 0 0; align-self:center">
			<input type="submit" value="Log In" />
	</div>
	</div>
	</form:form>
	
	<a class="action-btn" href="${pageContext.request.contextPath}/register">Register</a>
</body>
</html>