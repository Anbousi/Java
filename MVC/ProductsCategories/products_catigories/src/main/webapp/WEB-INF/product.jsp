<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
    <main>
        <a href="/">Home</a>
        <h1>New Product</h1>

        <form:form action="/products/new" method="post" modelAttribute="product">
            <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td>
                        <form:errors path="name"/>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td>
                        <form:errors path="description"/>
                        <form:input path="description"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="price">Price</form:label></td>
                    <td>
                        <form:errors path="price"/>
                        <form:input path="price"/>
                    </td>
                </tr>
            </table>
            
            <button type="submit">Create</button>
        </form:form>

    </main>

</body>
</html>