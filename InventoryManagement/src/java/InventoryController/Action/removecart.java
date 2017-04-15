/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.InventoryDAO;
import InventoryDAO1.Shoppingcart;
import UserDefineException1.DAOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class removecart implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO mydao = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
            int custid = Integer.parseInt(request.getSession().getAttribute("custid").toString());
            int item_code = Integer.parseInt(request.getParameter("ic"));
            int cartno = Integer.parseInt(request.getParameter("cartno"));
            mydao.deleteItemFromCart(cartno, item_code, custid);
            return "Shoppingcart.jsp";
        }catch(DAOException e){
            request.setAttribute("status", "unsuccess");
            return "index.jsp";
        }
    }
    
}
