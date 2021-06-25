<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/">Home</a>
	<h1><c:out value="${dojo.name}"/></h1>
	<table>
		<thead>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
				<td>Action</td>
		</thead>
		<c:forEach var="ninja" items="${dojo.ninjas}">
			
		<tr>
			<td>${ninja.firstName}</td>
			<td>${ninja.lastName}</td>
			<td>${ninja.age}</td>
			<td><a href="/ninjas/delete/${ninja.id}">Delete</a></td>
		</tr>
		</c:forEach>	
	</table>		

</body>
</html>