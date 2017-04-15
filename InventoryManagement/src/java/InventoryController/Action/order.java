/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.InventoryDAO;
import InventoryDAO1.Orderitem;
import UserDefineException1.DAOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class order implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO mydao = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
            int custid = Integer.parseInt(request.getSession().getAttribute("custid").toString());
            Orderitem[] myorder = mydao.searchOrder(custid);
            request.setAttribute("myorder", myorder);
            return "Order.jsp";
       }catch(DAOException e){
           e.printStackTrace();
           return "Home.jsp";
       }
    
}
    
}
