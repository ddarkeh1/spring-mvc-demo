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
	
	Free passes: <form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error" />
	
	<br><br>
	
	Post code: <form:input path="postCode"/>
	<form:errors path="postCode" cssClass="error" />
	
	<br><br>
	
	Course code: <form:input path="courseCode"/>
	<form:errors path="courseCode" cssClass="error" />
	
	<input type="submit" value="Submit" />
	
	</form:form>

	<br><br>
	
	<p>Validation Test page done server side <br/>
	1. includes a preprocesser to trim whitespace if String.class is passed</p>
	<p>2. Includes min and max validation on free passes</p>
	<p>3. Post code is a simple regex validation</p>
	<p>4. Course Code uses custom validation, with custom annotation of @CourseCode</p>

</body>


</html>