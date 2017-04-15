/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO1;
import UserDefineException1.DAOException;
import UserDefineException1.ItemNotFound;
import java.util.ArrayList;

/**
 *
 * @author dhiral
 */
public class InventoryDAOTester {
    public static void main(String[] args){
        InventoryDAO newDAO = new InventoryDAO();
        //InventoryCategory newInventoryCategory = new InventoryCategory(14,"Cold Drink");
        try{
            /*InventoryItem newInventoryItem = new InventoryItem(0,"Coca cola",50,5,40,12);
            System.out.println(newInventoryItem.getCategory().getCategoryId());*/
            //InventoryItem[] myitem = (InventoryItem[])newDAO.getItem(15);
           /* int item_code = 15;
            InventoryItem myitem = newDAO.getItem(item_code);
            System.out.println(myitem.getDescription());*/
            //newDAO.deleteItemFromCart(1000, 20, 2);
           /*newDAO.checkShoppingCart(2, 21, 2, 25);
           Shoppingcart mycart =newDAO.searchShoppingcart(1);
           System.out.println(mycart.getCarno());
           /*ArrayList<Cartitem> c1 = mycart.getAllCartItem();
           for(Cartitem c : c1){
               System.out.println(c.getItemcode() +" "+ c.getOrderqty()+" "+c.getItemdescription());
           }*/
           Shoppingcart mycart = newDAO.searchShoppingcart(2);
           newDAO.placeOrder(mycart, 2);
           
           System.out.println("Successfully");
        }catch(NullPointerException | DAOException  e){
            e.printStackTrace();
            System.out.println(e);
        }
        /*try{
            //newDAO.InsertItem(newInventoryItem);
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            int size = 2;
            newDAO.setPageLength(size);
            InventoryItem[] find1stPageData = newDAO.getPaginatedItems(1);
            for(int i=0;i<size;i++){
                   System.out.println("cateGoryId ->" + find1stPageData[i].getItem_code() + "\nDescription -> " + find1stPageData[i].getDescription());
            }
              InventoryCategory[] mycategory = newDAO.viewCategory();
                for(int i=0;i<mycategory.length;i++){
                    System.out.println(mycategory[i].getCategoryName());
                }
        }catch(DAOException e){
            System.out.println(e);
        }*/
    }
}
