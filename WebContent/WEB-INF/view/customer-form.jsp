<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>Customer Registration Form</title>

	<style>
		.error {color:red}
	</style>


</head>

<body>

<i>Fill out the form. Asterisk (*) means required.</i>


	<form:form action="processForm" modelAttribute="customer">
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
	Last name (*): <form:input path="lastName" />
	<form:errors path="lastName" cssClass="error" />
	
	<br><br>
	
	<input type="submit" value="Submit" />
	
	</form:form>

	<br><br>
	
	Validation Test page done server side
	1. includes a preprocesser to trim whitespace if String.class is passed

</body>


</html>