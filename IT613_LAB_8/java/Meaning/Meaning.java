/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meaning;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dhiral
 */
public class Meaning extends HttpServlet {
    ArrayList myHistory = new ArrayList<String>();
    HttpSession mySession = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(mySession==null)
        {
            mySession = request.getSession();
            mySession.setAttribute("history", myHistory);
        }
        
        Properties p = new Properties();
        PrintWriter pr = response.getWriter();
        InputStream fr = Meaning.class.getClassLoader().getResourceAsStream("Meaning/vocab.properties");
        p.load(fr);
        String word = request.getParameter("word");
        pr.write("<html>");
        pr.write("<body>");
        
        if(p.getProperty(word) != null)
        {   
            myHistory = (ArrayList<String>)mySession.getAttribute("history");
            myHistory.add("Word:- "+word+" and Meaning:-"+p.getProperty(word));
            pr.write("<lable style='color:blue;' for='word'>Word:-"+word+"</lable>");
            pr.write("<br/>");
            pr.write("<lable style='color:Green;' for='meaning'>Meaning of the Word is :-"+ p.getProperty(word) +"</label>");
            pr.write("<br/>");
            
           
        }
        else
        {
            pr.write("<h2 style='color:red'>Opps No Word Founded...!! Please try Again Latter</h2>");
        }
        pr.write("<br/>");
        pr.write("<a href=findWord.html>Click Here To Back</a>");
        pr.write("</body>");
        pr.write("</html>");
        //processRequest(request, response);
    }


}
