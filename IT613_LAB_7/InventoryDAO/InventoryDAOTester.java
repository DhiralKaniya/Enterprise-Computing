/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO;
import UserDefineException.DAOException;

/**
 *
 * @author dhiral
 */
public class InventoryDAOTester {
    public static void main(String[] args){
        InventoryDAO newDAO = new InventoryDAO();
        InventoryCategory newInventoryCategory = new InventoryCategory(14,"Cold Drink");
        InventoryItem newInventoryItem = new InventoryItem("Coca cola",50,5,40,newInventoryCategory);
        try{
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
        }catch(DAOException e){
            System.out.println(e);
        }
    }
}
