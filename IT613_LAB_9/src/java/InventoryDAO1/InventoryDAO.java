/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO1;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
import UserDefineException1.DAOException;
import UserDefineException1.DBConnect;
import UserDefineException1.InSufficientStock;
import UserDefineException1.ItemNotFound;
import UserDefineException1.ItemExists;



public class InventoryDAO {
    private int page_length;
    InventoryMysql mySQlObject;
    public InventoryDAO(int page_length){
        this.page_length = page_length;
        try{
            this.mySQlObject = new InventoryMysql();
        }catch(DBConnect e)
        {
            System.out.println(e);
        }
    }
    public InventoryDAO(){
        this.page_length = 2;
        try{
            this.mySQlObject = new InventoryMysql();
        }catch(DBConnect e)
        {
            System.out.println(e);
        }
    }
    //set the page length
    public void setPageLength(int length){
        this.page_length = length;
    }
    //get the current page length
    public int getPageLength(){
        return this.page_length;
    }
    //Insert Item into the database
    public void InsertItem(InventoryItem items) throws ItemExists ,DAOException{
        try{
            InventoryItem findItem = this.mySQlObject.searchItemByItemCode(items.getItem_code());
            throw new ItemExists();
        }catch(ItemNotFound e){
            //if item not found then insert item
            try{
                this.mySQlObject.insertItem(items);
            }catch(SQLException e1){
                throw new DAOException();
            }
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //Insert Inventory Array
    public void InsertItem(InventoryItem[] items)throws ItemExists,DAOException{
        try{
            //off auto commit before inserting
            this.mySQlObject.offAutoCommit();
            for(int i=0;i<items.length;i++)
            {
                this.InsertItem(items[i]);
            }
            //commit the data
            this.mySQlObject.commit();
            //on auto commit
            this.mySQlObject.onAutoCommit();
        }catch(SQLException | ItemExists | DAOException e ){
            System.out.println(e);
            try{
                this.mySQlObject.rollBack();
            }catch(SQLException e1){
                System.out.println(e1);
            }
        }
    }
    //update Inventory Item
    public void updateitem(InventoryItem items)throws ItemNotFound , DAOException{
        try{
            InventoryItem findItem = this.mySQlObject.searchItemByItemCode(items.getItem_code());
            if(findItem == null)
                throw new ItemNotFound();
            this.mySQlObject.updateItem(items);
        }catch( SQLException e){
            System.out.println("Error with SQL");
        }
    }
    //Update Inventory Item with Array
    public void updateItem(InventoryItem[] items)throws ItemNotFound,DAOException{
        try{
            //off auto commit before inserting
            this.mySQlObject.offAutoCommit();
            for(int i=0;i<items.length;i++)
            {
                this.updateitem(items[i]);
            }
            //commit the data
            this.mySQlObject.commit();
            //on auto commit
            this.mySQlObject.onAutoCommit();
        }catch(SQLException | ItemNotFound | DAOException e ){
            System.out.println(e);
            try{
                //Roll back if any error occur 
                this.mySQlObject.rollBack();
            }catch(SQLException e1){
                System.out.println(e1);
            }
        }
    }
    //get Item by item_code
    public InventoryItem getItem(long item_code)throws ItemNotFound,DAOException{
        try{
            InventoryItem getSearchItem = this.mySQlObject.searchItemByItemCode((int)item_code);
            if(getSearchItem == null)
                throw new ItemNotFound();
            return getSearchItem;
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //get all Item
    public InventoryItem[] getItem() throws DAOException{
        try{
            ArrayList<InventoryItem> searchItems = this.mySQlObject.searchAllItem();
            InventoryItem[] findedData = new InventoryItem[searchItems.size()];
            searchItems.toArray(findedData);
            return findedData;
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //view all category 
    public InventoryCategory[] viewCategory()throws DAOException{
        try{
            
            ArrayList<InventoryCategory> mycat = this.mySQlObject.searchAllCategory();
            InventoryCategory[] mycate = new InventoryCategory[mycat.size()];
            mycat.toArray(mycate);
            return mycate;
            
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //get pagination item
    public InventoryItem[] getPaginatedItems(int page_no)throws DAOException{
        try{
            int end = this.page_length * page_no;
            int start = end - (this.page_length - 1);
            InventoryItem[] findItem = this.mySQlObject.searchInventoryWithPagination(start, end);
            return findItem;
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //get Item Category
    public InventoryItem[] getItemsCategory(int category) throws DAOException{
        try{
            ArrayList<InventoryItem> findInventory = this.mySQlObject.searchItemByCatId(category);
            return (InventoryItem[])findInventory.toArray();
        }catch(SQLException | ItemNotFound e){
            throw new DAOException();
        }
    }
    // add stock
    public void addStock(int item_code,int qty) throws ItemNotFound,DAOException{
        try{
            InventoryItem findItem = this.mySQlObject.searchItemByItemCode(item_code);
            if(findItem == null)
                throw new ItemNotFound();
            findItem.addStock(qty);
            this.mySQlObject.updateItem(findItem);
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //withdrawn Stock
    public void withdrwawStock(int item_code,int qty) throws ItemNotFound,InSufficientStock,DAOException{
        try{
            InventoryItem findItem = this.mySQlObject.searchItemByItemCode(item_code);
            if(findItem == null)
                throw new ItemNotFound();
            findItem.widhrowStock(qty);
            this.mySQlObject.updateItem(findItem);
        }catch(SQLException e){
            throw new DAOException();
        }catch(InSufficientStock o){
            throw new InSufficientStock();
        }
    }
    //isUnder stock item
    public InventoryItem[] itemsUnderStock() throws DAOException{
        try{
            InventoryItem[] findResult = this.mySQlObject.searchUnderItem();
            return findResult;
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //Total Coust
    public double totalInventoryCost() throws DAOException {
        try{
            double total = (double)this.mySQlObject.totalInventoryCost();
            return total;
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //Delete Item
    public void deleteItem(int item_code)throws ItemNotFound,DAOException{
        try{
            InventoryItem findItem = this.mySQlObject.searchItemByItemCode(item_code);
            if(findItem == null)
                throw new ItemNotFound();
            this.mySQlObject.deleteItem(item_code);
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //delete items by Array
    public void deleteItem(int[] item_code)throws DAOException,ItemNotFound{
        //off the auto commit
        try{
            this.mySQlObject.offAutoCommit();
            for(int i = 0 ; i < item_code.length;i++)
                this.deleteItem(item_code[i]);
            this.mySQlObject.commit();
            this.mySQlObject.onAutoCommit();
        }catch(SQLException e){
            try{
                this.mySQlObject.rollBack();
            }catch(SQLException e1){
                    throw new DAOException();
                    }
            throw new DAOException();
        }
    }
}
