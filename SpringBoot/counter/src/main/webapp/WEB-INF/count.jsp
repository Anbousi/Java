<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Count Page</title>
</head>
<body>

	<h2>You have visited  <a href="http://localhost:8080/">http://localhost:8080/ </a><c:out value="${count} times"/> </h2>
    <h2><a href="http://localhost:8080/">Test another visit? </a></h2>


	<h1></h1>

</body>
</html>