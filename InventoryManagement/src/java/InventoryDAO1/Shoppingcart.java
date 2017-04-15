/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO1;
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
public class Shoppingcart{
    private ArrayList<Cartitem> myitem;
    private static int cartid = 1000;
    private int cartNo;
    
    public Shoppingcart(int cartNo){
        this.cartNo = cartNo;
        this.myitem = new ArrayList<Cartitem>();
    }
    public Shoppingcart(){
        this.cartNo = 1;
        cartid++;
        this.myitem = new ArrayList<Cartitem>();
    }
    public int getCarno(){
        return this.cartNo;
    }
    public void addItem(Cartitem cartitem){
        this.myitem.add(cartitem);
    }
    public void removeItem(Cartitem removeItem){
        this.myitem.remove(removeItem);
    }
    public ArrayList<Cartitem> getAllCartItem(){
        return this.myitem;
    }
}
