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
public class insert implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        CurrencyDAO mycurr = (CurrencyDAO)request.getServletContext().getAttribute("currency");
        try{
            String scurr = request.getParameter("scurr");
            String dcurr = request.getParameter("dcurr");
            Currency cCurr = mycurr.checkCurrency(scurr, dcurr);
            if(cCurr == null){
                Currency newCurr = new Currency(scurr,dcurr,Integer.parseInt(request.getParameter("rate")));
                System.out.println(newCurr.getDestinationcurrency());
                mycurr.insertCurrency(newCurr);
                Currency[] mcur = mycurr.searchAll();
                request.setAttribute("mycurr", mcur);
                 return "index.jsp";
            }
            else{
                return "error.jsp";
            }
            //System.out.println(mcur.length);
           
        }catch(NullPointerException | DAOException e){
            e.printStackTrace();
            return "error.jsp";
        }
    }
    
}
