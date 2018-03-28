<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>


<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName }

<br><br>

Free passes: ${customer.freePasses}

<br><br>

Post Code: ${customer.postCode}

<br><br>

Course Code: ${customer.courseCode}

</body>

</html>