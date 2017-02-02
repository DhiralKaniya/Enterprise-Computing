/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;
import java.io.PrintStream;
import java.util.Scanner;
import Q1.InventoryItem;
import Q2.Inventory;
import Q3.ItemNotFound;
import Q3.InSufficientStock;
/**
 *
 * @author dhiral
 */
public class InventoryTester {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        PrintStream stdout = new PrintStream(System.out);
        Inventory item_details = new Inventory();
        int n;
        do
        {
            stdout.println("1 : Add New Inventory");
            stdout.println("2 : Add Stock");
            stdout.println("3 : WithdrawStock");
            stdout.println("4 : Items are Under Minimum stock");
            stdout.println("5 : Search item");
            stdout.println("6 : Total of all Inventory's Cost");
            stdout.println("7 : Print all available item ");
            stdout.println("0 : Exit");
            n=stdin.nextInt();
            
            switch(n){
                case 1 : //Add new Inventory
                    stdout.println("=================****************===============");
                    stdout.println("Enter Item Code");
                    int item_code = stdin.nextInt();
                    stdout.println("Enter Product Description");
                    stdin.nextLine();
                    String item_description = stdin.nextLine();
                    stdout.println("Enter Current Stock of the Item");
                    int qty = stdin.nextInt();
                    stdout.println("Enter Cost of the Item");
                    double cost = stdin.nextDouble();
                    stdout.println("Enter Min Required Qunatity ");
                    int min_qty = stdin.nextInt();
                    item_details.addNewInventoryItem(new InventoryItem(item_code,item_description,qty,min_qty,cost));
                    stdout.println("Item has been Successfully Added");
                break;
                case 2 ://add Stock
                    stdout.println("=======*******=======");
                    stdout.println("Enter Item Code");
                    int item_scode = stdin.nextInt();
                    stdout.println("Enter new Stock Quantity");
                    int stock = stdin.nextInt();
                    try{
                        item_details.addStock(item_scode, stock);
                    }catch(ItemNotFound e){
                        stdout.println(e);
                        return;
                    }
                break;
                case 3://Withdrawn Stock
                    stdout.println("=======*******=======");
                    stdout.println("Enter Item Code");
                    int item_wcode = stdin.nextInt();
                    stdout.println("Enter withdrawn Qunatity");
                    int wd = stdin.nextInt();
                    try{
                        item_details.withdrawStock(item_wcode, wd);
                    }catch(ItemNotFound e){
                        stdout.println(e);
                        return;
                    }catch(InSufficientStock e){
                        stdout.println(e);
                        return;
                    }
                break;
                case 4 ://item under Law stock
                    InventoryItem[] lawStock=item_details.itemUnderStock();
                    for(InventoryItem i : lawStock){
                        i.printItem();
                    }
                break;
                case 5 ://Search
                    try{
                        stdout.println("==========********============");
                        stdout.println("Enter Item Code");
                        int item_dcode = stdin.nextInt();
                        InventoryItem item_search = item_details.search(item_dcode);
                        item_search.printItem();
                    }catch(ItemNotFound e){
                        stdout.println(e);
                        return;
                    }
                break;
                case 6://Total Inventory Cost
                    stdout.println("=======*******=======");
                    stdout.println("Total Inventory Cost is " +item_details.totalInventoryCost());
                break;
                case 7://print all
                    item_details.printAll();
                break;
                case 0://Exit Condition
                    stdout.println("Thank You ..!!");
                break;
                    
            }
        }while(n!=0);
    }
}
