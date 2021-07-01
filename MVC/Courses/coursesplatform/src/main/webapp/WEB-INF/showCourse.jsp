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
<title><c:out value="${course.name}"/></title>
<style>
    .width50{
        width: 50%;
    }
</style>
</head>
<body>
    <main class="container">
        <nav>
            <a href="/logout">Logout</a>
            <a href="/courses">Courses</a>
        </nav>

        <h1><c:out value="${course.name}"/></h1>
        <table class="table table-striped width50">
            <tr>
                <td>Instructor:</td>
                <td><c:out value="${course.instructor}"/></td>
            </tr>
            <tr>
                <td>Sing Ups:</td>
                <td><c:out value="${course.getJoinedUsers().size()}"/></td>
            </tr>
        </table>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Sign Up date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${course.getJoinedUsers()}" var="user">
                    <tr>
                        <td><c:out value="${user.name}"/></a></td>
                        <td><c:out value="${user.createdAt}"/></a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="/courses/${course.id}/edit"><button  class="btn btn-primary">Edit</button></a>
        <a href="/courses/${course.id}/delete"><button  class="btn btn-primary">Delete</button></a>
        
    </main>

</body>
</html>