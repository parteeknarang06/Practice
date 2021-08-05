<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	<body>
		<form:form action="${pageContext.request.contextPath}/student/processForm" modelAttribute="student" method="POST">
			First name: <form:input path="firstName" />
			<br><br>
			Last name: <form:input path="lastName" />
			<br><br>
			Country:
			<form:select path="country" >
				<form:options items="${theCountryOptions}"/>
			</form:select>
			<br><br>
			Favourite Language:
			<form:radiobuttons items="${proprogrammingLanguages}" path="favouriteLanguage" />
			<br><br>
			Operating Systems:
			<form:checkboxes items="${operatingSystems}" path="operatingSystems" />
			<br><br>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>












