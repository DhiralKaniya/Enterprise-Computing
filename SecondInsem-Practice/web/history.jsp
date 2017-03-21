<%-- 
    Document   : history.jsp
    Created on : 21 Mar, 2017, 3:35:23 PM
    Author     : dhiral
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        
            ArrayList<Integer> myvalues = (ArrayList<Integer>)request.getSession().getAttribute("History");
            for(Integer i : myvalues){
                %>
                <br><p><%=i%>
                <%
            }
         %>
    </body>
</html>
