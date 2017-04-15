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

/**
 *
 * @author dhiral
 */
public class loginCheck implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         InventoryDAO mydao = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if(email.compareTo("admin@inv.com")==0 && password.compareTo("admin@123")==0){
                request.getSession().setAttribute("username", email);
                return "view.jsp";
            }
            else{
                Customer customer = mydao.SearchCustomer(email);
                if(customer == null){
                    request.setAttribute("status", "Customer is Invalid");
                    request.getSession().setAttribute("username", null);
                    return "index.jsp";
                }else if(customer.getPassword().compareTo(password)==0){
                    request.setAttribute("customer", customer);
                    System.out.println(customer.getCustName());
                    request.getSession().setAttribute("user",customer.getCustName());
                    request.getSession().setAttribute("username", email);
                    request.getSession().setAttribute("custid", customer.getCustid());
                    return "Home.jsp";
                }
            }
            request.setAttribute("status", "Password is Invalid");
            return "index.jsp";
        }catch(DAOException e){
            request.setAttribute("status", "unsuccess");
            return "index.jsp";
        }
    }
    
}
