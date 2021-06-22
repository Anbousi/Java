<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h4><a href='/languages'>Dashboard</a></h4>
    <hr>
    <h3><c:out value="${language.name}"/></h3>
    <h3><c:out value="${language.creator}"/></h3>
    <h3><c:out value="${language.version}"/></h3>

    <br><br><br>
    <hr>

    <a href='/languages/<c:out value="${language.id}"/>/edit'>Edit</a>

    <form:form action="/languages/${language.id}" method="delete" class="f">
        <a><button type="submit">Delete</button></a>
    </form:form> |



</body>
</html>