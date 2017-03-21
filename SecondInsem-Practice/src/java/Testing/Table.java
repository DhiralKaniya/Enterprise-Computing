/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
public class Table extends HttpServlet {
    HttpSession mysession = null;
    ArrayList<Integer> history ;
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if(mysession == null){
            mysession = request.getSession();
            history = new ArrayList<Integer>();
            mysession.setAttribute("History", history);
        }
      
        history =(ArrayList<Integer>) mysession.getAttribute("History");
       
        int num = Integer.parseInt(request.getParameter("number"));
        int st = Integer.parseInt(request.getParameter("start"));
        history.add(num);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border=1>");
        
        for(int i = st;i<=10;i++){
            out.println("<tr>");
            out.println("<td>" + i + "</td>");
            out.println("<td>"+ i * num + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }
}
