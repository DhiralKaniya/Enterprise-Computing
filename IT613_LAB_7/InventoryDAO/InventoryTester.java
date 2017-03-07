/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO;
import java.io.PrintStream;
import java.util.Scanner;
import java.sql.SQLException;
import UserDefineException.DBConnect;
import UserDefineException.ItemNotFound;
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
public class InventoryTester {
    public static void main(String[] args) throws SQLException,DBConnect{
        //Object/Variable Initialization
        PrintStream stdout = System.out;
        Scanner stdin = new Scanner(System.in);
        int n = 1,a=1;
        //Object of InventoyDAO
        InventoryMysql IDAO = new InventoryMysql();
        /*dbConnect testing = new dbConnect();
        testing.testingInsert();*/
        //View for console 
        
        while(n!=0){
            stdout.println("1 :- Inventory Item");
            stdout.println("2 :- Category ");
            stdout.println("0 :- Exit ");
            n = stdin.nextInt();
            switch(n){
                case 1 : 
                    
                    //Inventory Management
                    stdout.println("1 :- Insert Inventory ");
                    stdout.println("2 :- Update Inventory ");
                    stdout.println("3 :- Delete Inventory ");
                    stdout.println("4 :- View All Inventory ");
                    stdout.println("5 :- Search Inventory By item_code");
                    stdout.println("6 :- Search Inventory By category ");
                    a = stdin.nextInt();
                    switch(a){
                        case 1 ://insert inventory
                            stdin.nextLine();
                            stdout.println("Enter Inventory Name/description");
                            String inv_name = stdin.nextLine();
                            stdout.println("Enter Qty in stock");
                            int inv_qis = stdin.nextInt();
                            stdout.println("Enter Min Required Quantity");
                            int inv_mr = stdin.nextInt();
                            stdout.println("Enter Cost of Item");
                            int cost = stdin.nextInt();
                            //display all available category
                            ArrayList<InventoryCategory> dis_cat= IDAO.searchAllCategory();
                            stdout.println("****==All Available Category==****");
                            stdout.println("Cate_id || Cate_Name");
                            for(InventoryCategory ic : dis_cat){
                                System.out.println(ic.getCategoryId()+" || "+ic.getCategoryName());
                            }
                            stdout.println("Enter Category id");
                            int inv_cate_id = stdin.nextInt();
                            try{
                                InventoryCategory inv_category = IDAO.searchCategoryById(inv_cate_id);
                                InventoryItem newItem = new InventoryItem(inv_name,inv_qis,inv_mr,cost,inv_category);
                                IDAO.insertItem(newItem);
                            }catch(ItemNotFound e){
                                System.out.println(e);
                            }
                            break;
                        case 2 ://update inventory
                            stdout.println("Enter Item_code ");
                            int upd_inv = stdin.nextInt();
                            try{
                                InventoryItem upd = IDAO.searchItemByItemCode(upd_inv);
                                int b = 1;
                                
                                while(b!=0){
                                    stdout.println("Item_code :- " + upd.getItem_code()+ " || Item_description :- " + upd.getDescription() + " || Qty in stock :- " + upd.getStock() + " || Min Quantity :- " + upd.getMinRequiredQty() + " || Cost of Item :- " + upd.getCost() + " || Item Category :- " + upd.getCategory().getCategoryName());
                                    stdout.println("1 :- update Item Description\n2:- Update Qty\n3 :- Update Minimum Requirement\n4 :- Update Cost\n0 :- Exit");
                                    b = stdin.nextInt();
                                    switch(b){
                                        case 1 ://description
                                            stdin.nextLine();
                                            stdout.println("Enter New Description ");
                                            String newDesc = stdin.nextLine();
                                            upd.setItem_description(newDesc);
                                            break;
                                        case 2 ://Quantity
                                            stdout.println("Enter New Total Quantity ");
                                            int newQty = stdin.nextInt();
                                            upd.setQty_in_stock(newQty);
                                            break;
                                        case 3 ://Min Quantity
                                            stdout.println("Enter New Minimum Quantity ");
                                            int newMinQty = stdin.nextInt();
                                            upd.setMin_required_stock(newMinQty);
                                            break;
                                        case 4 ://new Cost
                                            stdout.println("Enter New Cost ");
                                            int newCost = stdin.nextInt();
                                            upd.setStock(newCost);
                                            break;
                                        case 0:
                                            stdout.println("Thank you ..!!");
                                            break;
                                        default:
                                            stdout.println("Opps Wrong Input ..!!!");
                                            break;
                                    }
                                    IDAO.updateItem(upd); 
                                }
                            }catch(ItemNotFound e){
                                System.out.println(e);
                            }
                            
                            
                            break;
                        case 3 ://delete inventory
                            stdout.println("Enter Item_code");
                            int dele_item = stdin.nextInt();
                            IDAO.deleteItem(dele_item);
                            
                            break;
                        case 4 ://view all inventory
                            ArrayList<InventoryItem> allInventory = IDAO.searchAllItem();
                            for(InventoryItem i : allInventory){
                                stdout.println("Item_code :- " + i.getItem_code()+ " || Item_description :- " + i.getDescription() + " || Qty in stock :- " + i.getStock() + " || Min Quantity :- " + i.getMinRequiredQty() + " || Cost of Item :- " + i.getCost() + " || Item Category :- " + i.getCategory().getCategoryName());
                            }
                            break;
                        case 5 : //search by item code
                            stdout.println("Enter Item_code");
                            int search_id = stdin.nextInt();
                            try{
                                InventoryItem searchedItem = IDAO.searchItemByItemCode(search_id);
                                stdout.println("Item_code :- " + searchedItem.getItem_code()+ " || Item_description :- " + searchedItem.getDescription() + " || Qty in stock :- " + searchedItem.getStock() + " || Min Quantity :- " + searchedItem.getMinRequiredQty() + " || Cost of Item :- " + searchedItem.getCost() + " || Item Category :- " + searchedItem.getCategory().getCategoryName());
                            }catch(ItemNotFound e){
                                stdout.println(e);
                            }
                            break;
                        case 6 : //search by category
                            stdout.println("Enter Category Id");
                            int search_cate_id = stdin.nextInt();
                            try{
                                ArrayList<InventoryItem> searchedItem = IDAO.searchItemByCatId(search_cate_id);
                                for(InventoryItem i : searchedItem){
                                stdout.println("Item_code :- " + i.getItem_code()+ " || Item_description :- " + i.getDescription() + " || Qty in stock :- " + i.getStock() + " || Min Quantity :- " + i.getMinRequiredQty() + " || Cost of Item :- " + i.getCost() + " || Item Category :- " + i.getCategory().getCategoryName());
                            }
                            }catch(ItemNotFound e){
                                stdout.println(e);
                            }
                            break;
                        default:
                            stdout.println("Invalid Input");
                            break;
                    }
                    
                    break;
                case 2 :
                    
                    //Category Management
                    stdout.println("1 :- Insert category ");
                    stdout.println("2 :- Update category ");
                    stdout.println("3 :- Delete category ");
                    stdout.println("4 :- View All category ");
                    stdout.println("5 :- Search category By Id");
                    a = stdin.nextInt();
                    switch(a){
                        case 1:
                            
                            //Insert Category 
                            stdin.nextLine();
                            stdout.println("Enter Category Name");
                            String category_name = stdin.nextLine();
                            InventoryCategory newCategory = new InventoryCategory(0,category_name);
                            IDAO.insertCategory(newCategory);
                           
                            break;
                        case 2:
                            //Update Category 
                            
                            stdout.println("Enter Category Id for Update");
                            int upd_cate_id = stdin.nextInt();
                            stdin.nextLine();
                            try{
                                InventoryCategory upd_ic = IDAO.searchCategoryById(upd_cate_id);
                                upd_ic.setCategoryId(upd_cate_id);
                                System.out.println("****==Old Data==****");
                                System.out.println(upd_ic.getCategoryName());
                                
                                stdout.println("Etner New Category Name");
                                String upd_cate_name = stdin.nextLine();
                                upd_ic.setCategoryName(upd_cate_name);
                                IDAO.updateCategory(upd_ic);
                            }catch(ItemNotFound e){
                                System.out.println(e);
                            }   
                            
                            
                            break;
                        case 3://Delete Category
                            
                            stdout.println("Enter Category Id for Delete");
                            int del_cate_id = stdin.nextInt();
                            IDAO.deleteCategory(del_cate_id);
                            
                            break;
                        case 4://View All Category
                            ArrayList<InventoryCategory> ico= IDAO.searchAllCategory();
                            stdout.println("Cate_id || Cate_Name");
                            for(InventoryCategory ic : ico){
                                System.out.println(ic.getCategoryId()+" || "+ic.getCategoryName());
                            }
                            break;
                        case 5://Search by Cate_id
                            stdout.println("Enter Category Id Which you want search");
                            int ser_cate_id = stdin.nextInt();
                            try{
                                InventoryCategory searchCategory = IDAO.searchCategoryById(ser_cate_id);
                                stdout.println(searchCategory.getCategoryName());
                            }catch(ItemNotFound e){
                                System.out.println(e);
                            }

                            break;
                        default:
                            stdout.println("Opps Invalid Input Try Again ..!!");
                            break;
                    }
                    break;
                case 0:
                        stdout.println("Thank You !!!!");
                    break ;
                default :
                        System.out.println("Oopps Wrong Input .!!!");
                    break;
                           
            }
        }
    }
}
