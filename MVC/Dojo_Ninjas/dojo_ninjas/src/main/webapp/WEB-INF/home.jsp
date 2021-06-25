<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
    <main>
        <h1>Welcome</h1>
        <a href="/dojos/new">Add Dojo</a><br>
        <a href="/ninjas/new">Add Ninja</a><br>
        <hr>
        <table>
            <thead>
                <th>Dojo Name</th>
            </thead>
            <tbody>
                <c:forEach var="dojo" items="${dojos}">
                <tr>  
                    <td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
                    		
                    <td><a href="/dojos/delete/${dojo.id}">Delete</a></td>
                    <c:forEach var="ninja" items="${dojo.ninjas}">
                        <tr>
                            <td>${ninja.firstName} ${ninja.lastName}</td>
                            
                        </tr>
                    </c:forEach>		
                </tr>
                
                </c:forEach>
            </tbody>
        </table>

    </main>

</body>
</html>