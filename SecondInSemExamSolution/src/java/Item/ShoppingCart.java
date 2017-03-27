/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dhiral
 */
public class ShoppingCart {
    HashMap<Integer,Integer> mycart ;
    ItemStore myitem;
    public ShoppingCart(ItemStore itemstore)
    {
        this.myitem = itemstore;
        mycart = new HashMap<Integer,Integer>();
    }
    public void addItem(int item_code,int qty){
        
        if(mycart.containsKey(item_code)==true){
            qty+=mycart.get(item_code);
        }
        mycart.put(item_code, qty);
    }
    public void remove(int item_code){
        mycart.remove(item_code);
    }
    public int[] getItemCodes(){
        int[] myitems = new int[mycart.size()];
        int n=0;
        for(Map.Entry<Integer,Integer> items : mycart.entrySet()){
            myitems[n] = items.getKey();
            n++;
        }
        return myitems;
    }
    public int[] getItem(){
        int[] myitems = new int[mycart.size()];
        int n=0;
        for(Map.Entry<Integer,Integer> items : mycart.entrySet()){
            myitems[n] = items.getKey();
            n++;
        }
        return myitems;
    }
    public int[] getQty(){
        int[] myqty = new int[mycart.size()];
        int n=0;
        for(Map.Entry<Integer,Integer> items : mycart.entrySet()){
            myqty[n] = items.getValue();
            n++;
        }
        return myqty;
    }
    public double getOrderAmoubt(){
        Double total = 0.0;
        for(Map.Entry<Integer,Integer> items : mycart.entrySet()){
            try{
                Item item = myitem.getItem(items.getKey());
                total+= item.getCost()*items.getValue();
            }catch(ItemNotFound in){
                System.out.println(in.getMessage());
            }
        }
        return total;
    }
}
