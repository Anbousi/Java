<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Person</title>
</head>
<body>
    <a href="/">Home</a>
    <h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
    <h2><c:out value="${person.license.number}"/></h2>
    <h2><c:out value="${person.license.state}"/></h2>
    <h2><c:out value="${date}"/></h2>

</body>
</html>