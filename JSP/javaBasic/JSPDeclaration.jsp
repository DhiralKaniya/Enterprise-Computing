<%-- 
    Document   : JSPDeclaration.jsp
    Created on : 19 Feb, 2017, 6:36:55 PM
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
        <h1>Hello World!</h1>
        <%!
            String helloworld(){
                return "Hello World";
            }
        %>
        <%= helloworld() %>
    </body>
</html>
