package Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class Table extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int num = Integer.parseInt(request.getParameter("number"));
        PrintWriter pw = response.getWriter();
        pw.write("<html>");
        pw.write("<body>");
        pw.write("<table><tr><th colspan=2>Table of " + num+"</th></tr>" );
        pw.write("<tr><th>Sr No</th><th'></th><th>Value</th></tr>");
        
        for(int i=1;i<=10;i++)
        {
            pw.write("<tr>");
            pw.write("<td>"+i+"*"+num+"</td>");   
            pw.write("<td>"+i*num+"</td>");
            pw.write("</tr>");
        }
        pw.write("</body>");
        pw.write("</html>");
    }

}
