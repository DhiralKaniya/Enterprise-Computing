/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author dhiral
 */
public class Item {
    private int item_code;
    private String item_description;
    private int qty;
    private double cost;
    public Item(int item_code,String item_description,int qty,double cost){
        this.item_code = item_code;
        this.item_description = item_description;
        this.qty = qty;
        this.cost = cost;
    }
    public int getCode(){
        return this.item_code;
    }
    public String getDescription(){
        return this.item_description;
    }
    public int getStock(){
        return this.qty;
    }
    public double getCost(){
        return this.cost;
    }
}
