<%-- 
    Document   : category.jsp
    Created on : 10 Apr, 2017, 12:21:46 AM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.InventoryCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category Management</title>
         <%@include file="importFiles.jsp" %>     
    </head>
    <body>
        <%
            InventoryCategory[] mycategory ;
            try{
               mycategory = (InventoryCategory[])request.getAttribute("mycategory");   
               if(mycategory == null){
                   RequestDispatcher rd ;
                   rd = request.getRequestDispatcher("Controller?action=allcategory&callby=category");
                   rd.forward(request, response);
                   mycategory = (InventoryCategory[])request.getAttribute("mycategory");
               }
            }catch(NullPointerException e){
                return;
            }
        %>
        <%@include file="Header.jsp" %>
        
        <div class="row">
            <div class="col s12">
              <ul class="tabs">
                <li class="tab col s6"><a href="#test1">View Category</a></li>
                <li class="tab col s6"><a href="#test2">Add Category</a></li>
              </ul>
            </div>
      
            
            <div id="test1" class="col s12">
                 <table class="highlight">
                    <thead>
                        <tr>
                            <th>Category Code</th>
                            <th>Category Name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody><%
                    for(InventoryCategory i : mycategory){
                        %>
                        <tr>
                            <td><%=i.getCategoryId() %></td>
                            <td><%=i.getCategoryName() %></td>
                            <td><a href="CategoryEdit.jsp?ic=<%=i.getCategoryId() %>"> <i class="material-icons">mode_edit</i></a></td>
                            <td><a href="Controller?action=deletecategory&categoryid=<%=i.getCategoryId() %>"><i class="material-icons">delete</i></a></td>
                        </tr>
                        <%
                    }
                    %></tbody>
                 </table>
            </div>
            <div id="test2" class="col s12">
                <div class="row">
                    <form class="col s12" method="post" action="Controller?action=insertcategory">
                     <div class="row">
                        <div class="input-field col s3">
                          <label for="first_name">Category Name</label>
                        </div>
                        <div class="input-field col s9">
                          <i class="material-icons prefix">mode_edit</i>
                          <input placeholder="Enter Category Name" required name="category" id="cost" type="text" class="validate">
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
        </div>
        
        <%@include file="Footer.jsp" %>
    </body>
</html>
