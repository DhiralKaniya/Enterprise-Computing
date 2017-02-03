/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;
import Q3.InSufficientStock;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class InventoryItem {
    private int item_code;
    private String item_description;
    private int qty_in_stock;
    private int min_required_stock;
    private double cost;
    public InventoryItem(int item_code,String item_description,int qty_in_stock,int min_required_stock,double cost){
        this.item_code = item_code;
        this.item_description = item_description;
        this.qty_in_stock = qty_in_stock;
        this.min_required_stock = min_required_stock;
        this.cost = cost;
    }
    public InventoryItem(int item_code,int qty_in_stock,int min_required_stock,double cost){
        this.item_code = item_code;
        this.qty_in_stock = qty_in_stock;
        this.min_required_stock = min_required_stock;
        this.cost = cost;
    }
    public int getItem_code(){
        return this.item_code;
    }
    public void addStock(int qty){
        this.qty_in_stock+=qty;
    }
    public int getStock(){
        return this.qty_in_stock;
    }
    public int getCost(){
        return (int)this.cost;
    }
    public boolean isUnderStock(){
        if(this.qty_in_stock <= this.min_required_stock)
            return true;
        else
            return false;
    }
    public void widhrowStock(int qty) throws InSufficientStock{
        if((qty_in_stock-qty) < 0)
            throw new InSufficientStock("We don't having enough stokc..!! Please Decrease the Stock Quantity or Add Some Stock");
        else
            this.qty_in_stock-=qty;
    }
    public void printItem(){
        PrintStream stdout = new PrintStream(System.out);
        stdout.println("Item Code ->" + this.item_code);
        stdout.println("Item Description -> "+this.item_description);
        stdout.println("Item Quantity ->" + this.qty_in_stock);
        stdout.println("Item Cost -> "+this.cost);
        stdout.println("Item Min Quantity -> "+this.min_required_stock);
    }
}
