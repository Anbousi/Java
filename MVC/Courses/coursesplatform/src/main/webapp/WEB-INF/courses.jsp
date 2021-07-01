<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>All Courses</title>
</head>
<body>
    <main class="container">
        <nav>
            <a href="/logout">Logout</a>
            
        </nav>
        <h2>Welcome, <c:out value="${user.name}"/></h2>
        <h3>Courses</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th >Course</th>
                    <th >Instructor</th>
                    <th >Signups</th>
                    <th >Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td><a href='/courses/<c:out value="${course.id}"/>'><c:out value="${course.name}"/></a></td>
                        <td><c:out value="${course.instructor}"/></td>
                        <td>
                            <c:out value="${course.getJoinedUsers().size()}"/>
                            <span>/</span>
                            <c:out value="${course.capacity}"/>
                        </td>
                        
                        <td>
                            <c:choose>
                                <c:when test="${course.getJoinedUsers().size() >= course.capacity}">
                                    Full                             
                                </c:when>

                                <c:otherwise>                                 
                                    <c:if test="${course.getJoinedUsers().contains(user) == false}">
                                        <a href="/courses/add/${course.id}">Add</a>
                                    </c:if>
                                    <c:if test="${course.getJoinedUsers().contains(user) == true}">
                                        Alradey Added
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <br>
        <a href="/courses/new"><button  class="btn btn-primary">Add a course</button></a>
        <br>

</body>
</html>