<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.tanja.web_customer_tracker.model.customer.GenderEnum" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/styles/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
		<form:form action="updateCustomer" modelAttribute="customer" method="POST" enctype="multipart/form-data">
			<form:hidden path="id" />
			<form:hidden path="customerDetails.id" />
			<form:hidden path="password"/>
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
					
					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="customerDetails.address" /></td>
					</tr>
					
					<tr>
						<td><label>Birthday:</label></td>
						<td><form:input type="date" path="customerDetails.birthday" /></td>
					</tr>
					
					<tr>
						<td><label>Gender:</label></td>
						<td>
							<form:select path="customerDetails.gender">
								<form:options items="${GenderEnum.values()}" />
							</form:select>
						</td>
					</tr>
					
					<tr>
						<td><label>Profile picture:</label></td>
						<td><input type="file" name="photo"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a class="action-btn" href="${pageContext.request.contextPath}/customer/list">&#8592; Back to List</a>
		</p>
	
	</div>

</body>

</html>










