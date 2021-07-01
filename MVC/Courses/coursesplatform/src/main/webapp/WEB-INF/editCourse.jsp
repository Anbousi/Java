<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Add a Course</title>
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

        <h1>Create a new course</h1>



        <form:form action='/courses/${course.id}/edit' method="post" modelAttribute="course">
        <table class="table table-striped width50">
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td>
                    <form:input path="name" value='${course.name}' />
                    <form:errors path="name"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="instructor">Instructor</form:label></td>
                <td>
                    <form:input path="instructor" value='${course.instructor}'/>
                    <form:errors path="instructor"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="capacity">Capacity</form:label></td>
                <td>
                    <form:input path="capacity" placeholder="Number of capacity" value='${course.capacity}'/>
                    <form:errors path="capacity"/>
                </td>
            </tr>

        </table>
        
        <button type="submit" class="btn btn-primary">Update</button>
        </form:form>


    </main>

</body>
</html>