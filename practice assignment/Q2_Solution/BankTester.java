/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.io.PrintStream;
import java.util.Scanner;
/**
 *
 * @author dhiral
 */
public class BankTester {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        PrintStream stdout = new PrintStream(System.out);
        Bank bank = new Bank();
        int n;
        do
        {
            stdout.println("1 : Add New AccountHolder");
            stdout.println("2 : Deposite Amount");
            stdout.println("3 : Withdrawn Money");
            stdout.println("4 : AccountHolder under Minimum Balance");
            stdout.println("5 : Search Account Holder");
            stdout.println("6 : Check Balance");
            stdout.println("7 : Print all Account Holder's Details ");
            stdout.println("0 : Exit");
            n=stdin.nextInt();
            
            switch(n){
                case 1 : //Add new Account Holder
                    stdout.println("=================****************===============");
                    stdout.println("Enter Account Number");
                    int accountNumnber = stdin.nextInt();
                    stdout.println("Enter Account Holder Name");
                    stdin.nextLine();
                    String accountHolderName = stdin.nextLine();
                    stdout.println("Enter Contact Number");
                    double contactnumber = stdin.nextDouble();
                    stdout.println("Enter Deposite Amount");
                    double damount = stdin.nextDouble();
                    stdout.println("Enter Min Banlance");
                    double mamaount = stdin.nextDouble();
                    stdin.nextLine();
                    stdout.println("Enter Account Type");
                    String accounttype = stdin.nextLine();
                    bank.addAccountHolder(new AccountHolder(accountNumnber,accountHolderName,contactnumber,damount,mamaount,accounttype));
                    stdout.println("Account Holder has been Successfully Added");
                break;
                case 2 ://Deposite Amount
                    stdout.println("=======*******=======");
                    stdout.println("Enter Account Number");
                    int accountNumber = stdin.nextInt();
                    stdout.println("Enter Depostie Amount");
                    double damount1 = stdin.nextDouble();
                    try{
                        bank.depositeAmount(accountNumber, damount1);
                    }catch(NoAccountFound | DepositeLimitExcced e){
                        stdout.println(e);
                    }
                break;
                case 3://Withdrawn Amount
                    stdout.println("=======*******=======");
                    stdout.println("Enter Account Number");
                    int accountNumber1 = stdin.nextInt();
                    stdout.println("Enter withdrawn Amount");
                    double wamount1 = stdin.nextDouble();
                    try{
                        bank.withdrawnAmount(accountNumber1,wamount1);
                    }catch(NoAccountFound | InSufficientBalanace | WithdrawnLimitExceed e){
                        stdout.println(e);
                    }
                break;
                case 4 ://AccountHolder under MinBalance
                    AccountHolder[] account = bank.AccountUnderMinBalance();
                    for(AccountHolder a : account){
                        a.print();
                    }
                break;
                case 5 ://Search Account Holder
                    try{
                        stdout.println("==========********============");
                        stdout.println("Enter AccountNumber");
                        int AccountNumber= stdin.nextInt();
                        AccountHolder account1 = bank.findAccountHolder(AccountNumber);
                        account1.print();
                    }catch(NoAccountFound e){
                        stdout.println(e);
                        return;
                    }
                break;
                case 6://Check Balance for particular Account Holder
                    stdout.println("=======*******=======");
                    stdout.println("Enter AccountNumber");
                    int AccountNumber = stdin.nextInt();
                    try{
                        stdout.println("Available Banlance is " + bank.CheckBalance(AccountNumber));
                    }catch(NoAccountFound e){
                        stdout.println(e);
                    }
                break;
                case 7://print all Account Holder Details
                    bank.printAll();
                break;
                case 0://Exit Condition
                    stdout.println("Thank You ..!!");
                break;
                    
            }
}while(n!=0);
    }
}
