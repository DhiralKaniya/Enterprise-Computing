/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.util.Scanner;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class Solution {
    public static void main(String[] args){
        int p,r,n;
        double ci;
        Scanner scan = new Scanner(System.in);
        PrintStream ps = System.out;
        ps.print("Enter Principal Amount : - ");
        p = scan.nextInt();
        ps.print("Enter Rate of Interest :- ");
        r = scan.nextInt();
        ps.print("Enter Duration :- ");
        n = scan.nextInt();
        ci = (p*r*n) / 100;
        ps.print("Compund Interest is = " + ci);
        scan.close();
    }
}
