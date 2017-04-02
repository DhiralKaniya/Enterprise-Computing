<%-- 
    Document   : view
    Created on : 31 Mar, 2017, 7:39:09 PM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.InventoryCategory"%>
<%@page import="UserDefineException1.DAOException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            InventoryCategory[] mycategory = (InventoryCategory[])request.getAttribute("mycategory");
            for(InventoryCategory ic : mycategory){
                %>
                <p><%=ic.getCategoryName() %></p>
                <%
            }
        %>
        
    </body>
</html>
