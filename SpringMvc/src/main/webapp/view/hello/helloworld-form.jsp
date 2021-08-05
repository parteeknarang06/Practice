<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Hello World - Input Form</title>
	</head>

	<body>
		<h2>Form Version 1</h2>
		<form action="${pageContext.request.contextPath}/helloworld/processForm" method="POST">
			<input type="text" name="studentName" placeholder="What's your name?" />
			<input type="text" name="qualification" placeholder="What's your qualification?" />
			<input type="submit" />
		</form>
		<h2>Form Version 2</h2>
		<form action="<c:url value="/helloworld/processFormTwo"/>" method="POST">
			<input type="text" name="studentName" placeholder="What's your name?" />
			<input type="text" name="qualification" placeholder="What's your qualification?" />
			<input type="submit" />
		</form>
		<h2>Form Version 3</h2>
		<form action="<c:url value="/helloworld/processFormThree"/>" method="POST">
			<input type="text" name="studentName" placeholder="What's your name?" />
			<input type="text" name="qualification" placeholder="What's your qualification?" />
			<input type="submit" />
		</form>
	</body>

</html>


