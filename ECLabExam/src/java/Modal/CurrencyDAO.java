/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dhiral
 */
public class CurrencyDAO {
    Connection conn = null;
    public CurrencyDAO() throws DAOException{
        try{
            conn = DBConnection.getInstance().getConnection();
            System.out.println("Connection DOne");
        }catch(SQLException | ClassNotFoundException e){
            throw new DAOException("Error in connection");
        }
    }
    public void insertCurrency(Currency currency)throws DAOException{
        try{
            Statement mystate = conn.createStatement();
            String qry = "INSERT INTO tbl_CurrencyRate VALUES('"+currency.getSourcecurrency()+"','"+currency.getDestinationcurrency()+"',"+currency.getCurrencyrate()+")";
            mystate.executeUpdate(qry);
        }catch(SQLException e){
            throw new DAOException("Error During Insert");
        }
    }
    public Currency checkCurrency(String scurr,String dcurr)throws DAOException{
        try{
            String qry =" SELECT * FROM tbl_CurrencyRate WHERE (source_currency='"+scurr+"' AND target_currency='"+dcurr+"') OR (source_currency='"+dcurr+"' AND target_currency='"+scurr+"')";
            Statement mystate = conn.createStatement();
            ResultSet myres = mystate.executeQuery(qry);
            if(myres.next()){
                Currency mycurr = new Currency(myres.getString("source_currency"),myres.getString("target_currency"),myres.getDouble("conversion_rate"));
                return mycurr;
            }
            return null;
        }catch(SQLException e){
            throw new DAOException("Error During Checking");
        }
    }
    public Currency searchCurrency(String scurr,String dcurr)throws DAOException{
        try{
            Statement mystate = conn.createStatement();
            String qry = "SELECT * FROM tbl_CurrencyRate WHERE source_currency='"+scurr+"' AND target_currency='"+dcurr+"'";
            //System.out.println(qry);
            ResultSet myres = mystate.executeQuery(qry);
            if(myres.next()){
                Currency mycurr = new Currency(myres.getString("source_currency"),myres.getString("target_currency"),myres.getDouble("conversion_rate"));
                return mycurr;
            }
            
        }catch(SQLException e){
            throw new DAOException("Error During Insert");
        }
        return null;
    }
    public Currency[] searchAll()throws DAOException{
        try{
            Statement mystate = conn.createStatement();
            String qry = "SELECT * FROM tbl_CurrencyRate";
            //System.out.println(qry);
            ResultSet myres = mystate.executeQuery(qry);
            ArrayList<Currency> mcurr = new ArrayList<Currency>();
            while(myres.next()){
                Currency mycurr = new Currency(myres.getString("source_currency"),myres.getString("target_currency"),myres.getDouble("conversion_rate"));
                mcurr.add(mycurr);
            }
            Currency[] curr = new Currency[mcurr.size()];
            mcurr.toArray(curr);
            return curr;
        }catch(SQLException e){
            throw new DAOException("Error During Insert");
            
        }
    }
    public String[] sourceCurrency()throws DAOException{
        try{
            Statement mystate = conn.createStatement();
            String qry = "SELECT source_currency FROM tbl_CurrencyRate";
            //System.out.println(qry);
            ResultSet myres = mystate.executeQuery(qry);
            ArrayList<String> mcurr = new ArrayList<String>();
            while(myres.next()){
                mcurr.add(myres.getString("source_currency"));
            }
            String[] str = new String[mcurr.size()];
            mcurr.toArray(str);
            return str;
        }catch(SQLException e){
            throw new DAOException("Error During Insert");
            
        }
    }
    public String[] destinationCurrency()throws DAOException{
         try{
            Statement mystate = conn.createStatement();
            String qry = "SELECT target_currency FROM tbl_CurrencyRate";
            //System.out.println(qry);
            ResultSet myres = mystate.executeQuery(qry);
            ArrayList<String> mcurr = new ArrayList<String>();
            while(myres.next()){
                mcurr.add(myres.getString("target_currency"));
            }
            String[] str = new String[mcurr.size()];
            mcurr.toArray(str);
            return str;
        }catch(SQLException e){
            throw new DAOException("Error During Insert");
            
        }
    }
}
