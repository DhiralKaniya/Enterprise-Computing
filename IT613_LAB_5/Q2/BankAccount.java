/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/**
 *
 * @author dhiral
 */
public class BankAccount {
   private final long accno;
   private double balance;
   private static long next_accno=10000;
   private ArrayList<Transaction> transaction;
   private HashMap<Integer,Double> min_balance;//integer consider as month and double consider as min_balance
   private HashMap<Integer,Double> interest;//Integer consider as month and double is consider as interest of that month
   
   public BankAccount()   {
       this.accno = next_accno++;
       this.balance = 0;
       this.min_balance = new HashMap<Integer,Double>();
       this.interest = new HashMap<Integer,Double>();
       this.transaction = new ArrayList<Transaction>();
   }
    public long getAccno() {
        return accno;
    }
   public BankAccount(double initialBalance)   {
       this.accno = next_accno++;
       this.balance = initialBalance;
       this.min_balance = new HashMap<Integer,Double>();
       this.interest = new HashMap<Integer,Double>();
       Calendar c = Calendar.getInstance();
       Date date = new Date();
       c.setTime(date);
       this.min_balance.put(c.get(Calendar.MONTH),balance);
       this.transaction = new ArrayList<Transaction>();
       
       //We have to add transaction while the money is deposite at the new account is open with initial Balance
       Transaction tr = new Transaction(date,"Deposite of "+this.accno,"Credit",initialBalance);
       this.transaction.add(tr);
    }
   //Interest is calculate as per the RBI rule at the end of the month on the Minimum balance amount of the month.
   //Reference link to calculate the Interest on saving account is :- http://www.moneycontrol.com/news/fixed-income-bank-deposits/how-do-banks-calculate-interestyour-savings-ac_666167.html
   public double payInterest(double rate){
       double min_bal = this.getMinimumBalanceInMonth();
       Calendar c = Calendar.getInstance();
       int month = c.get(Calendar.MONTH);
       double month_interest = (min_bal * rate )/100;
       this.interest.put(month,month_interest);
       this.balance += month_interest;
       Transaction nwTransaction=new Transaction(c.getTime(),"Paid Interest of" + this.accno,"Credit",month_interest);
       transaction.add(nwTransaction);
       return month_interest;
   }
   private double getMinimumBalanceInMonth(){
       Calendar c = Calendar.getInstance();
       Date date = new Date();
       c.setTime(date);
       int month = c.get(Calendar.MONTH);
       return this.min_balance.get(month);
   }
   //if we want to know particalur month's Interest in that case 
   public double getInterest(int month){
       double month_interest = this.interest.get(month);
       return month_interest;
   }
   public void deposit(double amount)   {
       double newBalance = balance + amount;
       balance = newBalance;
       Date currentDate = new Date();
       Transaction nwTransaction = new Transaction(currentDate,"Deposite of "+this.accno,"Credit",amount);
       transaction.add(nwTransaction);
   }
   public void withdraw(double amount)
           throws DailyLimitException, InsuffBalanceException {
       double newBalance = balance - amount;
       if ( amount > 25000 )
           throw ( new DailyLimitException() );
       else if ( amount > balance )
           throw ( new InsuffBalanceException() );
       balance = newBalance;
       Date currentDate = new Date();
       Transaction newTransaction = new Transaction(currentDate,"Withdrawn of "+this.accno,"Debit",amount);
       transaction.add(newTransaction);
       Calendar c1 = Calendar.getInstance();
       c1.setTime(currentDate);
       int month = c1.get(Calendar.MONTH);
       if(this.min_balance.containsKey(month))
       {
           double min_bal = this.min_balance.get(month);
           if(this.balance < min_bal)
               this.min_balance.put(month,this.balance);
       }
       else{
           this.min_balance.put(month, this.balance);
       }
   }
   public double getBalance()
   {
       return balance;
   }
   public double getTotalDeposite(int year){
       double total = 0;
       for(Transaction t : this.transaction){
           
           if(t.getType().compareTo("Credit") == 0 && t.getYear() == year){
               total += t.getAmount();
           }
       }
       return total;
   }
   public void printAllTransaction(){
       for(Transaction t : this.transaction){
           System.out.println(t.getDate()+" "+t.getNarration()+" "+t.getAmount()+"" + t.getType());
       }
   }
}
