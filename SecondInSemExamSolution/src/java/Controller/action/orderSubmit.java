/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.action;
import Controller.Action;
import Item.ShoppingCart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author dhiral
 */
public class orderSubmit implements Action{

    @Override
    public String ActionPerformed(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         ShoppingCart mycart =(ShoppingCart) request.getServletContext().getAttribute("mycart");
        request.setAttribute("mycart",mycart); 
        return "Order_view.jsp";
    }
}
