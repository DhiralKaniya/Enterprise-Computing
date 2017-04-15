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
public class Order {
    private Shoppingcart orderCart;
    private Customer orderCust;
    private String orderDate;
    private int totalAmount;
    public Order(Shoppingcart mycart,Customer mycust,String date){
        this.orderCart = mycart;
        this.orderCust = mycust;
        this.orderDate = date;
        this.totalAmount = 0;
        for(Cartitem i : this.orderCart.getAllCartItem()){
           totalAmount += i.getOrderqty() * i.getOrderrate();
        }
    }
    public String getOrderDate(){
        return this.orderDate;
    }
    public Shoppingcart getOrderCart(){
        return this.orderCart;
    }
    public int getTotalAmount(){
        return this.totalAmount;
    }
    public Customer getOrderCust(){
        return this.orderCust;
    }
}
