<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
    <a href="/">Home</a>
    <h1>New License</h1>
    <form:form action="/add_license" method="post" modelAttribute="license">
            <table>
                <tr>
                    <td><form:label path="person">Person</form:label></td>
                    <td>
                        <form:errors path="person"/>
                        <select name="person">

                            <c:forEach items="${persons}" var="per">
                                    <c:if test = "${per.license == Null}">
                                        <option value="${per.id}">
                                            ${per.firstName}
                                          </option>
                                    </c:if>
                            </c:forEach>
                          </select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="state">State</form:label></td>
                    <td>
                        <form:errors path="state"/>
                        <form:input path="state"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="expirationDate">Expiration Date</form:label></td>
                    <td>
                        <form:errors path="expirationDate"/>
                        <form:input type="Date" path="expirationDate"/>
                    </td>
                </tr>
            </table>
        
            <button type="submit">Create License</button>
        </form:form>

</body>
</html>