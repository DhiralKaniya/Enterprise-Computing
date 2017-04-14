<%-- 
    Document   : newCurrency
    Created on : 14 Apr, 2017, 10:57:29 AM
    Author     : dhiral
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add New Currency</h1>
        <form action="CurrencyController?action=insert" method="POST">
            Source Currency :- <input type="text" required name="scurr"><br/>
            Destination Currency :- <input type="text" required name="dcurr"><br/>
            Currency Rate :- <input type="number" required name="rate"><br/>
            <input type="submit" name="Add New Currency">
        </form>
    </body>
</html>
