<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Web Customer Tracker</h1>
        <a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
        |
        <a href="${pageContext.request.contextPath}/developer/list">Developer List</a>
        |
        <a href="${pageContext.request.contextPath}/project/bugList">Bug List</a>
        |
        <a href="${pageContext.request.contextPath}/project/reportBugForm">View projects and add bug</a>
<%--         <% response.sendRedirect("customer/list"); %> --%>   

		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Log out" />
		</form:form>
    </body>
</html>
