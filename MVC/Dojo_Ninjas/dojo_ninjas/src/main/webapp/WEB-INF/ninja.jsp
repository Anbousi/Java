<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ninja</title>
</head>
<body>
    <main>
        <a href="/">Home</a>
        <h1>Add Ninja</h1>

        <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
            <table>
                <tr>
                    <td><form:label path="dojo">Dojo</form:label></td>
                    <td>
                        <form:errors path="dojo"/>
                        <select name="dojo">
                            <c:forEach var="dojo" items="${dojos}">
                                <option value="${dojo.id}">${dojo.name}</option>			
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td>
                        <form:input path="firstName"/>
                        <form:errors path="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td>
                        <form:input path="lastName"/>
                        <form:errors path="lastName"/>
                    </td>
                </tr>
               
                <tr>
                    <td><form:label path="age">Age</form:label></td>
                    <td>
                        <form:input path="age"/>
                        <form:errors path="age"/>
                    </td>
                </tr>
            </table>
            <button type="submit">Create</button>
        </form:form>
    </main>
</body>
</html>