<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/home.css">
<meta charset="ISO-8859-1">
<title>Login Registration</title>
</head>
<body>
    <main>
        <h2>Welcome</h2>
        <div class="flex1">
            <div>
                <h3>Register</h3>
                
                <form:form action="/" method="post" modelAttribute="user" class="border">
                <input type="hidden" value="register" name="check">
                <table>
                    <tr>
                        <td><form:label path="firstname">First Name</form:label></td>
                        <td>
                            <form:input path="firstname"/>
                            <!-- <form:errors path="firstname"/> -->
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="lastname">Last Name</form:label></td>
                        <td>
                            <form:input path="lastname"/>
                            <!-- <form:errors path="lastname"/> -->
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="email">Email</form:label></td>
                        <td>
                            <form:input path="email" type="email" />
                            <!-- <form:errors path="email"/> -->
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="location">Location</form:label></td>
                        <td>
                            <form:input path="location"/>
                            <!-- <form:errors path="location"/> -->

                            <form:select  path="state">
                                <c:forEach items="${states}" var="stat">
                                    <form:option value="${stat.id}">${stat.name}</form:option>
                                </c:forEach>            
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="password">Password</form:label></td>
                        <td>
                            <form:input path="password" type="password" />
                            <!-- <form:errors path="password"/> -->
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="passwordConfirmation">PW Confirmation</form:label></td>
                        <td>
                            <form:input path="passwordConfirmation" type="password" />
                            <!-- <form:errors path="passwordConfirmation"/> -->
                        </td>
                    </tr>
                </table>
                <button type="submit">Register</button>
            </form:form>

            <c:if test="${Error1 == null}">
                <p><form:errors path="user.*"/></p>
                <p><c:out value="${Error}"/></p>
            </c:if>

            </div>
            <div>
                <h3>Login</h3>
                
                <form action="/" method="post" class="border">
                    <input type="hidden" value="login" name="check">
                    <table>
                        <tr>
                            <td><label for="Email">Email</label></td>
                            <td><input type="email" id="Email" name="email"></td>
                        </tr>
                        <tr>
                            <td><label for="pass">Password</label></td>
                            <td><input type="password" id="pass" name="password"></td>
                        </tr>
                    </table>
                    <button type="submit">Login</button>
                </form>
                <c:out value="${Error1}"/>
            </div>
        </div>

    </main>
</body>
</html>