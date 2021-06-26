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
				<td>Description</td>
				<td>Price</td>
				<td>Action</td>
		</thead>
		<c:forEach var="product" items="${products}">
			
		<tr>
			<td><a href="/products/${product.id}"> ${product.name}</a></td>
			<td>${product.description}</td>
			<td>${product.price}</td>
			<td><a href="/products/delete/${product.id}">Delete</a></td>
		</tr>
		</c:forEach>	
	</table>

</body>
</html>