/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.Cartitem;
import InventoryDAO1.InventoryDAO;
import InventoryDAO1.Shoppingcart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class place implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         InventoryDAO mydao = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
            int custid = Integer.parseInt(request.getSession().getAttribute("custid").toString());
            int ic = Integer.parseInt(request.getParameter("ic"));
            int qty = Integer.parseInt(request.getParameter("qty"));
            int rate = Integer.parseInt(request.getParameter("rate"));
            int cartno = Integer.parseInt(request.getParameter("cartno"));
            Cartitem myitem = new Cartitem(ic,null,qty,rate);
            mydao.placeOrder(myitem, cartno, custid);
            
            return "Order.jsp";
        }catch(Exception e){
            request.setAttribute("status", "unsuccess");
            return "Home.jsp";
        }
    }
    
}
