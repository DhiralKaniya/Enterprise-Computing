/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.Customer;
import InventoryDAO1.InventoryDAO;
import UserDefineException1.DAOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dhiral
 */
public class addCustomer implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        InventoryDAO mydao = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
            String emailid = request.getParameter("email");
            String name = request.getParameter("custname");
            String contactno = request.getParameter("contactno");
            String password = request.getParameter("password");
            Customer mycust = new Customer(name,contactno,emailid,password);
            Customer checkExist = mydao.SearchCustomer(emailid);
            if(checkExist==null){
                mydao.addCustomer(mycust);
                request.setAttribute("status", "success");
            }else{
                request.setAttribute("status", "Customer Exist");
            }
            return "index.jsp";
        }catch(DAOException e){
            request.setAttribute("status", "unsuccess");
            return "index.jsp";
        }
    }
    
}
