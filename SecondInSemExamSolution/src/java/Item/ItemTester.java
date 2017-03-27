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
public class ItemTester {
    public static void main(String[] args){
        Item i1 = new Item(1,"Hello",10,1000);
        Item i2 = new Item(2,"World",10,2000);
        
        ItemStore mystore = new ItemStore();
        try{
            mystore.addItem(i1);
            mystore.addItem(i2);
            
            ShoppingCart mycart = new ShoppingCart(mystore);
            mycart.addItem(1, 2);
            mycart.addItem(1, 3);
            mycart.addItem(2, 2);
            
            System.out.println(mycart.getOrderAmoubt());
        }catch(ItemExists e){
            System.out.println(e);
        }
    }
}
