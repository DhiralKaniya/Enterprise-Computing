/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO1;

import UserDefineException1.DBConnect;
import UserDefineException1.ItemNotFound;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dhiral
 */
public class InventoryMysql {
    private dbConnect dbconn ;
    public InventoryMysql() throws DBConnect{
        dbconn = new dbConnect();
    }
    //Search Item From the Inventory Item
    /*
         This function is for the testing purpose of the 
        dbConnect Class
    */
    private ResultSet searchItem() throws SQLException{
        this.dbconn.setPreparedStatement("search_tbl_Inventory",0);
        this.dbconn.executeProcedure();
        ResultSet myRes = this.dbconn.getResult();
        return myRes;
    }
    /*
        Item inventory which given in the assignment
    */
    
    //Insert Item into the Inventory table
    public void insertItem(InventoryItem items) throws SQLException,NullPointerException{
        //Create Prepared Statement
        this.dbconn.setPreparedStatement("insert_tbl_inventory",5 );
        
        //Set Parameter to the procedure
        this.dbconn.setParaMeter(1,items.getDescription());
        this.dbconn.setParaMeter(2,items.getStock());
        this.dbconn.setParaMeter(3,items.getMinRequiredQty());
        this.dbconn.setParaMeter(4,items.getCost());
        System.out.println(items.getCategory().getCategoryId());
        this.dbconn.setParaMeter(5,items.getCategory().getCategoryId());
        
        //Execute the procedure
        this.dbconn.executeUpdateProcedure();
    }
    //Update Item into the Inventory Table
    public void updateItem(InventoryItem items) throws SQLException{
        //Create Prepared Statement
        this.dbconn.setPreparedStatement("update_tbl_inventory", 6);
        
        //Set Parameter to the procedure
        this.dbconn.setParaMeter(1,items.getItem_code());
        this.dbconn.setParaMeter(2,items.getDescription());
        this.dbconn.setParaMeter(3,items.getStock());
        this.dbconn.setParaMeter(4,items.getMinRequiredQty());
        this.dbconn.setParaMeter(5,items.getCost());
        this.dbconn.setParaMeter(6,items.getCategory().getCategoryId());
        
        //Execute the procedure
        this.dbconn.executeUpdateProcedure();
    }
    //Delete Item into the Inventory Table
    public void deleteItem(int item_code)throws SQLException{
        //Create Prepared Statement
        this.dbconn.setPreparedStatement("delete_tbl_inventory", 1);
        //set Parameter
        this.dbconn.setParaMeter(1, item_code);
        //Execute the Procedure
        this.dbconn.executeUpdateProcedure();
    }
    //Place Order
    public void placeOrder(int custid,int ic,int qty,int rate,String od,int cartno)throws SQLException{
        this.dbconn.setPreparedStatement("place_Order", 8);
        //set Parameter
        this.dbconn.setParaMeter(1, custid);
        this.dbconn.setParaMeter(2, ic);
        this.dbconn.setParaMeter(3, qty);
        this.dbconn.setParaMeter(4, rate);
        this.dbconn.setParaMeter(5, od);
        this.dbconn.setParaMeter(6, qty*rate);
        this.dbconn.setParaMeter(7, "Ordered");
        System.out.println(cartno);
        this.dbconn.setParaMeter(8,cartno);
        //Execute the Procedure
        this.dbconn.executeUpdateProcedure();
    }
    //Delete item from the cart
    public void deleteFromcart(int cartid,int ic,int custid)throws SQLException{
        this.dbconn.setPreparedStatement("delete_tbl_ShoppingcartByCust", 3);
        //set Parameter
        this.dbconn.setParaMeter(1, cartid);
        this.dbconn.setParaMeter(2, ic);
        this.dbconn.setParaMeter(3, custid);
        //Execute the Procedure
        this.dbconn.executeUpdateProcedure();
    }
    //Search order of Customer
    public ResultSet searchOrder(int custid)throws SQLException{
        this.dbconn.setPreparedStatement("search_tbl_OrderByCid",1);
        this.dbconn.setParaMeter(1, custid);
        this.dbconn.executeProcedure();
        return this.dbconn.getResult();
    }
    //Search all item from the inventory table
    public ArrayList<InventoryItem> searchAllItem()throws SQLException{
        //create Prepared Statement
        this.dbconn.setPreparedStatement("search_tbl_Inventory",0);
        //execute Procedure
        this.dbconn.executeProcedure();
        //get Result set and convert into Arraylist
        ResultSet myRes = this.dbconn.getResult();
        ArrayList<InventoryItem> searchItems = new ArrayList<InventoryItem>();
        while(myRes.next()){
            try{
            InventoryCategory searchCategory = this.searchCategoryById(myRes.getInt("cate_id"));
            searchItems.add(new InventoryItem(myRes.getInt("item_code"),myRes.getString("item_description"),myRes.getInt("qty_in_stock"),myRes.getInt("min_required_stock"),myRes.getInt("cost"),searchCategory));

            }catch(ItemNotFound e){
                continue;
            }
        }
        return searchItems;
    }
    //Search Shopping cart
    public ResultSet searchShoppingcart(int custid)throws SQLException{
        this.dbconn.setPreparedStatement("search_tbl_ShoppingcartByCustomerId", 1);
        this.dbconn.setParaMeter(1, custid);
        this.dbconn.executeUpdateProcedure();
        return this.dbconn.getResult();
    }
    //Pagination search
    public InventoryItem[] searchInventoryWithPagination(int st,int en)throws SQLException{
        //Create Statement
        this.dbconn.setPreparedStatement("search_tbl_Inventory_with_pagination", 2);
        //set Parameter
        this.dbconn.setParaMeter(1, st);
        this.dbconn.setParaMeter(2, en);
        //execute Process
        this.dbconn.executeProcedure();
        //get Resutl Set
        ResultSet myRes = this.dbconn.getResult();
        ArrayList<InventoryItem> findData = new ArrayList<InventoryItem>();
        while(myRes.next()){
            try{
                InventoryCategory searchCategory = this.searchCategoryById(myRes.getInt("cate_id"));
                findData.add(new InventoryItem(myRes.getInt("item_code"),myRes.getString("item_description"),myRes.getInt("qty_in_stock"),myRes.getInt("min_required_stock"),myRes.getInt("cost"),searchCategory));
            }catch(ItemNotFound e){
                continue;
            }
        }
        InventoryItem[] findedData = new InventoryItem[findData.size()];
        findData.toArray(findedData);
        return findedData;
    }
    //isUnder Items
    public InventoryItem[] searchUnderItem()throws SQLException{
        //create Prepared Statement
        this.dbconn.setPreparedStatement("items_under_stock",0);
        //execute Procedure
        this.dbconn.executeProcedure();
        //get Result set and convert into Arraylist
        ResultSet myRes = this.dbconn.getResult();
        ArrayList<InventoryItem> searchItems = new ArrayList<InventoryItem>();
        while(myRes.next()){
            try{
            InventoryCategory searchCategory = this.searchCategoryById(myRes.getInt("cate_id"));
            searchItems.add(new InventoryItem(myRes.getInt("item_code"),myRes.getString("item_description"),myRes.getInt("qty_in_stock"),myRes.getInt("min_required_stock"),myRes.getInt("cost"),searchCategory));

            }catch(ItemNotFound e){
                continue;
            }
        }
        InventoryItem[] findedData = (InventoryItem[]) searchItems.toArray();
        return findedData;
    }
    //Search with item_code item from the inventory table 
    public InventoryItem searchItemByItemCode(int item_code)throws SQLException,ItemNotFound{
        //create Prepared Statement
        this.dbconn.setPreparedStatement("search_tbl_inventory_by_item_code",1);
        //set the parameter
        this.dbconn.setParaMeter(1, item_code);
        //execute Procedure
        this.dbconn.executeProcedure();
        //get Result set and convert into Arraylist
        ResultSet myRes = this.dbconn.getResult();
        while(myRes.next()){
            try{
                InventoryCategory searchCategory = this.searchCategoryById(myRes.getInt("cate_id"));
                return new InventoryItem(myRes.getInt("item_code"),myRes.getString("item_description"),myRes.getInt("qty_in_stock"),myRes.getInt("min_required_stock"),myRes.getInt("cost"),searchCategory);                
            }catch(ItemNotFound e){
                break;
            }
        }
        throw new ItemNotFound();
    }
    //Search item with category_id from the Inventory table
    public ArrayList<InventoryItem> searchItemByCatId(int cate_id)throws SQLException,ItemNotFound{
         //create Prepared Statement
        this.dbconn.setPreparedStatement("search_tbl_inventory_by_category_id",1);
        //Set parameter
        this.dbconn.setParaMeter(1,cate_id);
        //execute Procedure
        this.dbconn.executeProcedure();
        //get Result set and convert into Arraylist
        ResultSet myRes = this.dbconn.getResult();
        ArrayList<InventoryItem> searchItems = new ArrayList<InventoryItem>();
        while(myRes.next()){
            try{
            InventoryCategory searchCategory = this.searchCategoryById(myRes.getInt("cate_id"));
            searchItems.add(new InventoryItem(myRes.getInt("item_code"),myRes.getString("item_description"),myRes.getInt("qty_in_stock"),myRes.getInt("min_required_stock"),myRes.getInt("cost"),searchCategory));

            }catch(ItemNotFound e){
                continue;
            }
        }
        return searchItems;
    }
    //get total inventory Cost
    public int totalInventoryCost()throws SQLException{
        //create prepared Statement
        this.dbconn.setPreparedStatement("total_inventory_cost",0);
        //Execute Procedure
        this.dbconn.executeProcedure();
        //take into the result set
        ResultSet myRes = this.dbconn.getResult();
        int total = 0;
        while(myRes.next()){
            total+= myRes.getInt("TOTAL");
        }
        return total;
    }
    /*Category Procedure Portion */
    //Insert Category Into the Database
    public void insertCategory(InventoryCategory category)throws SQLException{
        //Create Prepared Statement for Inventory Category Insert Procedure
        this.dbconn.setPreparedStatement("insert_tbl_category", 1);
        //Set the parameter for the insert procedure
        this.dbconn.setParaMeter(1, category.getCategoryName());
        //Execute thr procedure
        this.dbconn.executeUpdateProcedure();
    }
    //Update Category Into Database
    public void updateCategory(InventoryCategory category) throws SQLException{
        //Create Prepared Statement for Inventory Category Update Procedure
        this.dbconn.setPreparedStatement("update_tbl_category",2);
        //Set the parameter for the Update procedure
        System.out.println(category.getCategoryId());
        this.dbconn.setParaMeter(1, category.getCategoryId());
        this.dbconn.setParaMeter(2, category.getCategoryName());
        //Execute the Procedure
        this.dbconn.executeProcedure();
    }
    //Delete Category from the databse
    public void deleteCategory(int cate_id) throws SQLException{
        //Create Prepared Statement for Inventory Category Delete Procedure
        this.dbconn.setPreparedStatement("delete_tbl_category",1);
        //Create Parameter for the delete procedure
        this.dbconn.setParaMeter(1, cate_id);
        //Execute The procedure
        this.dbconn.executeProcedure();
    }
    //Search all category from the database with the use of procedure
    public ArrayList<InventoryCategory> searchAllCategory()throws SQLException{
        //Create Prepared Statement for inventory Category Search all procedure
        this.dbconn.setPreparedStatement("search_tbl_category", 0);
        //Execute the procedure
        this.dbconn.executeProcedure();
        //Get the result
        ResultSet myRes = this.dbconn.getResult();
        //Convert Result Set into InventoryCategory array
        ArrayList<InventoryCategory> allCategory = new ArrayList<InventoryCategory>();
        int i = 0;
        while(myRes.next()){
            allCategory.add(new InventoryCategory(myRes.getInt("cate_Id"),myRes.getString("cate_Name")));
            i++;
        }
        return allCategory;
    }
    //Search category from the database with the use of cate_id with procedure 
    public InventoryCategory searchCategoryById(int cate_id)throws SQLException,ItemNotFound{
        //Create Prepared Statement for inventory Category Search all procedure
        this.dbconn.setPreparedStatement("search_tbl_category_by_id", 1);
        //Set Parameter
        this.dbconn.setParaMeter(1, cate_id);
        //Execute the procedure
        this.dbconn.executeProcedure();
        //Get the result
        ResultSet myRes = this.dbconn.getResult();
        //Convert Result Set into InventoryCategory 
        while(myRes.next())
        {
            //System.out.println(myRes.getString("cate_Name"));
            InventoryCategory searchCategory =  new InventoryCategory(myRes.getInt("cate_Id"),myRes.getString("cate_Name"));
            return searchCategory;
        }
        throw new ItemNotFound();
    }
    /*
    Customer Management
    */
    //insert Procedure
    public void insertCustomer(Customer customer)throws SQLException{
        this.dbconn.setPreparedStatement("insert_tbl_Customer", 4);
        this.dbconn.setParaMeter(1, customer.getCustName());
        this.dbconn.setParaMeter(2,customer.getContactno());
        this.dbconn.setParaMeter(3,customer.getEmailid());
        this.dbconn.setParaMeter(4,customer.getPassword());
        this.dbconn.executeUpdateProcedure();
    }
    //search Procedure
    public Customer searchCustomer(String emailid)throws SQLException{
        this.dbconn.setPreparedStatement("search_tbl_CustomerByUsername", 1);
        this.dbconn.setParaMeter(1, emailid);
        this.dbconn.executeProcedure();
        ResultSet myres = this.dbconn.getResult();
        if(myres.next()){
            Customer mycust = new Customer(myres.getInt("customerid"),myres.getString("Name"),myres.getString("contactno"),myres.getString("emailid"),myres.getString("password"));
            return mycust;
        }
        else
        {
            return null;
        }
    }
    //Delete Customer 
    public void deleteCustomer(int custid)throws SQLException{
        this.dbconn.setPreparedStatement("delete_tbl_Customer", 1);
        this.dbconn.setParaMeter(1, custid);
        this.dbconn.executeUpdateProcedure();
    }
    //update Customer 
    public void updateCustomer(Customer customer)throws SQLException{
        this.dbconn.setPreparedStatement("update_tbl_Customer", 5);
        this.dbconn.setParaMeter(1,customer.getCustid());
        this.dbconn.setParaMeter(2,customer.getCustName());
        this.dbconn.setParaMeter(3,customer.getContactno());
        this.dbconn.setParaMeter(4,customer.getEmailid());
        this.dbconn.setParaMeter(5,customer.getPassword());
        this.dbconn.executeUpdateProcedure();
    }
    
