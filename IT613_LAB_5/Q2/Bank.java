/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Long;
import java.util.Map;
import java.util.Calendar;
/**
 *
 * @author dhiral
 */
public class Bank {
    static int bankid = 1000;
    private HashMap<Integer,BankAccount> accountHolder;
    private String bankName;
    private double rate_of_interest;
    private ArrayList<InterestPaid> InterestPaidLog;
    public Bank(String bankName,double rate_of_interest){
        this.bankName = bankName;
        this.rate_of_interest = rate_of_interest;
        accountHolder = new HashMap<Integer,BankAccount>();
        InterestPaidLog = new ArrayList<InterestPaid>();
        bankid++;
    }
    //This Method is called when new Account will open
    public int openNewAccount(double initial_balance){
        BankAccount newAccount = new BankAccount(initial_balance);
        int newAccountNo =(int) newAccount.getAccno();
        this.accountHolder.put(newAccountNo,newAccount);
        return newAccountNo;
    }
    //to Find the particaluar account no from the bank
    public BankAccount find(int accountNo)throws NoAccountFound{
        
        for(Map.Entry<Integer,BankAccount> t : this.accountHolder.entrySet()){
            if(t.getKey() == accountNo)
                return t.getValue();
        }
            throw new NoAccountFound();
    }
    //to close particular account in the bank
    public BankAccount close(int accountNo)throws NoAccountFound{
        if(this.accountHolder.containsKey(accountNo)){
            BankAccount obj = this.accountHolder.get(accountNo);
            this.accountHolder.remove(accountNo);
            return obj;
        }
        else
            throw new NoAccountFound();
    }
    //this method is used to pay interest of the
    //Here this method is update and i remove the argument of this method because in the 3rd question it was mention that payInterest method will automatically call at the end of the month
    public void payInterest(){
        Date date = new Date();
       for(Map.Entry<Integer,BankAccount> e : this.accountHolder.entrySet()){
            double interest = e.getValue().payInterest(this.rate_of_interest);
            InterestPaid new_Interest = new InterestPaid(date,e.getKey(),interest);
            this.InterestPaidLog.add(new_Interest);
       }
    }
    public double getTotalInterestPaid(int year){
        double total = 0;
        for(InterestPaid e : this.InterestPaidLog){
            total+=e.getInterest(year);
        }
        return total;
    }
    public double getTotalDeposites(int year){
        double total = 0;
        for(Map.Entry<Integer,BankAccount> ac : this.accountHolder.entrySet()){
            total+=ac.getValue().getTotalDeposite(year);
        }
        return total;
    }
    public void printAllTransaction(int accountNo){
        BankAccount ob =this.accountHolder.get(accountNo);
        ob.printAllTransaction();
    }
    class InterestPaid{
        Calendar interestDate = Calendar.getInstance();
        int accountNo;
        double amount;
        public InterestPaid(Date interestDate,int accountNo,double amount){
            System.out.println(interestDate);
            this.interestDate.setTime(interestDate);
            this.accountNo = accountNo;
            this.amount = amount;
        }
        public double getInterest(int yr)
        {
            int year = interestDate.get(Calendar.YEAR);
            
            if(year == yr)
                return this.amount;
            else 
                return 0;
        }
        public double getInterest(){
            return this.amount;
        }
    }
}
