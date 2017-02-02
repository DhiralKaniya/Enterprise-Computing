/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.util.ArrayList;
import Q1.InventoryItem;
import Q3.ItemNotFound;
import Q3.InSufficientStock;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class Inventory {
    private ArrayList<InventoryItem> item;
    private PrintStream stdout;
    public Inventory(){
        item=new ArrayList<>();
    }
    public void addNewInventoryItem(InventoryItem new_item){
        item.add(new_item);
    }
    public void addStock(int item_code,int qty)throws ItemNotFound{
        boolean flag = false;
        for(InventoryItem i : item){
           if(i.getItem_code() == item_code)
           {
               i.addStock(qty);
               flag = true;
               break;
           }    
        }
        if(flag == false)
            throw new ItemNotFound("Enter Item code is Invalid Please Try Again with Different Item Code ..!");
        
    }
    public void withdrawStock(int item_code,int qty) throws ItemNotFound,InSufficientStock{
        boolean flag = false;
        for(InventoryItem i :item){
            if(i.getItem_code() == item_code){
                if(i.isUnderStock() == true)
                    throw new InSufficientStock("Stock is Limited you can't Withdraw it..!!");
                i.widhrowStock(qty);
                flag = true;
            }
        }
        if(flag==false)
            throw new ItemNotFound("Item Code is Invalid..!!");
    }
    public InventoryItem[] itemUnderStock(){
        ArrayList<InventoryItem> itemUnderStock = new ArrayList<InventoryItem>();
        for(InventoryItem i : item){
            if(i.isUnderStock() == true)
                itemUnderStock.add(i);
        }
        InventoryItem[] isUnder = new InventoryItem[itemUnderStock.size()];
        int j =0;
        for(InventoryItem i : itemUnderStock){
           isUnder[j]=i;
           j++;
        }
        return isUnder;
    }
    public InventoryItem search(int item_code)throws ItemNotFound{
        for(InventoryItem i : item){
            if(i.getItem_code()==item_code)
                return i;
        }
        throw new ItemNotFound("Enter code item is not founded");
    }
    public double totalInventoryCost(){
        double total = 0;
        for(InventoryItem i : item){
            total+=i.getCost();
        }
        return total;
    }
    public void printAll(){
        stdout = new PrintStream(System.out);
        for(InventoryItem i : item){
            stdout.println("==========================");
            stdout.println("Item code ->" + i.getItem_code());
            stdout.println("Item Current Stock ->" + i.getStock());
            stdout.println("Item Cost ->" + i.getCost());
        }
    }
}
