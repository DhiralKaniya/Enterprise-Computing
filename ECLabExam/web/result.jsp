<%-- 
    Document   : result
    Created on : 14 Apr, 2017, 11:37:30 AM
    Author     : dhiral
--%>

<%@page import="Modal.Currency"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Converted Amount</title>
    </head>
    <body>
        <%
            Currency cur = (Currency)request.getAttribute("currc");
            if(cur!=null){
                 
            String amount = (String)request.getAttribute("amount");
            String total = (String)request.getAttribute("total");
                %>
                <h2>Source Currency :- <%=cur.getSourcecurrency() %></h2>
                <h2>Destination Currency :- <%=cur.getDestinationcurrency() %></h2>
                <h2>Target Amount :- <%=cur.getCurrencyrate() %></h2>
                <h2>Source Currency :- <%=cur.getSourcecurrency() %></h2>
                <h2>Amount you have Enter :- <%=amount %></h2>
                <h2>Converted Amount :- <%=total %></h2>
                <%
            }
             
            %>
            <a href="index.jsp">Home</a>
            <a href="cnvrt.jsp">Convertor</a>
    </body>
</html>
