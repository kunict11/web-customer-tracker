<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Web Customer Tracker</h1>
        <a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
        <a href="${pageContext.request.contextPath}/project/reportBugForm">View projects and add bug</a>
        <%-- <a href="${pageContext.request.contextPath}/bug/list">Bug List</a> --%>
<%--         <% response.sendRedirect("customer/list"); %> --%>      
    </body>
</html>
