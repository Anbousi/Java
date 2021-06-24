<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>People and Licenses</title>
</head>
<body>
	<a href="/">Home</a>
	<h1>Information</h1>
	<table>
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>License #</th>
			<th>State</th>
			<th>Expiration Date</th>
		</thead>
		<tbody>
			<c:forEach var="person" items="${persons}">
			<tr>
				
				<td><a href="/persons/${person.id}">${person.firstName}</a></td>
				<td>${person.lastName}</td>
				<td>${person.license.number}</td>
				<td>${person.license.state}</td>

				<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
				<td><fmt:formatDate value="${person.license.expirationDate}" pattern="yyyy-MM-dd" /> </td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>