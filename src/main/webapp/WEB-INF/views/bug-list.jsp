<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Bugs</title>
	

</head>

<body>

	<div class="container">
		<div>
			<h2>List of found bugs</h2>
		</div>

	
		<div>
		
		
			<div>
			
				<table>
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
								<td> ${bug.description} </td>
								<td> ${project.name} </td>
								<td> ${bug.component} </td>
								<td> ${bug.priority} </td>
								<td> ${bug.status}</td>
							</tr>
						</c:forEach>
					</c:forEach>
							
				</table>
					
			</div>
		
		</div>
	
	</div>

</body>

</html>









