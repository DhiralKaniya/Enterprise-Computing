<%-- 
    Document   : Edit.jsp
    Created on : 8 Apr, 2017, 3:50:34 PM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.InventoryCategory"%>
<%@page import="InventoryDAO1.InventoryItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Item</title>
        <!--Import Google Icon Font-->
                <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <!--Import materialize.css-->
                <link type="text/css" rel="stylesheet" href="materialize.min.css"  media="screen,projection"/>
                <!--Let browser know website is optimized for mobile-->
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
               
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <%@include file="Header.jsp" %>
        
        <%
            String ic = request.getParameter("ic");
            if(ic==null){
                %>
                <form action="Edit.jsp" method="post">
                <div class="row">
                <div class="input-field col s3">
                  <label for="cost">Item Code</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Enter Item Code Here" required name="ic" id="cost" type="number" class="validate">
                </div>
                </div>
                <div class="row">
                <div class="input-field col s12">
                    <center>
                    <button class="btn waves-effect waves-light" type="submit" name="insert">Submit
                        <i class="material-icons right">send</i>
                    </button>         
                   </center>
                </div>
                </div>
                </form>
                <%
            }
            else{     
            InventoryItem myitem =(InventoryItem) request.getAttribute("myitem");
            InventoryCategory[]  myCategory = (InventoryCategory[] )request.getAttribute("mycate");
            if(myitem==null){
                String url = "Controller?action=viewinvetory&ic="+ic;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
            
            %>
            <!--<div id="test2" class="col s12">-->
            <form method="POST" action="Controller?action=update">
            <div class="row">
            <form class="col s12" method="post" action="Controller?action=insert">
                <div class="row">
                <div class="input-field col s3">
                  <label for="item_code">Inventory Item Code</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Enter Item Cost Here" required name="ic" id="ic" readonly value=<%=myitem.getItem_code() %> type="number" class="validate">
                </div>
                </div>
                <div class="row">
                <div class="input-field col s3">
                  <label for="first_name">Inventory Item Description</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <textarea id="textarea1" required name="id" class="materialize-textarea" placeholder="Enter Your Item Description"><%=myitem.getDescription() %></textarea>
                </div>
                </div>

                <div class="row">
                <div class="input-field col s3">
                  <label for="cost">Item Cost</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Enter Item Cost Here" required name="cost" id="cost" type="number" class="validate" value=<%=myitem.getCost() %>>
                </div>
                </div> 

                 <div class="row">
                <div class="input-field col s3">
                  <label for="mrq">Minimum Required Quantity</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Enter Minimum Required Quantity Here" required name="mrs" id="mrs" value=<%=myitem.getMinRequiredQty() %> type="number" class="validate">
                </div>
                </div>

                <div class="row">
                <div class="input-field col s3">
                  <label for="qis">Quantity In Hand</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Enter Quantity In Hand Here" required name="qis" id="qis" value=<%=myitem.getStock() %> s9">
                     
                </div>
                </div>
                <div class="row">
                <div class="input-field col s3">
                  <label for="qis">Select Category</label>
                </div>
                <div class="input-field col s9">
                   <i class="material-icons prefix">mode_edit</i>
                  <select name="cid">
                      <%
                          for(InventoryCategory i :myCategory)
                          {
                              %>
                              <option value="<%=i.getCategoryId() %>" 
                               <%
                                   if(myitem.getCategory().getCategoryId() == i.getCategoryId()) {%>Selected<%}
                               %>    
                                      
                               ><%=i.getCategoryName() %></option>
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
                        <a href="view.jsp"><button class="btn waves-effect waves-light" type="button" name="back">Back
                        <i class="material-icons right">settings_backup_restore</i>
                    </button></a>
                    </center>
                </div>
              </div>
            </div>
            </form>


            <!--</div>-->
            <%
            }

        %> 
        
        <%@include file="Footer.jsp" %>
    </body>
</html>
