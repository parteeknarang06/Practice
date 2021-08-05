<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<h2>Spring MVC Demo - Home Page</h2>
		<hr>
		<a href="${pageContext.request.contextPath}/helloworld/showForm">Hello World form</a>
		<br>
		<a href="<c:url value="/student/showForm" />">Student form</a>
		<br>
		<a href="<c:url value="/customer/showForm" />">Customer form</a>
	</body>
</html>