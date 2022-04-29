<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
						<th>Status</th>
					</tr>
					
					<c:forEach var="project" items="${projects}">
						<c:forEach var="bug" items="${project.bugs}">	
						
							<tr>
								<td class="desc"> ${bug.description} </td>
								<td class="table-data"> ${project.name} </td>
								<td class="table-data"> ${bug.component} </td>
								<td class="table-data"> ${bug.priority} </td>
								<td class="table-data"> ${bug.status}</td>
							</tr>
						</c:forEach>
					</c:forEach>
							
				</table>
					
			</div>
		
		</div>
	
	</div>

</body>

</html>









