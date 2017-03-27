/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.action;
import Controller.Action;
import Item.ShoppingCart;
import Item.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author dhiral
 */
public class addAction implements Action{
    @Override
    public String ActionPerformed(HttpServletRequest request,HttpServletResponse response)throws ServletException{
         
        int item_code = Integer.parseInt(request.getParameter("item_code"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        if(qty == 0)
            qty = 1;
        
        ShoppingCart mycart =(ShoppingCart) request.getServletContext().getAttribute("mycart");
        mycart.addItem(item_code, qty);
        request.setAttribute("mycart",mycart);
        
        return "Order_view.jsp";
    }
}
