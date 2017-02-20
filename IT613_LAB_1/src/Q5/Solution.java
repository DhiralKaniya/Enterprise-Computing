/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;
import java.util.Scanner;
/**
 *
 * @author dhiral
 */
public class Solution {
    public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       String str = scan.nextLine();
       String newStr = str.replace('i', '!');
       newStr = newStr.replace('s', '$');
       System.out.print("Old String is " + str);
       System.out.print("\nNew String is " + newStr);
    }
}
