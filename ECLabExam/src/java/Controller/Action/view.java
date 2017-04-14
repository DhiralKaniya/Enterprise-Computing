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
public class view implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        CurrencyDAO mycurr = (CurrencyDAO)request.getServletContext().getAttribute("currency");
        try{
            Currency[] mcur = mycurr.searchAll();
            request.setAttribute("mycurr", mcur);
            System.out.println(mcur.length);
            return "index.jsp";
        }catch(NullPointerException | DAOException e){
            e.printStackTrace();
            return "error.jsp";
        }
    }
    
}
