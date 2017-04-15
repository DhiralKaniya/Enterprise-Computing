/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO1;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author dhiral
 */
import UserDefineException1.DAOException;
import UserDefineException1.DBConnect;
import UserDefineException1.InSufficientStock;
import UserDefineException1.ItemNotFound;
import UserDefineException1.ItemExists;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



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
    /*
    Customer Registration
    */
    //Customer Regstration
    public void addCustomer(Customer customer)throws DAOException{
        try{
            this.mySQlObject.insertCustomer(customer);
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    public Customer SearchCustomer(String emailid)throws DAOException{
        try{
            Customer customer = this.mySQlObject.searchCustomer(emailid);
            return customer;
        }catch(SQLException e){
            throw new DAOException();
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
    //Delete from the shopping cart by customer
    public void deleteItemFromCart(int cid,int ic,int custid)throws DAOException{
        try{
            this.mySQlObject.deleteFromcart(cid, ic, custid);
        }catch(SQLException e){
            e.printStackTrace();
            throw new DAOException();
        }
    }
    //search Order
    public Orderitem[] searchOrder(int custid)throws DAOException{
        try{
            ResultSet myres = this.mySQlObject.searchOrder(custid);
            ArrayList<Orderitem> myorder = new ArrayList<Orderitem>();
            while(myres.next()){
                InventoryItem myitem = this.getItem(myres.getInt("item_code"));
                
                Cartitem mitem = new Cartitem(myitem.getItem_code(),myitem.getDescription(),myres.getInt("order_qty"),myres.getInt("order_rate"));
                Orderitem morder = new Orderitem(myres.getInt("ordernumber"),myres.getInt("custid"),mitem,myres.getString("order_date"),myres.getString("order_status"));
                myorder.add(morder);
            }
            Orderitem[] o = new Orderitem[myorder.size()];
            myorder.toArray(o);
            return o;
        }catch(SQLException | ItemNotFound e){
            throw new DAOException();
        }
    }
    //place order
    public void placeOrder(Shoppingcart mycart,int custid)throws DAOException{
        try{
            for(Cartitem c : mycart.getAllCartItem()){
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                    Date date = new Date();
                    String curdate = dateFormat.format(date);
                    InventoryItem mitem = this.getItem(c.getItemcode());
                    //System.out.println(c.getOrderqty() + " " + mitem.getStock());
                    if( c.getOrderqty() <= mitem.getStock())
                        this.mySQlObject.placeOrder(custid, c.getItemcode(), c.getOrderqty(), c.getOrderrate(), curdate, mycart.getCarno());
            }
        }catch(SQLException | ItemNotFound e){
            e.printStackTrace();
            throw new DAOException();
        }
    }
    public void placeOrder(Cartitem c,int cartno,int custid)throws DAOException{
        try{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            Date date = new Date();
            String curdate = dateFormat.format(date);
            InventoryItem mitem = this.getItem(c.getItemcode());
            if( c.getOrderqty() <= mitem.getStock())
                this.mySQlObject.placeOrder(custid, c.getItemcode(), c.getOrderqty(), c.getOrderrate(), curdate, cartno);
        
        }catch(SQLException | ItemNotFound e){
            e.printStackTrace();
            throw new DAOException();
        }
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
   
    //Check Item into Shopping cart
    public void checkShoppingCart(int custid,int item_code,int qty,int or)throws DAOException{
        try{
            ResultSet myres = this.mySQlObject.checkCart(custid, item_code);
            if(myres.next()){
                int newqty = myres.getInt("order_qty")+qty;
                this.mySQlObject.updateCart(custid, item_code, newqty);
            }else{
                ResultSet res = this.mySQlObject.searchCartCustomerid(custid);
                if(res.next()){
                    int cartid=res.getInt("cartid");
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                    Date date = new Date();
                    String curdate = dateFormat.format(date);
                    this.mySQlObject.insertCart(cartid, item_code, qty, or,curdate , custid);
                }
                else{
                    Shoppingcart mycart = new Shoppingcart();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                    Date date = new Date();
                    String curdate = dateFormat.format(date);
                    this.mySQlObject.insertCart(mycart.getCarno(), item_code, qty, or,curdate , custid);
                }
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
            //throw new DAOException();
        }
    }
    //Shopping cart
    public Shoppingcart searchShoppingcart(int custid)throws DAOException{
        try{
            ResultSet myres = this.mySQlObject.searchShoppingcart(custid);
            if(myres.next()){
                
                int cartid = myres.getInt("cartid");
                Shoppingcart mycart = new Shoppingcart(cartid);
                InventoryItem myitem1 = this.getItem(myres.getInt("item_code"));
                Cartitem item1 = new Cartitem(myres.getInt("item_code"),myitem1.getDescription(),myres.getInt("order_qty"),myres.getInt("order_rate"));
                mycart.addItem(item1);
                while(myres.next()){
                    System.out.println(myres.getInt("item_code"));
                    InventoryItem myitem = this.getItem(myres.getInt("item_code"));
                    
                    Cartitem item = new Cartitem(myres.getInt("item_code"),myitem.getDescription(),myres.getInt("order_qty"),myres.getInt("order_rate"));
                    mycart.addItem(item);
                }
                return mycart;
            }
            else{
                return null;
            }
        }catch(SQLException | ItemNotFound e){
            e.printStackTrace();
            throw new DAOException();
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
    //Delete Category 
    public void deleteCategory(int cateid)throws DAOException{
        try{
            this.mySQlObject.deleteCategory(cateid);
        }catch(SQLException e){
            throw new DAOException();
        }
    }
    //Add Category 
    public void addCategory(InventoryCategory category)throws DAOException{
        try{
            this.mySQlObject.insertCategory(category);
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
            InventoryItem[] myitem = new InventoryItem[findInventory.size()];
            findInventory.toArray(myitem);
            return myitem;
        }catch(SQLException | ItemNotFound e){
            throw new DAOException();
        }
    }
    //Search By Category Id 
    public InventoryCategory myCategory(int cate_id)throws DAOException{
        try{
            return this.mySQlObject.searchCategoryById(cate_id);
        }catch(SQLException | ItemNotFound e){
            throw new DAOException();
        }
    }
    //update category
    public void updateCategory(InventoryCategory category)throws DAOException{
        try{
            this.mySQlObject.updateCategory(category);
        }catch(SQLException e){
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
