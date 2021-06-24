<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body>
    <main>
        <a href="/">Home</a>
        <h1>New Person</h1>

        <form:form action="/add_person" method="post" modelAttribute="person">
            <table>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td>
                        <form:errors path="firstName"/>
                        <form:input path="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td>
                        <form:errors path="lastName"/>
                        <form:input path="lastName"/>
                    </td>
                </tr>
            </table>
        
            <button type="submit">Add a New Person</button>
        </form:form>
    </main>

</body>
</html>