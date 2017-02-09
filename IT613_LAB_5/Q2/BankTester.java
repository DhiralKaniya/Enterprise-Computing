/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.util.Date;
import java.util.Calendar;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class BankTester {
    public static void main(String[] args){
        PrintStream stdout = new PrintStream(System.out);
        
        //Creating Bank
        Bank boi = new Bank("Bank Of India",10.0);
        
        //Add New Account
        boi.openNewAccount(1000);
        boi.openNewAccount(2000);
        boi.openNewAccount(3000);
        
        //To Deposite Money in Some Account we can use like this
        try{
            BankAccount depositeObject = boi.find(10000);
            depositeObject.deposit(5000);
            
        }catch(NoAccountFound e)
        {
            stdout.println(e);
        }
        boi.payInterest();
        stdout.println(boi.getTotalDeposites(2017));
        stdout.println(boi.getTotalInterestPaid(2017));
        boi.printAllTransaction(10001);
    }
}
