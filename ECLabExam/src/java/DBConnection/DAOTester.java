/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import Modal.Currency;
import Modal.CurrencyDAO;
import Modal.DAOException;

/**
 *
 * @author dhiral
 */
public class DAOTester {
    public static void main(String[] args){
        try{
            CurrencyDAO mydao = new CurrencyDAO();
            Currency mycurr = new Currency("USD","IND",91);
            //mydao.insertCurrency(mycurr);
            Currency scurr = mydao.searchCurrency("INR", "USD");
            if(scurr!= null)
                System.out.println(scurr.getCurrencyrate());
        }catch(DAOException | NullPointerException e){
            e.printStackTrace();
        }
    }
}
