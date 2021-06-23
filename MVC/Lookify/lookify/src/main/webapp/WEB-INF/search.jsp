<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/show.css">
<title>Search</title>
</head>
<body>
<main>
        <header>
            <div>
            <a href="/dashboard" class="first_a">Dashboard</a>
                <a href="/songs/new" class="first_a">Add New</a>
                <a href="/search/topTen">Top Songs</a>
            </div>
            <div>
                <form action="/search/" method="POST">
                    <input type="text" placeholder="Serach" name="artist" required>
                    <button type="submit" required><a>Search</a></button>
                </form>
            </div>
        </header>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Rating</th>
                    <th>Action</th>
                </tr>
                    <c:forEach items="${lookifies}" var="lookify">
                        <tr>
                            <td><a href='/songs/<c:out value="${lookify.id}"/>'><c:out value="${lookify.artist}"/></a></td>
                            <td><c:out value="${lookify.rate}"/></td>
                            <td><a href='/dashboard/delete/<c:out value="${lookify.id}"/>'>Delete</a></td>
                        </tr>
                    </c:forEach>
            </thead>
        </table>  

    </main>

</body>
</html>