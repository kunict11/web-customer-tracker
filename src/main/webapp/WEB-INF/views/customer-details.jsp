<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Details</title>
	</head>
	<body>
		<div>
		
			<h3>${customer.firstName} ${customer.lastName} (${customer.customerDetails.gender.name})</h3>
			<h4>${customer.email}</h4>
			
			<div>
				
				<div>Date of birth: ${customerBirthday}</div>
				<div>Address: ${customer.customerDetails.address}</div>
			
			</div>
		
		</div>
	</body>
</html>