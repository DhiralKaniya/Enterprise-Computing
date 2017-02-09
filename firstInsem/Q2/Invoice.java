/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insem_exam;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class Invoice {
    private String  customer_number,date;
    private double tax_rate;
    HashMap<Item,Integer> item ;
    static int invoiceNumber = 0 ;
    int CIN;
    Invoice(String customer_number,double tax_rate,String date){
        this.date = date;
        this.customer_number = customer_number;
        this.tax_rate = tax_rate;
        invoiceNumber ++;
        this.CIN = invoiceNumber;
        item =new HashMap<Item,Integer>();
    }
    public void addItem(Item new_item,int qty){
        System.out.print(item.size());
       if(item.containsKey(new_item)){
           int temp = item.get(new_item);
           item.put(new_item, temp+qty);
       }
       else{
           item.put(new_item, qty);
       }
    }
    private Item[] getItems(){
       HashMap<Item,Integer> temp = new HashMap<Item,Integer>();
       ArrayList<Item> items = new ArrayList<Item>();
       for(Map.Entry<Item,Integer> i : this.item.entrySet()){
          items.add(i.getKey());
       }
       return (Item[])items.toArray();
    }
    private int[] getQty(){
       HashMap<Item,Integer> temp = new HashMap<Item,Integer>();
       ArrayList<Integer> items = new ArrayList<Integer>();
       for(Map.Entry<Item,Integer> i : this.item.entrySet()){
          items.add(i.getValue());
       }
       int t1[] = new int[items.size()];
       int j=0;
       for(Integer i :items){
           t1[j++]=i;
       }
       return t1;
    }
    public void setTaxRate(double tax_rate){
        this.tax_rate = tax_rate;
    }
    private double getTaxRate(){
        return this.tax_rate;
    }
    private double getInvoiceAmount(){
        double total = 0;
        double tr =1+(this.tax_rate/100);
        for(Map.Entry<Item,Integer> i : this.item.entrySet()){
            total +=(tr+(i.getValue()*i.getKey().getCost()));
        }
        return total;
    }
    private double getTaxAmount(){
        double total = 0;
        double tr = this.tax_rate / 100;
        for(Map.Entry<Item,Integer> i : this.item.entrySet()){
            total +=(tr+(i.getValue()*i.getKey().getCost()));
        }
        return total;
    }
    public void print(PrintStream out){
        PrintStream stdout = new PrintStream(out);
        stdout.println("\t\t\t\tABC Enterprise Pvt LTD\t\t\t\t\t\n");
        stdout.printf("\t\t\t\t\tINVOICE\t\t\t\t\n");
        stdout.printf("No:<%s>\t\t\t\t\t\t\t\t\tDate:%s\n",this.CIN,this.date);
        stdout.printf("Customer Number :- %s\n",this.customer_number);
        for(int i=0;i<90;i++)
            stdout.printf("-");
        stdout.printf("-");
        stdout.printf("\n\t\tSrNo\t\tcode\t\tRate\t\t Qty\t\tAmount\n");
        for(int i=0;i<90;i++)
            stdout.print("-");
        stdout.println("-");
        int count=1;
        for(Map.Entry<Item,Integer> i : this.item.entrySet()){
            stdout.printf("\n\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",count++,i.getKey().getItem_code(),i.getKey().getCost(),i.getValue(),(i.getValue()*i.getKey().getCost()));    
        }
        stdout.printf("\t\t\t\t\t\t\t\t\tTotal:%.2f\n",this.getTaxAmount());
        stdout.printf("\t\t\t\t\t\t\t\t\tTax:%.2f\n",this.tax_rate);
        stdout.printf("\t\t\t\t\t\t\t\t\tTotal:%.2f\n",this.getInvoiceAmount());
    }
}
