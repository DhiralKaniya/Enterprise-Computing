/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.util.ArrayList;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class Bank {
    ArrayList<AccountHolder> Account;  
    PrintStream stout ; 
    public Bank(){
        Account = new ArrayList<AccountHolder>();
        stout = new PrintStream(System.out);
    }	
    public void addAccountHolder(AccountHolder new_accountHolder){ 
        this.Account.add(new_accountHolder);
    }
    private AccountHolder search(int AccountNumber)throws NoAccountFound{ 
        for(AccountHolder account : Account){
            if(account.getAccountNumber() == AccountNumber)
                return account;
        }
        throw new NoAccountFound("No Account Founded..!!");
    }
    //deposite money according to the account type if saving account then limit 50,000 else no limit
    public void depositeAmount(int AccountNumber,double amount)throws NoAccountFound, DepositeLimitExcced
    {
        AccountHolder CurrentAccountHolder = this.search(AccountNumber);
        if(CurrentAccountHolder.getAccountType().compareTo("saving")==0){
            if(amount > 50000){
                throw new DepositeLimitExcced("Your Deposite Amount has been Exceed.!!");
            }
        }
        CurrentAccountHolder.deposite(amount);
    }
    //withdrawn amount according to the account type;
	//if account type is saving then don't allow withdrawn money less than min amount
    public void withdrawnAmount(int AccountNumber,double amount)throws NoAccountFound, InSufficientBalanace, WithdrawnLimitExceed
    { 
        AccountHolder CurrentAccountHolder = this.search(AccountNumber);
        if(CurrentAccountHolder.getAccountType().compareTo("saving")==0){
            if(amount > 49999)
                throw new WithdrawnLimitExceed("Your Withdrawn Limit has been Exceed..!!");
        }
        if(amount>CurrentAccountHolder.getAvailableBanlance()){
            throw new InSufficientBalanace("Balance is Not Available");
        }
        CurrentAccountHolder.withdrawn(amount);
    }
	
    public double calInterest(int AccountNumber) throws NoAccountFound
    { 
        AccountHolder CurrentAccountHolder = this.search(AccountNumber);
        return CurrentAccountHolder.getInterest();
    }
    public double CheckBalance(int AccountNumber)throws NoAccountFound{ 
        AccountHolder CurrentAccountHolder = this.search(AccountNumber);
        return CurrentAccountHolder.getAvailableBanlance();
    }
    public AccountHolder[] AccountUnderMinBalance(){
        ArrayList<AccountHolder> UnderBalance = new ArrayList<AccountHolder>();
        for(AccountHolder account : Account){
            if(account.isMinBalance())
                UnderBalance.add(account);
        }
        return (AccountHolder[])UnderBalance.toArray();
    }
    public AccountHolder findAccountHolder(int AccountNumber) throws NoAccountFound {
        AccountHolder account = this.search(AccountNumber);
        return account;
    }
    public void printAll(){
        for(AccountHolder account : Account){
            account.print();
        }
    }
}
