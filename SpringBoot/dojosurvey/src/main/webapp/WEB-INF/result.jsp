<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/home.css">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>User Info.</title>
    </head>
    <body>
        <main>
            <h3>Submitted Info</h3>
            <form action="/" class="form-group">
                <table class="table">
                    <tr>
                        <td>Name:</td>
                        <td><c:out value="${name}"/></td>
                    </tr>
                    <tr>
                        <td>Dojo Location:</td>
                        <td><c:out value="${location}"/></td>
                    </tr>
                    <tr>
                        <td>Favorite Language:</td>
                        <td><c:out value="${language}"/></td>
                    </tr>
                    <tr>
                        <td>Comment:</td>
                        <td><c:out value="${comment}"/></td>
                    </tr>
                </table>
                <input type="submit" value="Go Back" id="submit" class="btn btn-dark">
            </form>
        </main>
        
    </body>
    </html>