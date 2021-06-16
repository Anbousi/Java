<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/home.css">
<title>Home Code</title>

</head>
<body>
    <p><c:out value="${error}"/></p>
	<h1>What is the code?</h1>
    <form action="/code" method="post">
        <input type="text" name="try">
        <button type="submit">Try</button>
    </form>
    <p>bushido</p>

</body>
</html>