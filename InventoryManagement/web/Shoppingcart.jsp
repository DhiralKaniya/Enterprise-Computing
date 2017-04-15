<%-- 
    Document   : Shoppingcart
    Created on : 14 Apr, 2017, 7:35:04 PM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.Cartitem"%>
<%@page import="InventoryDAO1.Shoppingcart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <%@include file="importFiles.jsp" %>  
    </head>
    <body>
        <%@include file="customerHeader.jsp" %>
            <center><h4>My Shopping Cart</h4>
            <%
                Shoppingcart mycart = (Shoppingcart) request.getAttribute("mycart");
                request.getSession().setAttribute("mycart1", mycart);
                String mstatus = (String)request.getAttribute("mstatus");
                if(mycart == null && (mstatus == null || mstatus.compareTo("true")==0)){
                    RequestDispatcher rd = request.getRequestDispatcher("Controller?action=viewcart");
                    rd.include(request, response);
                    mycart = (Shoppingcart) request.getAttribute("mycart");
                    request.getSession().setAttribute("mycart1", mycart);
                }
                
                System.out.println(mstatus);
                if(mstatus.compareTo("false")==0){%>
                    <div class="row">
                <div class="col s12 red-text darken-3">Cart is Empty</div><%
                }else{
                %>
                <form action="Controller?action=placeall" method="post">
            <div class="bottom-sheet waves-red bordered" style="border: 1px solid #000000;">
                <div class="row">
                <div class="col s2 blue-text darken-3">Item Code</div>
                <div class="col s2 blue-text darken-3">Item Description</div>
                <div class="col s2 blue-text darken-3">Item Quantity</div>
                <div class="col s2 blue-text darken-3">Item Rate</div>
                <div class="col s2 blue-text darken-3">Item Total</div>
                <div class="col s1 blue-text darken-3">Item Place</div>
                <div class="col s1 blue-text darken-3">Item Remove</div>
            </div>      
                <%
                int total = 0;
                for(Cartitem i : mycart.getAllCartItem()){
                    total+= i.getOrderqty()*i.getOrderrate();
                    int t = i.getOrderqty()*i.getOrderrate();
                    %>
            <div class="row" style="border: 1px dotted #000000;">
                <div class="col s2 green-text darken-3"><%=i.getItemcode() %></div>
                <div class="col s2 green-text darken-3"><%=i.getItemdescription() %></div>
                <div class="col s2 green-text darken-3"><%=i.getOrderqty() %></div>
                <div class="col s2 green-text darken-3"><%=i.getOrderrate() %></div>
                <div class="col s2 green-text darken-3"><%=t %></div>
                <div class="col s1" style="float : right">
                    <a href="Controller?action=removecart&ic=<%=i.getItemcode() %>&cartno=<%=mycart.getCarno() %>"><input type="button" value="Remove"></a>
                </div>
                <div class="col s1" style="float : right">
                    <a href="Controller?action=place&ic=<%=i.getItemcode() %>&qty=<%=i.getOrderqty() %>&rate=<%=i.getOrderrate() %>&cartno=<%=mycart.getCarno() %>"><input type="button" value="Place"></a>
                </div>
            </div>
                        
                    <%
                }
                
            %>
            <div class="row">
                <div class="col s4"></div>
                <div class="col s4 red-text darken-4">Total</div>
                <div class="col s2 red-text darken-3"><%=total %></div>
                <div class="col s2 blue-text darken-3"></div>
            </div>
            </div>
                
            <div class="row">
                <div class="col s8"></div>
                <div class="col s4">
                    <input type="submit" class="waves-effect waves-light btn" value="Place All">
                </div>
                
            </div>    
            </form>
           <%
               }
            %>
           
            </center>
        <%@include file="customerFooter.jsp" %>
    </body>
</html>
