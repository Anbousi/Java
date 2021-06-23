<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/home.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/show.css">
<title>Song Info</title>
</head>
<body>
    <main>
        <header>
            <a href="/dashboard">Dashboard</a>
        </header>
        <table>
            <tr>
                <td>Title</td>
                <td><c:out value="${lookify.title}"/></td>
            </tr>
            <tr>
                <td>Artist</td>
                <td><c:out value="${lookify.artist}"/></td>                    
            </tr>
            <tr>
                <td>Rating (1-10)</td>
                <td><c:out value="${lookify.rate}"/></td>                    
            </tr>
        </table>

        <a href='/dashboard/delete/<c:out value="${lookify.id}"/>'>Delete</a>
    </main>

</body>
</html>