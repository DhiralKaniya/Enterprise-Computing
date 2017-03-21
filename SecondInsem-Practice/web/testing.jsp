<%-- 
    Document   : testing
    Created on : 21 Mar, 2017, 3:17:53 PM
    Author     : dhiral
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
        int a = 10;
        %>
        <%! String str = "Hello"; %>
    </head>
    <body>
        <h1><%=a %></h1>
        <h2><%=str %></h2>
    </body>
</html>
