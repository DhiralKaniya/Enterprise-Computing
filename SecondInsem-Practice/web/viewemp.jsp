<%-- 
    Document   : viewemp
    Created on : 21 Mar, 2017, 4:02:35 PM
    Author     : dhiral
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Testing.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Employee> myemp =(ArrayList<Employee>) request.getAttribute("myemp");
            for(Employee e: myemp){
                %>
                <br><p><%= e.getEmpname() %></p>
                <br><p><%= e.getEmpsalary()%></p>
                <%
            }
        %>
    </body>
</html>
