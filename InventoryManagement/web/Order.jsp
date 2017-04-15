<%-- 
    Document   : Order
    Created on : 15 Apr, 2017, 1:38:56 AM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.Cartitem"%>
<%@page import="InventoryDAO1.Orderitem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Order</title>
        <%@include file="importFiles.jsp" %>  
    </head>
    <body>
         <%@include file="customerHeader.jsp" %>
         <br/>
         <%
             Orderitem[] myorder =(Orderitem[]) request.getAttribute("myorder");
             if(myorder == null){
                 RequestDispatcher rd = request.getRequestDispatcher("Controller?action=order");
                 rd.forward(request, response);
                 myorder =(Orderitem[]) request.getAttribute("myorder");
             }
         %>
             <div class="bottom-sheet waves-red bordered" style="border: 1px solid #000000;">
                <div class="row">
                <div class="col s2 blue-text darken-3">Order Number</div>
                <div class="col s2 blue-text darken-3">Item Description</div>
                <div class="col s2 blue-text darken-3">Item Quantity</div>
                <div class="col s2 blue-text darken-3">Item Rate</div>
                <div class="col s2 blue-text darken-3">Item Total</div>
                <div class="col s1 blue-text darken-3">Order Date</div>
                <div class="col s1 blue-text darken-3">Order Status</div>
            </div>      
                <%
                
                for(Orderitem i : myorder){
                    int total = i.getItem().getOrderqty() * i.getItem().getOrderrate();
                    
                    %>
            <div class="row" style="border: 1px dotted #000000;">
                <div class="col s2 green-text darken-3"><%=i.getOrderno() %></div>
                <div class="col s2 green-text darken-3"><%=i.getItem().getItemdescription() %></div>
                <div class="col s2 green-text darken-3"><%=i.getItem().getOrderqty() %></div>
                <div class="col s2 green-text darken-3"><%=i.getItem().getOrderrate() %></div>
                <div class="col s2 green-text darken-3"><%=total %></div>
                <div class="col s1 green-text darken-3"><%=i.getDate() %></div>
                <div class="col s1 green-text darken-3"><%=i.getStatus() %></div>
            </div>
                <%
                    }
                    %>
             </div>
         <%@include file="customerFooter.jsp" %>
    </body>
</html>
