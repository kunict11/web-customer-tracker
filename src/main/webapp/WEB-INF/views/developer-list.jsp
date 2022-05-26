<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Developers</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/style.css" />
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
			<div id="wrapper">
			<div id="header" style="background: #4c64c2">
				<h2>Developer List</h2>
			</div>
		</div>
		
		<div id="container">
		
		
			<div id="content">
			
			<security:authorize access="hasRole('MANAGER') || hasRole('ADMIN')">
				<input type="button" class="add-button" value="Add developer" onclick="window.location.href='showDevForm';return false;" />
			</security:authorize>
			
				<table>
					<tr>
						<th style="background: #4c64c2">First Name</th>
						<th style="background: #4c64c2">Last Name</th>
						<th style="background: #4c64c2">Email</th>
						<th style="background: #4c64c2">Project</th>
						<th style="background: #4c64c2">Action</th>
					</tr>
					
					<c:forEach var="dev" items="${developers}">	
					
	 					<c:url var="updateDeveloper" value="/developer/showFormForUpdate" >
							<c:param name="devId" value="${ dev.id }" />
						</c:url>
						
						<c:url var="deleteDeveloper" value="/developer/deleteDeveloper" >
							<c:param name="devId" value="${ dev.id }" />
						</c:url>

					
						<tr>
							<td> ${dev.firstName} </td>
							<td> ${dev.lastName} </td>
							<td> ${dev.email} </td>
							<td>
							<c:if test="${dev.project != null}">
							 	${dev.project.name}
							</c:if>
							<c:if test="${dev.project == null}">
							 	Not assigned to any project
							</c:if>
							 </td>
							<td> 
	 							<a class="action-btn" href="${updateDeveloper}">Update</a>
	 							<security:authorize access="hasRole('ADMIN')">
									<a class="action-btn" href="${deleteDeveloper}" 
										onclick="if(!confirm('Are you sure?')) return false;">
										Delete
									</a>							 
	 							</security:authorize>
							</td>
						</tr>
					</c:forEach>
							
				</table>
					
			</div>
			<p>
				<a class="action-btn" href="${pageContext.request.contextPath}">&#8592; Back to Home</a>
			</p>
		</div>
	</body>
</html>