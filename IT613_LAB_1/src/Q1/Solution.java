/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.io.PrintStream;
import java.util.Scanner;
/**
 *
 * @author dhiral
 */
public class Solution {
    public static void main(String[] args){
        double x , y,comp=1;
        PrintStream stdout = System.out;
        Scanner scan =  new Scanner(System.in);
        stdout.print("Enter first Value :- ");
        x = scan.nextDouble();
        stdout.print("Enter second Value :- ");
        y = scan.nextDouble();
        for(int i = 0 ;i <  y;i++){
            comp *= x;
        }
        stdout.print("Compute Value is :-" + comp);
    }
}
