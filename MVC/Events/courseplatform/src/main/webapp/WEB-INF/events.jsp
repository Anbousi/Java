<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
    <main>
        <nav>
            <a href="/logout">Logout</a>
        </nav>
        <h2>Welcome, <c:out value="${user.firstname}"/></h2>
        <p>Here are some of the events in your state</p>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action / Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${events}" var="event">
                    <tr>
                        <td><c:out value="${event.name}"/></td>
                        <td><c:out value="${event.date}"/></td>
                        <td><c:out value="${event.location}"/></td>
                        <td><c:out value="${event.user.firstname}"/></td>
                        <td>
                            <c:choose>
         
                                <c:when test = "${event.user.id == user.id}">
                                   <a href="/delete">Delete</a>
                                   <a href="/edit">Edit</a>                               
                                </c:when>


                                <c:otherwise>
                                    
                                    
                                    
                                        <c:if test="${user.getJoinedEvents().contains(event) == false}">
                                            <a href="/events/join/${event.id}">Join</a>
                                        </c:if>
                                        <c:if test="${user.getJoinedEvents().contains(event) == true}">
                                            <span> Joined </span>
                                            <a href="/events/cancel/${event.id}">Cancel</a>
                                        </c:if>
                                   
                                   
                                   <!-- <a href="/events/join/${event.id}">Join</a>
                                   <a href="/events/cancel/${event.id}">Cancel</a> -->
                                </c:otherwise>
                             </c:choose>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <br>
        <form:form action="/events" method="post" modelAttribute="event">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td>
                    <form:input path="name"/>
                    <form:errors path="name"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="date">Date</form:label></td>
                <td>
                    <form:input path="date" type="date"/>
                    <form:errors path="date"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="location">Location</form:label></td>
                <td>
                    <form:input path="location"/>
                    <form:errors path="location"/>
                    <form:select  path="state">
                        <c:forEach items="${states}" var="stat">
                            <form:option value="${stat.id}">${stat.name}</form:option>
                        </c:forEach>       
                    </form:select>
                </td>
            </tr>
        </table>
        
        <button type="submit">Add Event</button>
        </form:form>
        <p><c:out value="${er}"/></p>
    </main>

</body>
</html>