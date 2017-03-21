<%-- 
    Document   : insert
    Created on : 21 Mar, 2017, 4:02:21 PM
    Author     : dhiral
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form method="post" action ="Emp" name="addemp">
            empid :- <input type="text" name="empid" /><br/>
            empname :- <input type="text" name="empname" /><br/>
            empsalary :- <input type="text" name="empsalary" /><br/>
            depid :- <input type="text" name="depid" /><br/>
            <input type="submit" value="addemp" name="action" />
        </form>
    </body>
</html>
