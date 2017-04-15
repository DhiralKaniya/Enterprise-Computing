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
import UserDefineException1.DAOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class placeall implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO mydao = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
            int custid = Integer.parseInt(request.getSession().getAttribute("custid").toString());
            Shoppingcart mycart = (Shoppingcart)request.getSession().getAttribute("mycart1");
            int cartno = mycart.getCarno();
            System.out.println("Cartno -> " + cartno);
            System.out.println("Item Size - >"+mycart.getAllCartItem().size() );
            System.out.println("cust id  - >"+custid );
            for(Cartitem c : mycart.getAllCartItem()){
                mydao.placeOrder(c,cartno , custid);
            }
            
            request.getSession().setAttribute("mycart1", null);
            request.setAttribute("mycart", null);
            return "Order.jsp";
        }catch(Exception e){
            request.setAttribute("status", "unsuccess");
            return "Home.jsp";
        }
    }
    
}
