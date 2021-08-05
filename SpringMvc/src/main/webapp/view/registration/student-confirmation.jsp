<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Student Confirmation</title>
	</head>
	<body>
		<p>
		${proprogrammingLanguages}
			The student is confirmed: <br><br> ${student.firstName} <br><br>${student.lastName}
			<br><br>
			Country: ${student.country}
			<br><br>
			Favourite Language: ${student.favouriteLanguage}
			<br><br>
			Operating Systems:
			<ul>
			<c:forEach items="${student.operatingSystems}" var="os">
				<li>${os}</li>
			</c:forEach>
			</ul> 
		</p>
	</body>

</html>







