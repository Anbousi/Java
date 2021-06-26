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
    <h1>All Products</h1>

    <table>
		<thead>
				<td>Name</td>
		</thead>
		<c:forEach var="category" items="${categories}">
			
		<tr>
			<td><a href="/categories/${category.id}"> ${category.name}</a></td>
			<td><a href="/categories/delete/${category.id}">Delete</a></td>
		</tr>
		</c:forEach>	
	</table>

</body>
</html>