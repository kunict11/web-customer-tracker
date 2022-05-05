<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.tanja.web_customer_tracker.model.bug.Status" %>

<!DOCTYPE html>

<html>

<head>
	<title>Bugs</title>
	<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/styles/bug-list.css" />

</head>

<body>

	<div class="container">
		<div>
			<h2>List of found bugs</h2>
		</div>

	
		<div>
		
		
			<div>
			
				<table class="bug-table">
					<tr>
						<th>Bug</th>
						<th>Project</th>
						<th>Component</th>
						<th>Priority</th>
						<th>Reported By</th>
						<th>Status</th>
						<th>Assigned developer</th>
						<th> </th>
					</tr>
					
					<c:forEach var="project" items="${projects}">
						<c:forEach var="bug" items="${project.bugs}">	
						
						<c:url var="resolveBug" value="/bug/resolveBug" >
							<c:param name="bugId" value="${ bug.id }" />
						</c:url>
						
						<c:url var="bugDetails" value="/bug/details" >
							<c:param name="projectId" value="${ project.id }" />
							<c:param name="bugId" value="${ bug.id }" />
						</c:url>
						
							<tr>
								<td class="desc"> ${bug.description} </td>
								<td class="table-data"> ${project.name} </td>
								<td class="table-data"> ${bug.component} </td>
								<td class="table-data"> ${bug.priority} </td>
								<td class="table-data"> ${bug.customer.firstName} ${bug.customer.lastName} </td>
								<td class="table-data"> ${bug.status}</td>
								<td class="table-data">
									<c:if test="${bug.status == Status.UNRESOLVED}">
										<a href=${bugDetails}>Assign developer</a>
									</c:if>
									<c:if test="${bug.status != Status.UNRESOLVED}">
										${bug.assignedDeveloper.firstName} ${bug.assignedDeveloper.lastName}
									</c:if>
								</td>
								<td class="table-data">
									<c:if test="${bug.status == Status.IN_PROGRESS}">
										<a href="${resolveBug}">Resolve</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:forEach>
							
				</table>
					
			</div>
		
		</div>
	
	</div>

</body>

</html>









