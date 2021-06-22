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
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
    <h1>All Languages</h1>
    <table>
        <thead>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <c:forEach items="${languages}" var="language">
            <tr>
                <td>
                    <a href='languages/<c:out value="${language.id}"/>'><c:out value="${language.name}"/></a> 
                </td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.version}"/></td>
                <td>
                    <a href='languages/<c:out value="${language.id}"/>/edit'>Edit</a>
                    
                    <form:form action="/languages/${language.id}" method="DELETE" class="f">
                        <button type="submit"><a>Delete</a></button>
                    </form:form>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <form:form action="/languages" method="post" modelAttribute="language">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td>
                    <form:errors path="name"/>
                    <form:input path="name"/>
                </td>

                <!-- <td><input type="text" name="name"></td> -->
            </tr>
            <tr>
                <td><form:label path="creator">Creator</form:label></td>
                <td>
                    <form:errors path="creator"/>
                    <form:input path="creator"/>
                </td>
                <!-- <td><input type="text" name="creator"></td> -->
            </tr>
            <tr>
                <td><form:label path="version">Version</form:label></td>
                <td>
                    <form:errors path="version"/>
                    <form:input path="version"/>
                </td>
                <!-- <td><input type="text" name="version"></td> -->
            </tr>
        </table>
        
        <button type="submit">Add a New Language</button>
    </form:form>




<!--     -->





</body>
</html>