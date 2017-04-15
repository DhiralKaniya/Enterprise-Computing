<%-- 
    Document   : CategoryEdit
    Created on : 10 Apr, 2017, 1:29:18 AM
    Author     : dhiral
--%>

<%@page import="InventoryDAO1.InventoryCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Category</title>
         <%@include file="importFiles.jsp" %>  
    </head>
    <body>
        <%@include file="Header.jsp" %>
            <%
            String ic = request.getParameter("ic");
            if(ic==null){
                %>
                <form action="CategoryEdit.jsp" method="post">
                <div class="row">
                <div class="input-field col s3">
                  <label for="cost">Category Id</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Enter Category ID Here" required name="ic" id="cost" type="number" class="validate">
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
            InventoryCategory mycate =(InventoryCategory) request.getAttribute("mycate");
            
            if(mycate==null){
                String url = "Controller?action=mycategory&ic="+ic;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                mycate =(InventoryCategory) request.getAttribute("mycate");
            }
            
            %>
            <!--<div id="test2" class="col s12">-->
            <form method="POST" action="Controller?action=updatecategory">
            <div class="row">
            <form class="col s12" method="post" action="Controller?action=insert">
                <div class="row">
                <div class="input-field col s3">
                  <label for="item_code">Item Category</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Enter Item Cost Here" required name="item_cate" id="ic" readonly value=<%=mycate.getCategoryId() %> type="number" class="validate">
                </div>
                </div>
                
                <div class="row">
                <div class="input-field col s3">
                  <label for="cost">Category</label>
                </div>
                <div class="input-field col s9">
                  <i class="material-icons prefix">mode_edit</i>
                  <input placeholder="Category Here" required name="cate_name" id="cost" type="text" class="validate" value=<%=mycate.getCategoryName() %>>
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
