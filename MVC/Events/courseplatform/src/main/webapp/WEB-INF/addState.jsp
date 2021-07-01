<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a State</title>
</head>
<body>
    <main>
        <a href="/">Home</a><br>
        <form:form action="/addstates" method="post" modelAttribute="state">
        <table>
            <tr>
                <td><form:label path="name">State Name</form:label></td>
                <td>
                    <form:input path="name"/>
                    <form:errors path="name"/>
                </td>
            </tr>
        </table>

        <button type="submit">Add</button>
        </form:form>
        <c:out value="${error}"/>
    </main>
</body>
</html>