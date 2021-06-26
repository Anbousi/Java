<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/prod_categ.css">
<meta charset="ISO-8859-1">
<title><c:out value="${category.name}"/></title>
</head>
<body>
    <main>
        <a href="/">Home</a>
        <h1><c:out value="${category.name}"/></h1>
        <section class="flex1">
            <div>
                <table>
                    <thead>
                            <td><h3>Products:</h3></td>
                    </thead>
                    <c:forEach var="product" items="${category.products}">
                        
                    <tr>
                        <td><a href="/products/${product.id}">${product.name}</a></td>
                        <td><a href="/categories/${category.id}/delete/${product.id}">Delete</a></td>
                    </tr>
                    </c:forEach>	
                </table>
            </div>
            <div>
                <form:form action="/categories/${category.id}" method="post" modelAttribute="products">
                    <select name="products">
                        <option value="0" hidden></option>
                        <c:forEach var="product" items="${products}">
                            <option value="${product.id}">${product.name}</option>			
                        </c:forEach>
                    </select>
                    <button type="submit">Add</button>
                </form:form>
            </div>
        </section>
    </main>

</body>
</html>