    /*
    Shopping Cart
    */
    //search Shopping cart by Customerid
    //check for item is avalilable or not
    public void updateCart(int custid,int item_code,int newqty)throws SQLException{
        this.dbconn.setPreparedStatement("update_tbl_Shoppingcart_qty", 3);
        this.dbconn.setParaMeter(1,item_code);
        this.dbconn.setParaMeter(2,custid);
        this.dbconn.setParaMeter(3,newqty);
        this.dbconn.executeUpdateProcedure();  
    }
    public ResultSet searchCartCustomerid(int custid)throws SQLException{
        this.dbconn.setPreparedStatement("search_tbl_Shoppingcartid", 1);
        this.dbconn.setParaMeter(1, custid);
        this.dbconn.executeProcedure();
        return this.dbconn.getResult();
    }
    public ResultSet checkCart(int custid,int item_code)throws SQLException{
        this.dbconn.setPreparedStatement("search_tbl_ShoppingcartByicust", 2);
        this.dbconn.setParaMeter(1,custid);
        this.dbconn.setParaMeter(2,item_code);
        this.dbconn.executeProcedure();
        return this.dbconn.getResult();
    }
    public void insertCart(int cartid,int item_code,int oq,int or,String od,int custid)throws SQLException{
        this.dbconn.setPreparedStatement("insert_tbl_Shoppingcart", 7);
            this.dbconn.setParaMeter(1, cartid);
            this.dbconn.setParaMeter(2, item_code);
            this.dbconn.setParaMeter(3, oq);
            this.dbconn.setParaMeter(4, or);
            this.dbconn.setParaMeter(5, od);
            this.dbconn.setParaMeter(6, or * oq);
            this.dbconn.setParaMeter(7, custid);
            this.dbconn.executeUpdateProcedure();
    }
    public void insertCart(Shoppingcart sc,Customer cust)throws SQLException{
        for(Cartitem i : sc.getAllCartItem()){
            this.dbconn.setPreparedStatement("insert_tbl_Shoppingcart", 7);
            this.dbconn.setParaMeter(1, sc.getCarno());
            this.dbconn.setParaMeter(2, i.getItemcode());
            this.dbconn.setParaMeter(3, i.getOrderqty());
            this.dbconn.setParaMeter(4, i.getOrderrate());
            this.dbconn.setParaMeter(5, i.getOrderrate());
            this.dbconn.setParaMeter(6, i.getOrderqty() * i.getOrderrate());
            this.dbconn.setParaMeter(7, cust.getCustid());
            this.dbconn.executeUpdateProcedure();
        }
    }
    //Delete whole cart
    public void deleteShoppingcart(Shoppingcart sc)throws SQLException{
        this.dbconn.setPreparedStatement("delete_tbl_Shoppingcart", 1);
        this.dbconn.setParaMeter(1, sc.getCarno());
        this.dbconn.executeUpdateProcedure();
    }
    //Delete particular item from the cart
    public void deleteItemFromShoppingCart(Shoppingcart sc,Cartitem ci,Customer cust)throws SQLException{
        this.dbconn.setPreparedStatement("delete_tbl_shoppingcartICS", 3);
        this.dbconn.setParaMeter(1, ci.getItemcode());
        this.dbconn.setParaMeter(2, cust.getCustName());
        this.dbconn.setParaMeter(3, sc.getCarno());
        this.dbconn.executeUpdateProcedure();
    }
    //view all cartitem of the customer
    public ResultSet searchCart(Customer customer)throws SQLException{
        this.dbconn.setPreparedStatement("search_tbl_ShoppingcartByCustomerId", 1);
        this.dbconn.setParaMeter(1, customer.getCustid());
        this.dbconn.executeProcedure();
        return this.dbconn.getResult();
    }
    
    //set on commit function
    public void onAutoCommit() throws SQLException{
        this.dbconn.autoCommit(Boolean.TRUE);
    }
    //set off commit function
    public void offAutoCommit() throws SQLException{
        this.dbconn.autoCommit(Boolean.FALSE); 
    }
    //RollBack if Requred
    public void rollBack() throws SQLException{
        this.dbconn.rollBack();
    }
    //Commit function
    public void commit()throws SQLException{
        this.dbconn.commit();
    }

}