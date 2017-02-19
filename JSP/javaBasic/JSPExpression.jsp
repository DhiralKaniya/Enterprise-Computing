<%-- 
    Document   : JSPExpression.jsp
    Created on : 19 Feb, 2017, 6:24:13 PM
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
        <!-- String expression -->
        <%= new String("Hello World").toUpperCase() %>
        <br/>
        <!-- Mathematical Expression -->
        <%= 25*4 %>
        <!-- Boolean Expression -->
        <%= 25 < 30 %>
    </body> 
</html>
