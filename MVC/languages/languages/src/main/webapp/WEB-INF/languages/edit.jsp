<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h4>
        <a href='/languages'>Dashboard</a>
        <form:form action="/languages/${language.id}" method="delete" class="f">
            <a><button type="submit">Delete</button></a>
        </form:form> |
    </h4>
    <form:form action='/languages/${language.id}' method="post" modelAttribute="language">
        <input type="hidden" name="_method" value="put">
        <table>
            <tr>
                <td>Name</td>
                <td>
                    <form:input path="name" value='${language.name}'/>
                    <form:errors path="name"/>
                </td>
                <!-- <td><input type="text" name="name" value='<c:out value="${language.name}"/>'></td> -->
            </tr>
            <tr>
                <td>Creator</td>
                    <td>
                        <form:input path="creator" value='${language.creator}'/>
                        <form:errors path="creator"/>
                    </td>
                <!-- <td><input type="text" name="creator" value='<c:out value="${language.creator}"/>'></td> -->
            </tr>
            <tr>
                <td>Version</td>
                <td>
                    <form:input path="version" value='${language.version}'/>
                    <form:errors path="version"/>
                </td>
                <!-- <td><input type="text" name="version" value='<c:out value="${language.version}"/>'></td> -->
            </tr>
        </table>
        
        <button type="submit">Update Language</button>
    </form:form>

</body>
</html>