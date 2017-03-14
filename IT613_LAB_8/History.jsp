<%-- 
    Document   : History.jsp
    Created on : 9 Mar, 2017, 5:51:30 PM
    Author     : dhiral
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>History Of Word</h1>
        
        <%
            HttpSession userHistory = request.getSession();
            ArrayList<String> History =(ArrayList<String>) userHistory.getAttribute("history");
            Iterator i = History.iterator();
            PrintWriter pr = response.getWriter();
            while(i.hasNext())
            {
                
                String str = (String)i.next();
                pr.println("<h3>"+str+"</h3>");
            }
        %>
        <a href="findWord.html">Click here to Back</a>
    </body>
</html>
