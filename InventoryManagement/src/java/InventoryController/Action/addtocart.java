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
public class addtocart implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO mydao = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
            int ic = Integer.parseInt(request.getParameter("ic"));
            String mqty = request.getParameter("qty");
            int qty;
            if(mqty==null)
                qty=1;
            else
                qty = Integer.parseInt(mqty);
            int stock = Integer.parseInt(request.getParameter("st"));
            int mrs = Integer.parseInt(request.getParameter("mrs"));
            System.out.println(qty + " "+stock);
            if(qty > stock){
                request.setAttribute("status", "Quantity is not available");
            }
            else{
                request.setAttribute("status", "Quantity has been added");
                int custid = Integer.parseInt(request.getSession().getAttribute("custid").toString());
                int rate = Integer.parseInt(request.getParameter("or"));
                mydao.checkShoppingCart(custid, ic, qty,rate);
            }
            
            return "Shoppingcart.jsp";
        }catch(DAOException e){
            request.setAttribute("status", "unsuccess");
            return "Home.jsp";
        }
    }
    
}
