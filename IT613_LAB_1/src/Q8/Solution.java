/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

/**
 *
 * @author dhiral
 */
public class Solution {
    public static void main(String[] args){
        String[] str = {"Dhiral","Mitesh","Shaaz","Vyanktesh","Akhil"};
        for(int i = 0 ;i < str.length ; i++)
        {
            for(int j = i+1 ; j < str.length ; j++ ){
                if(str[i].compareTo(str[j]) > 0){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        for(int i = 0;i<str.length;i++)
            System.out.println(str[i]);
    }
}
