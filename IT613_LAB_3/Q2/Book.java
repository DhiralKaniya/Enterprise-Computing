/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class Book {
   private int ISBN;
   private String title;
   private double price;
   private PrintStream out;
   Book(int ISBN,String title,double price){
       this.ISBN = ISBN;
       this.title = title;
       this.price = price;
   }
   public void setISBN(int ISBN){
       this.ISBN = ISBN;
   }
   public void setTitle(String title){
       this.title = title;
   }
   public void setPrice(double price){
       this.price = price;
   }
   public int getISBN(){
       return this.ISBN;
   }
   public String getTitle(){
       return this.title;
   }
   public double getPrice(){
       return this.price;
   }
   public void print(){
       try{
           out = new PrintStream(System.out);
           System.out.println("============================");
           System.out.println("ISBN Number = " + this.ISBN);
           System.out.println("Title = "+ this.title);
           System.out.println("Price = " + this.price);
       }catch(Exception e){
           System.out.println(e);
           return;
       }
   }
}
