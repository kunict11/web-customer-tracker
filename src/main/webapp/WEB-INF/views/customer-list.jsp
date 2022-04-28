<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/report-bug.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
	
		<div id="content">
		
		<input type="button" class="add-button" value="Add customer" onclick="window.location.href='customerForm';return false;" />
		
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
							<a class="action-btn" href="${updateCustomer}">Update</a>
							<a class="action-btn" href="${deleteCustomer}" 
								onclick="if(!confirm('Are you sure?')) return false;">
								Delete
							</a>							 
						</td>
						<td>
							<a href="${showDetails}">Details</a>
						</td>
					</tr>
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>

</body>

</html>









