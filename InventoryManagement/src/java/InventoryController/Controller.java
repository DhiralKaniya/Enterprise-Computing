/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController;

import InventoryDAO1.InventoryDAO;
import InventoryDAO1.InventoryCategory;
import InventoryDAO1.InventoryItem;
import InventoryDAO1.dbConnect;
import InventoryDAO1.InventoryMysql;
import Util.ObjectCreator;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class Controller extends HttpServlet {

    InventoryDAO myInventoryDAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String str = request.getParameter("action");
        if(str==null)
            str = "view";
        //System.out.println(str);
        ActionInterface myAction = this.getAction(str);
        try{
            String view = myAction.actionPerfrom(request, response);
            if(view==null)
                response.sendRedirect("view.jsp");
            else if(view.compareTo("categoryHome")==0){
                response.sendRedirect("category.jsp");
            }
            else if(view!=null){
                RequestDispatcher rd ;
                System.out.println(view);
                rd = request.getRequestDispatcher(view);
                rd.forward(request,response);
            }
            else{
                response.sendRedirect("view.jsp");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
      
    }
    private ActionInterface getAction(String myaction)throws ServletException,IOException{
        Properties p = new Properties();
        
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("InventoryController/action.properties");
        try{
            p.load(is);
            //System.out.println(p.getProperty(myaction));
            ActionInterface action = (ActionInterface)ObjectCreator.createObject(p.getProperty(myaction));
            return action;
        }catch(NullPointerException e){
            return null;
        }
    }
    
    @Override 
    public void init()throws ServletException{
       myInventoryDAO = new InventoryDAO();
       getServletContext().setAttribute("InventoryDAO", myInventoryDAO);
    }
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
