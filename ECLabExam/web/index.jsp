<%-- 
    Document   : index.jsp
    Created on : 14 Apr, 2017, 10:30:24 AM
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
        <%
            Currency[] mcurr;
            mcurr=(Currency[])request.getAttribute("mycurr");
            if(mcurr == null){
                RequestDispatcher rd = request.getRequestDispatcher("CurrencyController?action=view");
                rd.forward(request, response);
                mcurr=(Currency[])request.getAttribute("mycurr");
            }
            
            %>
    <center><h1>Current Currency Rate</h1></center>
            <table width="100%" border="1">
                <thead><tr><th>Source Country</th><th>Destination Country</th><th>Currency Rate</th></tr></thead>
                <tbody>
                <%
                for(Currency c : mcurr){
                    %>
                    <tr>
                        <td><%=c.getSourcecurrency()%></td>
                        <td><%=c.getDestinationcurrency() %></td>
                        <td><%=c.getCurrencyrate() %></td>
                    </tr>
                    <%
                }
                %>
                </tbody>
            </table>
            <%
         %>
    <a href="cnvrt.jsp">Currency Convertor</a>
    <br/>
    <a href="newCurrency.jsp">Add new</a>
    </body>
</html>
