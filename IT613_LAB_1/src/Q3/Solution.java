/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;
import java.util.Scanner;
/**
 *
 * @author dhiral
 */
public class Solution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Boolean flag = true;
        int count = 0 ;
        for(int i = 1 ; i < n ; i++){
          
           if( n % i == 0){
               count++;
               
               if(count > 1)
               {
                   flag = false;
               }
           }
        }
        if(flag == true)    
            System.out.print("Prime");
        else
            System.out.print("Nor Prime");
    }
}
