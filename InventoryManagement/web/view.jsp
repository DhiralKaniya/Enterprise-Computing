<%-- 
    Document   : view
    Created on : 31 Mar, 2017, 7:39:09 PM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.InventoryItem"%>
<%@page import="InventoryDAO1.InventoryCategory"%>
<%@page import="UserDefineException1.DAOException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Item Management</title>
          <%@include file="importFiles.jsp" %>     
                
    </head>
    <body>
 
          <%@include file="Header.jsp" %>
         
    
           
            <%
            InventoryItem[] myInvenotry ;
            InventoryCategory[] myCategory;
            try{
                myInvenotry = (InventoryItem[])request.getAttribute("myitem");
                 myCategory = (InventoryCategory[] )request.getAttribute("mycate");
                if(myInvenotry==null){
                        RequestDispatcher rd = request.getRequestDispatcher("Controller?action=view");
                        rd.forward(request, response);
                        myInvenotry = (InventoryItem[])request.getAttribute("myitem");
                        myCategory = (InventoryCategory[] )request.getAttribute("mycate");
                }
            }catch(NullPointerException e){
                
                return;
            }   
        %>
        
  <div class="row">
    <div class="col s12">
      <ul class="tabs">
        <li class="tab col s4"><a href="#test1">View Inventory</a></li>
        <li class="tab col s4"><a href="#test2">Add Inventory</a></li>
        <li class="tab col s4"><a href="#test3">Inventory By Category</a></li>
        
      </ul>
    </div>
      
    <!-- view Inventory Item -->
    <div id="test1" class="col s12">
        
        <table class="highlight">
            <thead>
                <tr>
                    <th>Item Code</th>
                    <th>Item Description</th>
                    <th>Item Cost</th>
                    <th>Item Minimum Quantity</th>
                    <th>Item Stock</th>
                    <th>Item Category</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for(InventoryItem i : myInvenotry){
                        %>
                        <tr>
                            <td><%=i.getItem_code() %></td>
                            <td><%=i.getDescription() %></td>
                            <td><%=i.getCost() %></td>
                            <td><%=i.getMinRequiredQty() %></td>
                            <td><%=i.getStock() %></td>
                            <td><%=i.getCategory().getCategoryName() %></td>
                            <td><a href="Edit.jsp?ic=<%=i.getItem_code() %>"> <i class="material-icons">mode_edit</i></a></td>
                            <td><a href="Controller?action=delete&item_code=<%=i.getItem_code() %>"><i class="material-icons">delete</i></a></td>
                        </tr>
                        <%
                    }
                    
                %>
            </tbody>
        </table>
        
    </div>
    <!-- Insert Item -->
    <div id="test2" class="col s12">
    <div class="row">
    <form class="col s12" method="post" action="Controller?action=insert">
      <div class="row">
        <div class="input-field col s3">
          <label for="first_name">Inventory Item Description</label>
        </div>
        <div class="input-field col s9">
          <i class="material-icons prefix">mode_edit</i>
          <textarea id="textarea1" required name="id" class="materialize-textarea" placeholder="Enter Your Item Description"></textarea>
        </div>
        </div>
        
        <div class="row">
        <div class="input-field col s3">
          <label for="cost">Item Cost</label>
        </div>
        <div class="input-field col s9">
          <i class="material-icons prefix">mode_edit</i>
          <input placeholder="Enter Item Cost Here" required name="cost" id="cost" type="number" class="validate">
        </div>
        </div> 
        
         <div class="row">
        <div class="input-field col s3">
          <label for="mrq">Minimum Required Quantity</label>
        </div>
        <div class="input-field col s9">
          <i class="material-icons prefix">mode_edit</i>
          <input placeholder="Enter Minimum Required Quantity Here" required name="mrs" id="mrs" type="number" class="validate">
        </div>
        </div>
        
        <div class="row">
        <div class="input-field col s3">
          <label for="qis">Quantity In Hand</label>
        </div>
        <div class="input-field col s9">
          <i class="material-icons prefix">mode_edit</i>
          <input placeholder="Enter Quantity In Hand Here" required name="qis" id="qis" type="number" class="validate">
        </div>
        </div>
        
        <div class="row">
        <div class="input-field col s3">
          <label for="cate">Select Category1</label>
        </div>
        <div class="input-field col s9">
             <i class="material-icons prefix">mode_edit</i>
          <select name="cid">
           
              <%
                  for(InventoryCategory i :myCategory)
                  {
                      %>
                      <option value="<%=i.getCategoryId() %>"><%=i.getCategoryName() %></option>
                      <%
                  }
              %>
          </select>
           <label>Select Item Category</label>
        </div>
        </div>
        <div class="row">
        <div class="input-field col s12">
            <center>
            <button class="btn waves-effect waves-light" type="submit" name="insert">Submit
                <i class="material-icons right">send</i>
            </button>
                
            <button class="btn waves-effect waves-light" type="reset" name="reset">Reset
                <i class="material-icons right">cloud</i>
            </button>    
            </center>
        </div>
      </div>
      </form>
    </div>
        
        
    </div>
    
    <div id="test3" class=col s12">
    <div class="row">
        <form method="POST" action="Controller?action=viewcategory">
            <div class="input-field col s6">
                 <i class="material-icons prefix">mode_edit</i>
                <select name="cateid">

                    <%
                        for(InventoryCategory i :myCategory)
                        {
                            %>
                            <option value="<%=i.getCategoryId() %>"><%=i.getCategoryName() %></option>
                            <%
                        }
                    %>
                </select>
               <label>Select Item Category</label>
            </div>
            <div class="input-field col s6">
                <center>
                <button class="btn waves-effect waves-light" type="submit" name="insert">Submit
                    <i class="material-icons right">send</i>
                </button>

                </center>
            </div>    
        </form>
      </div>
      <div class="row">
            <div class="input-field col s12">          
      <%
        InventoryItem[] myitem1 = (InventoryItem[])request.getAttribute("myitem_category");
        if(myitem1!=null){          
            %>
            <table class="responsive-table">
                <thead>
                    <tr>
                        <th>Item Code</th>
                        <th>Item Description</th>
                        <th>Item Cost</th>
                        <th>Item Minimum Quantity</th>
                        <th>Item Stock</th>
                        <th>Item Category</th>
                    </tr>
                </thead>
                <tbody>
                <%
                for(int i=0;i<myitem1.length;i++){    
                %>
                    <tr>
                            <td><%=myitem1[i].getItem_code() %></td>
                            <td><%=myitem1[i].getDescription() %></td>
                            <td><%=myitem1[i].getCost() %></td>
                            <td><%=myitem1[i].getMinRequiredQty() %></td>
                            <td><%=myitem1[i].getStock() %></td>
                            <td><%=myitem1[i].getCategory().getCategoryName() %></td>
                    </tr>
                <%
                }
               %>
                </tbody>
        </table>
           <%
        }
      %>
            </div>
        </div>
    </div>
  </div>
       <%@include file="Footer.jsp" %>
    </body>
</html>
