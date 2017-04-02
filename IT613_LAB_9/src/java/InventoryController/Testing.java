/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController;

import InventoryDAO1.InventoryCategory;
import InventoryDAO1.InventoryDAO;
import UserDefineException1.DAOException;
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
public class Testing extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        out.println(action);
        InventoryDAO mydao = new InventoryDAO();
        if(action.compareTo("viewcate")==0){
            try{
                InventoryCategory[] mycategory = mydao.viewCategory();
                for(int i=0;i<mycategory.length;i++){
                    out.println(mycategory[i].getCategoryName());
                }
            }catch(DAOException e){
                System.out.println(e);
            }
        }
        else if (action.compareTo("insert")==0){
            int item_code = Integer.parseInt(request.getParameter("item_code"));
            int qty = Integer.parseInt(request.getParameter("qty"));
            String desc = request.getParameter("description");
            
           // mydao.InsertItem(item);
        }
    
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
