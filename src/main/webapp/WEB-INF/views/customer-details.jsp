<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Details</title>
		
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/customer-details.css" />
		
	</head>
	<body>
		<div class="container">
		
			<div class="header-wrap">
				<div class="mr-2 name-wrap">
					<h3>${customer.firstName} ${customer.lastName} (${customer.customerDetails.gender.name})</h3>
					<h4 style="margin-top: -1rem">${customer.email}</h4>
				</div>
				
				<img class="profile-pic" alt="No image available" src="data:image/jpeg;base64,${customerPhoto}"/>
				
			</div>
				
			<div class="mt-2">
				
				<div>Date of birth: ${customerBirthday}</div>
				<div>Address: ${customer.customerDetails.address}</div>
			
			</div>
		
		</div>
	</body>
</html>