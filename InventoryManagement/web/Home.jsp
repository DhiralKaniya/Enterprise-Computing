<%-- 
    Document   : Home
    Created on : 13 Apr, 2017, 1:41:55 PM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.InventoryCategory"%>
<%@page import="InventoryDAO1.InventoryItem"%>
<%@page import="InventoryDAO1.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Management System</title>
        <%@include file="importFiles.jsp" %>  
        
    </head>
    <body>
        <%@include file="customerHeader.jsp" %>
        
            <%
            InventoryItem[] myInvenotry ;
            InventoryCategory[] myCategory;
            try{
                myInvenotry = (InventoryItem[])request.getAttribute("myitem");
                 myCategory = (InventoryCategory[] )request.getAttribute("mycate");
                if(myInvenotry==null){
                        RequestDispatcher rd = request.getRequestDispatcher("Controller?action=viewItem");
                        rd.forward(request, response);
                        myInvenotry = (InventoryItem[])request.getAttribute("myitem");
                        myCategory = (InventoryCategory[] )request.getAttribute("mycate");
                }
            }catch(NullPointerException e){
                
                return;
            }   
        %>
        
        
        <div class="carousel">
            <%
                    int count = 1;
                    for(InventoryItem i : myInvenotry){
                        %>
                        <a class="carousel-item" href="#<%=i.getItem_code() %>">
                            <img src="01.jpg">
                        </a>
                        
                        <%
                    }
                    
           %>  
           <!-- <a class="carousel-item" href="#one!">One</a>
            <a class="carousel-item" href="#two!">Two</a>
            <a class="carousel-item" href="#three!">Three</a>
            <a class="carousel-item" href="#four!">Four</a>
            <a class="carousel-item" href="#five!">Five</a>-->
         </div>
    <center>
           <table class="highlight" style="width: 100%">
            <thead>
                <tr>
                    <th>Item Code</th>
                    <th>Item Description</th>
                    <th>Item Cost</th>
                    <th>Item Category</th>
                    <th>Avalilable Quantity</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    
                    for(InventoryItem i : myInvenotry){
                        %>
                        <tr>
                        <form action="Controller?action=addtocart" method="POST">  
                            <td>
                                <%=i.getItem_code() %></td>
                            <td><%=i.getDescription() %></td>
                            <td><%=i.getCost() %></td>
                            <td><%=i.getCategory().getCategoryName() %></td>
                            <td><%=i.getStock() %></td>
                            <%
                                if(i.getStock() >= i.getMinRequiredQty()){
                            %>
                            <td>
                                <!--<input type="hidden" value="<%=i.getCost() %>" name="or" >
                                <input type="hidden" value="<%=i.getStock() %>" name="st" >
                                <input type="hidden" value="<%=i.getMinRequiredQty() %>" name="mrs">
                                <input type="hidden" value="<%=i.getItem_code() %>" name="ic">
                                <input type="Submit" class="waves-effect waves-light btn" value="Add To Cart" name="Add To Cart">-->
                                <a href="Controller?action=addtocart&ic=<%=i.getItem_code() %>&or=<%=i.getCost() %>&st=<%=i.getStock() %>&mrs=<%=i.getMinRequiredQty() %>"><input type="button" class="waves-effect waves-light btn" value="Add to Cart"></a>
                            </td>
                            <%
                                }else{
                                %>
                            <td style="color:red">Out Of Stock</td>
                            <%
                                }
                                %>
                        </form>

                        </tr>
                  
                        <%
                    }
                    
                %>
            </tbody>
        </table>
    </center>
        <%@include file="customerFooter.jsp" %>
    </body>
</html>
