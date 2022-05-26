<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.tanja.web_customer_tracker.model.customer.GenderEnum" %>

<!DOCTYPE html>
<html>

<head>
	<title>Register</title>

	<!-- Bootstrap -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div>
		
		<div style="margin-top: 20px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			<div id="container">
				<div class="panel-heading">
					<div class="panel-title">Sign Up</div>
				</div>
				<div style="padding-top: 10px" class="panel-body">
				<form:form action="${pageContext.request.contextPath}/addCustomer" modelAttribute="customer" method="POST" enctype="multipart/form-data" class="form-horizontal">
					<form:hidden path="id" />
					<form:hidden path="customerDetails.id" />

						<div style="margin-bottom: 10px" class="input-group">
							<label>First name:</label>
							<form:input path="firstName" class="form-control" />
						</div>
						<div style="margin-bottom: 10px" class="input-group">
							<label>Last name:</label>
							<form:input path="lastName" class="form-control" />
						</div>
		
						<div style="margin-bottom: 10px" class="input-group">
							<label>Email:</label>
							<form:input type="email" path="email" class="form-control" />
						</div>
						<div style="margin-bottom: 10px" class="input-group">
							<label>Password:</label>
							<form:input type="password" path="password" class="form-control" />
						</div>
						<div style="margin-bottom: 10px" class="input-group">
								<label>Address:</label>
								<form:input path="customerDetails.address" class="form-control" />
						</div>
						<div style="margin-bottom: 10px" class="input-group">
							<label>Birthday:</label>
							<form:input type="date" path="customerDetails.birthday" class="form-control" />
						</div>
						<div style="margin-bottom: 10px" class="input-group">
							<label>Gender:</label>
							<form:select path="customerDetails.gender" class="form-control">
								<form:options items="${GenderEnum.values()}" />
							</form:select>
						</div>
						<div style="margin-bottom: 10px" class="input-group">
							<label>Profile picture:</label>
							<input type="file" name="photo" class="form-control"/>
						</div>
						
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<input type="submit" class="btn btn-success" value="Register" />
							</div>
						</div>

				</form:form>
			</div>
			</div>
		</div>
	</div>

</body>

</html>










