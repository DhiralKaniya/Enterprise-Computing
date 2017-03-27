<%-- 
    Document   : Order_view
    Created on : 27 Mar, 2017, 12:08:42 PM
    Author     : dhiral
--%>

<%@page import="Item.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>My Cart Details!</h1>
        
        <%
            try{
                ShoppingCart mycart =(ShoppingCart) request.getAttribute("mycart");
                int[] myitem = mycart.getItemCodes();
                int[] myqty = mycart.getQty();
                for(int i = 0 ;i<myitem.length;i++){
                    %>
                    <a><%=myitem[i]%></a>-><a><%=myqty[i]%></a><br>
                    <%
                }
                %>
                <h3>Total Current Billing Amount is <%= mycart.getOrderAmoubt() %>  </h3>
                <%
            }catch(NullPointerException e){
                response.getWriter().println(e.getMessage());
            }
            
            
        %>
        
    </body>
</html>
