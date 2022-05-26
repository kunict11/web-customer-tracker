<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.tanja.web_customer_tracker.model.bug.Priority" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/project-details.css" />
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/report-bug.css" />
		<title>Insert title here</title>
	</head>
	<body>
	    <a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
	    <security:authorize access="!hasRole('CUSTOMER')">
        |
        <a href="${pageContext.request.contextPath}/developer/list">Developer List</a>
        </security:authorize>
        |
        <a href="${pageContext.request.contextPath}/project/bugList">Bug List</a>
        |
        <a href="${pageContext.request.contextPath}/project/reportBugForm">View projects and add bug</a>
		<div class="split-columns">
			<div class="project-container">
				<h2>Available projects:</h2>
			
				<c:forEach var="project" items="${projects}">
					<div class="details-container">
						<h3>${project.name}</h3>
						<p>${project.component}</p>
					</div>
				</c:forEach>
			</div>
		
			<div class="form-container">
				<form:form action="reportBug" modelAttribute="bug" method="POST">
					<div class="bug-desc">
						<label>Bug description:</label>
						<form:textarea rows="4" cols="64" path="description" />
					</div>
					
					<div class="field-wrap">
						<label>Project: </label>
						<select name="selectedProject">
							<c:forEach var="project" items="${projects}">
								<option value="${project.id}" label="${project.name}" />				
							</c:forEach>
						</select>
					</div>
					
					<div class="field-wrap">
						<label>Component: </label>
						<form:input type="text" path="component" />
						
					</div>
					
					<div class="field-wrap">
						<label>Priority: </label>
						<div style="margin-top:5px;">
							<c:forEach var="priority" items="${Priority.values()}">
								<label>${priority}</label>
								<form:radiobutton value="${priority}" path="priority" />
							</c:forEach>
						</div>
					</div>
					
					<input class="submit-btn" type="submit" value="Report" />
				</form:form>
			</div>
			<p>
				<a class="action-btn" href="${pageContext.request.contextPath}">&#8592; Back to Home</a>
			</p>
		</div>
	</body>
</html>