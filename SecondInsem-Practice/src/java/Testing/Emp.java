/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class Emp extends HttpServlet {

    ArrayList<Employee> myemp ;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        if(myemp == null){
            myemp = new ArrayList<Employee>();
        }
        String action = (String)request.getParameter("action");
        
        if(action.compareTo("addemp")==0){
            addemp(request);
        }else if(action.compareTo("viewemp")==0){
        out.println(action);    
            request.setAttribute("myemp",myemp);
            RequestDispatcher rd ;
            rd = request.getRequestDispatcher("viewemp.jsp");
            rd.forward(request, response);
        }
    }

    public void addemp(HttpServletRequest request)throws ServletException{
        Employee e = new Employee(Integer.parseInt(request.getParameter("empid")),request.getParameter("empname"),Double.parseDouble(request.getParameter("empsalary")),Integer.parseInt(request.getParameter("depid")));
        myemp.add(e);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
