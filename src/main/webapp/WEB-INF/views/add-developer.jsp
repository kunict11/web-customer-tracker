<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/style.css">
	
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/styles/add-customer-style.css">
		<title>Add developer</title>
	</head>
	<body>
		<div id="wrapper">
			<div id="header" style="background: #4c64c2">
				<h2>Add developer</h2>
			</div>
		</div>
	
		<div id="container">
			<h3>Save Customer</h3>
		
			<form:form action="saveDeveloper" modelAttribute="developer" method="POST">
				<form:hidden path="id" />
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
					
						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
	
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
						</tr>
						
						<security:authorize access="hasRole('MANAGER') || hasRole('ADMIN')">
	 						<tr>
								<td><label>Project:</label></td>
								<td>
									<form:select path="project.id">
										<form:option value="0" label="Select project" />
										<form:options items="${projects}" itemValue="id" itemLabel="name" />
									</form:select>
								</td>
							</tr>
						</security:authorize>
	
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
	
					
					</tbody>
				</table>
			
			
			</form:form>
		
			<div style="clear; both;"></div>
			
			<p>
				<a class="action-btn" href="${pageContext.request.contextPath}/developer/list">&#8592; Back to List</a>
			</p>
		
		</div>
	</body>
</html>