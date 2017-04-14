/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modal.CurrencyDAO;
import Modal.DAOException;
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

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String str = request.getParameter("action");
        if(str==null)
            str = "view";
        System.out.println(str);
        ActionInterface myAction = this.getAction(str);
        try{
           String view = myAction.actionPerfrom(request, response);
           if(view==null){
              view="/index.jsp";
           }
           System.out.println(view);
           RequestDispatcher rd = request.getRequestDispatcher(str);
           rd.forward(request, response);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
      
    }
    private ActionInterface getAction(String myaction)throws ServletException,IOException{
        Properties p = new Properties();
        
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("Controller/action.properties");
        try{
            p.load(is);
            ActionInterface action = (ActionInterface)ObjectCreator.createObject(p.getProperty(myaction));
            return action;
        }catch(NullPointerException e){
            return null;
        }
    }
    
    @Override 
    public void init()throws ServletException{
        try{
            CurrencyDAO mycurr = new CurrencyDAO();
            getServletContext().setAttribute("currency", mycurr);
        }catch(DAOException e){
            e.printStackTrace();
        }
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
