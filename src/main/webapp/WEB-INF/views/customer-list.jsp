<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

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
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
	
		<div id="content">
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
					<th> </th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">	
				
					<c:url var="updateCustomer" value="/customer/showFormForUpdate" >
						<c:param name="customerId" value="${ tempCustomer.id }" />
					</c:url>
					
					<c:url var="deleteCustomer" value="/customer/deleteCustomer" >
						<c:param name="customerId" value="${ tempCustomer.id }" />
					</c:url>
					
					<c:url var="showDetails" value="/customer/details" >
						<c:param name="customerId" value="${ tempCustomer.id }" />
					</c:url>
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> 
						<c:if test="${SecurityContextHolder.getContext().getAuthentication().getName().equals(tempCustomer.email)}">
							<a class="action-btn" href="${updateCustomer}">Update</a>
						</c:if>
						<security:authorize access="hasRole('ADMIN')">
							<a class="action-btn" href="${deleteCustomer}" 
								onclick="if(!confirm('Are you sure?')) return false;">
								Delete
							</a>	
						</security:authorize>						 
						</td>
						<td>
							<a href="${showDetails}">Details</a>
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









