<%-- 
    Document   : Convertor.jsp
    Created on : 14 Apr, 2017, 11:08:01 AM
    Author     : dhiral
--%>

<%@page import="Modal.Currency"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Currency Convertor</title>
    </head>
    <body>
        <h1>Currency Convertor</h1>
        <%
            
                    String source[] =  (String[])request.getAttribute("source");
                    String destination[] = (String[])request.getAttribute("destination");
                    if(source == null){
                        RequestDispatcher rd = request.getRequestDispatcher("CurrencyController?action=currency");
                        rd.forward(request, response);
                        source =(String[])request.getAttribute("source");
                        destination = (String[])request.getAttribute("destination");
                    }
                %>

                <form action="CurrencyController?action=convert" method="POST">
                    Source Currency 
                    <select name="src"><%
                        for(String s:source){
                            %>
                            <option value="<%= s %>"><%= s %></option>
                            <%
                        }
                        %>
                    </select><br/>
                    Destination Currency 
                    <select name="des"><%
                        for(String s: destination){
                            %>
                            <option value="<%= s %>"><%= s %></option>
                            <%
                        }
                        %>
                    </select>
                    <br/>
                    Enter Your Amount<input required type="number" name="amount"/>
                    <br/>
                    <input type="submit" name="Covnvert" value="Convert"/>
                    <a href="index.jsp"><input type="button" value="Back" />
                </form>
                    
        
    </body>
</html>
