/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author dhiral
 */
public class AccountHolder {
    
    private int AccountNumber;
    private String HolderName;
    private double ContactNumber;
    private double AvailableBalance;
    private double MinBalance;
    private String AccountType;
    private double Interest;
    
    public AccountHolder(int AccountNumber,String HolderName,double ContactNumber,double DepositeAmount,double MinBalance,String AccountHolderType){
	this.AccountNumber = AccountNumber;
        this.HolderName = HolderName;
        this.ContactNumber = ContactNumber;
        this.AvailableBalance = DepositeAmount;
        this.MinBalance = MinBalance;
        this.AccountType = AccountHolderType;
        this.Interest = (DepositeAmount*0.10);
    }
    public AccountHolder(int AccountNumber,String HolderName,double ContactNumber,String AccountHolderType){
        this.AccountNumber = AccountNumber;
        this.HolderName = HolderName;
        this.ContactNumber = ContactNumber;
        this.AvailableBalance = 0;
        this.MinBalance = 0;
        this.AccountType = AccountType;
        this.Interest = 0;
    }
    public double getInterest(){
        return this.Interest;
    }
    public int getAccountNumber(){
        return this.AccountNumber;
    }
    public String getHolderName(){
        return this.HolderName;
    }
    public double getContactNumber(){
        return this.ContactNumber;
    }
    public double getAvailableBanlance(){
        return this.AvailableBalance;
    }
    public double getMinBalance(){ 
        return this.MinBalance;
    }
    public String getAccountType(){
        return this.AccountType;
    }
    public void deposite(double amount){
        //Add amount to the available amount and add 10% interest 
        this.AvailableBalance+=amount;
        this.Interest += (amount*0.10);
    }
    public void withdrawn(double amount)throws InSufficientBalanace {
        if(this.isMinBalance()){
            throw new InSufficientBalanace("Balance is Insufficient ..!!");
        }else{
            this.AvailableBalance-=amount;
        }
    }
    public boolean isMinBalance(){
        if(this.AvailableBalance < this.MinBalance)
            return true;
        else
            return false;
    }
    public void print(){
        System.out.println("======***********======");
        System.out.println("Account Number -> " + this.AccountNumber);
        System.out.println("Account Type -> " + this.AccountType);
        System.out.println("Available Balance -> " + this.AvailableBalance);
        System.out.println("Rate Of Interest -> " + this.Interest);
    }
}
