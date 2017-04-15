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
public class Orderitem {
    private int orderno;
    private int custid;
    private Cartitem myitem;
    private int total;
    private String date;
    private String status;
    public Orderitem(int on,int cid,Cartitem cartitem,String date,String status){
        this.orderno=on;
        this.custid=cid;
        this.myitem=cartitem;
        this.total=total;
        this.date=date;
        this.status=status;
    }
    public int getOrderno(){
        return this.orderno;
    }
    public int getCustid(){
        return this.custid;
    }
    public Cartitem getItem(){
        return this.myitem;
    }
    public int getTotal(){
        return this.total;
    }
    public String getDate(){
        return this.date;
    }
    public String getStatus(){
        return this.status;
    }
}
