<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>${bug.description}</h3>
	<p>Project: ${project.name}</p>
	<p>Component: ${bug.component}</p>
	
	<p>Developers on the project: </p>
	<ul>
		<c:forEach var="dev" items="${project.developers}">
			<c:url var="assignDeveloper" value="/bug/assignDeveloper" >
				<c:param name="devId" value="${dev.id}" />
				<c:param name="bugId" value="${bug.id}"/>
			</c:url>
			
			<li>
				${dev.firstName} ${dev.lastName} <a href="${assignDeveloper}" > Assign </a>
			</li>
			
		</c:forEach>
	</ul>
	
</body>
</html>