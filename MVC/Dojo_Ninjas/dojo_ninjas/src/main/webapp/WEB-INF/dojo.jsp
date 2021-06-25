<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Dojo</title>
</head>
<body>
    <main>
        <a href="/">Home</a>
        <h1>Add Dojo</h1>
        <form:form action="/dojos/new" method="post" modelAttribute="dojo">

            <form:label path="name">Name</form:label></td>
            <form:errors path="name"/>
            <form:input path="name"/>

        <button type="submit">Create</button>
</form:form>
    </main>
</body>
</html>