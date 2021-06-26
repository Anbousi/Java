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
<title><c:out value="${product.name}"/></title>
</head>
<body>
    <main>
        <a href="/">Home</a>
        <h1><c:out value="${product.name}"/></h1>
        <h2><c:out value="${product.description}"/></h2>
        <section class="flex1">
            <div>
                <table>
                    <thead>
                            <td><h3>Categories:</h3></td>
                    </thead>
                    <c:forEach var="category" items="${product.categories}">
                        
                    <tr>
                        <td>${category.name}</td>
                        <td><a href="/products/${product.id}/delete/${category.id}">Delete</a></td>
                    </tr>
                    </c:forEach>	
                </table>
            </div>
            <div>
                <form:form action="/products/${product.id}" method="post" modelAttribute="categories">
                    <select name="categories">
                        <option value="0" hidden></option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}">${category.name}</option>			
                        </c:forEach>
                    </select>
                    <button type="submit">Add</button>
                </form:form>
            </div>
        </section>
    </main>

</body>
</html>