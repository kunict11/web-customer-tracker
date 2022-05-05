<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.tanja.web_customer_tracker.model.bug.Status" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
<form:form modelAttribute="bug" action="changeStatus" method="PUT">
	<form:hidden path="id" />
	
	<h2>${bug.description}</h2>
	
	<form:select path="status">
		<form:options items="${Status.values()}" />
	</form:select>
	
	<input type="submit" value="Apply" />
</form:form>
</div>

</body>
</html>