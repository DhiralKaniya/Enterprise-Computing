/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dhiral
 */
public class PollSimulator {
    public static void main(String[] args){
        PrintStream stdout = new PrintStream(System.out);
        Scanner stdin = new Scanner(System.in);
        PollDB poll_db = new PollDB();
        int n = 1;
        while(n != 0){
            stdout.println("1 :- Enter New Candidate ..");
            stdout.println("2 :- Start Voting ..");
            stdout.println("3 :- Result Decalration ..");
            stdout.println("0 :- Exit ..");
            n = stdin.nextInt();
            switch(n){
                case 1 ://Enter a New Candidate 
                   int valid = 0;
                   stdin.nextLine();
                   while(valid < 3){
                        stdout.println("Enter Password to Add new Candidate ...!!");
                        String password = stdin.nextLine();
                        if(password.compareTo("helloworld")==0){
                            do{
                                stdout.println("Please Enter Candidate Name");
                                String candidateName = stdin.nextLine();
                                poll_db.addCandidate(candidateName);
                                stdout.println("Do You Want to Add More Candidate..Press 1 else 0");
                                int a = stdin.nextInt();
                                if(a == 0)
                                    valid = 3;
                                stdin.nextLine();
                            }while(valid < 3);
                        }
                        else{
                            stdout.println("Please Enter Valid Password");
                            valid++;
                        }
                   }
                    break;
                case 2 ://Start Voting
                    String[] candidate = poll_db.getCandidate();
                    stdout.println("List of the Candidate ");     
                    for(int i = 0;i<candidate.length;i++){
                       stdout.println(i+1 + "->Candidate Name :- " + candidate[i]);     
                    }
                    stdout.println("Give Your Valuable Vote Enter Index Number of the Candidate below..!!");     
                    int indexNumber = stdin.nextInt();
                    try{
                        poll_db.voteTo(indexNumber);
                    }
                    catch(Exception e){
                        e.getMessage();
                    }
                    break;
                case 3 : //Result Decalration
                    int validation = 0;
                    stdin.nextLine();
                    do{
                        stdout.println("Enter Password To Show the Result..!!");
                        String pass = stdin.nextLine();
                        if(pass.compareTo("helloworld")==0){
                            stdout.println("Here is the Result of Voting..!!");
                            HashMap<String,Integer> candidates = poll_db.getAllCandidate();
                            for(Map.Entry<String,Integer> s : candidates.entrySet()){
                                stdout.println("Candidate Name :- " + s.getKey() + "Candidate Votes :- "+s.getValue());
                            }
                            System.out.println("Winner Name is :- " + poll_db.getWinner());
                            validation=3;
                        }
                        else{
                            stdout.println("Your Password is incorrect ..!! Try Again");
                            validation++;
                            if(validation == 3)
                                stdout.println("You have reach at maximum wrong password limit..!!");
                        }
                    }while(validation < 3);
                    break;
                case 0 : //Exit
                    stdout.println("Thank you very Much..");
                    break;
                default :
                    stdout.println("Wrong Input...!!");
                    break;
                         
            }
        }
        
    }
}
