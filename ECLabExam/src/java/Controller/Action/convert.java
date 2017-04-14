/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import Controller.ActionInterface;
import Modal.Currency;
import Modal.CurrencyDAO;
import Modal.DAOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class convert implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        CurrencyDAO mycurr = (CurrencyDAO)request.getServletContext().getAttribute("currency");
        try{
            String s = request.getParameter("src");
            String d = request.getParameter("des");
            int amount = Integer.parseInt(request.getParameter("amount"));
            Currency cur = mycurr.searchCurrency(s, d);
            double total = amount * cur.getCurrencyrate();
            String s1 = "" + amount;
            String s2 = "" + total;
            request.setAttribute("currc",cur);
            request.setAttribute("amount", s1);
            request.setAttribute("total",s2);
            return "result.jsp";
        }catch(NullPointerException | DAOException e){
            e.printStackTrace();
            return "error.jsp";
        }
    }
    
}
