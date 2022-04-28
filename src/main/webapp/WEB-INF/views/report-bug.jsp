<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<form>
					<div class="bug-desc">
						<label>Bug description:</label>
						<textarea rows="4" cols="64">
						</textarea>
					</div>
					<select>
						<c:forEach var="project" items="${projects}">
							<option value="${project.id}" label="${project.name}"/>				
						</c:forEach>
					</select>
				</form>
				<label>Priority</label>
				<div>
					<label>Low</label>
					<input type="radio" value="LOW" />
					
					<label>Normal</label>
					<input type="radio" value="NORMAL" />
					
					<label>High</label>
					<input type="radio" value="HIGH" />
				</div>
			</div>

		</div>
	</body>
</html>