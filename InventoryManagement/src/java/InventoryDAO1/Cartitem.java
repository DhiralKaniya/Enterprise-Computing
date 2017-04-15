/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO1;

/**
 *
 * @author dhiral
 */
public class Cartitem {
    private int item_code;
    private String item_desc;
    private int order_qty;
    private int order_rate;
    public Cartitem(int ic,String id,int oq,int or){
        this.item_code=ic;
        this.item_desc=id;
        this.order_qty=oq;
        this.order_rate=or;
    }
    public int getItemcode(){
        return this.item_code;
    }
    public String getItemdescription(){
        return this.item_desc;
    }
    public int getOrderqty(){
        return this.order_qty;
    }
    public int getOrderrate(){
        return this.order_rate;
    }
}
