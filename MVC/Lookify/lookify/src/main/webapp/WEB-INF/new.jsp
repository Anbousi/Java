<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/new.css">
<title>Create a New Lookify</title>
</head>
<body>
    <main>
        <header>
            <a href="/dashboard">Dashboard</a>
        </header>

        <form:form action="/songs/new" method="post" modelAttribute="lookify">
            <table>
                <tr>
                    <td><form:label path="title">Title</form:label></td>
                    <td>
                        <form:input path="title"/>
                        <form:errors path="title"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="artist">Artist</form:label></td>
                    <td>
                        <form:input path="artist"/>
                        <form:errors path="artist"/>
                    </td>                    
                </tr>
                <tr>
                    <td><form:label path="rate" >Rating (1-10)</form:label></td>
                    <td>
                        <form:input path="rate" type="number" min="1" max="10"/>
                        <form:errors path="rate"/>
                    </td>                    
                </tr>
            </table>

            <button type="submit">Add Song</button>

        </form:form>

    </main>

</body>
</html>