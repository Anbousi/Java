<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<script type="text/javascript" src="js/app.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>

        $(document).ready(function(){

        var scrolldown = document.getElementById('log'); // to keep the scrolldown
        scrolldown.scrollTop = scrolldown.scrollHeight;
            }
        });
    </script>

    <title>Hidden Inputs</title>
</head>
<body>
    <main>
        <header>
            <label for="gold" class="gold">Your Gold:
                <p id="gold"><c:out value="${total}"/></p>
            </label>
        </header>
        <section>
            <div class="box">
                <h2>Farm</h2>
                <p>earns 10-20 golds</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="money" value="farm_gold">
                    <button type="submit">Find Gold</button>
                </form>
            </div>

            <div class="box">
                <h2>Cave</h2>
                <p>earns 5-10 golds</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="money" value="cave_gold">
                    <button type="submit">Find Gold</button>
                </form>
            </div>

            <div class="box">
                <h2>House</h2>
                <p>earns 2-5 golds</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="money" value="house_gold">
                    <button type="submit">Find Gold</button>
                </form>
            </div>

            <div class="box">
                <h2>Casino</h2>
                <p>earns/takes 0-50 golds</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="money" value="casino_gold">
                    <button type="submit">Find Gold</button>
                </form>
            </div>
        </section>

        <div id="log"> <!-- to print the log session array and check the '-' minus value -->
        
        <c:forEach items="${activ}" var="item">
        		  
        
        <c:choose>
		    <c:when test="${item.contains('-')}">
		        <p style="color: red;"><c:out value="${item}"/></p>
		    </c:when>
		    <c:otherwise>
		        <p><c:out value="${item}"/></p>
		    </c:otherwise>
		</c:choose>
        
        
               
		</c:forEach>
        

        </div>
        <form action="/reset">
            <button type="submit" class="reset" >Reset</button>
        </form>
    </main>
</body>
</html>