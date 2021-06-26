<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
    <main>
        <a href="/">Home</a>
        <h1>New category</h1>

        <form:form action="/catigories/new" method="post" modelAttribute="category">
            <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td>
                        <form:input path="name"/>
                        <form:errors path="name"/>
                    </td>
            <button type="submit">Create</button>
        </form:form>

    </main>

</body>
</html>