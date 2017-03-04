/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO;

/**
 *
 * @author dhiral
 */
public class InventoryCategory {
    private int cate_id;
    private String cate_name;
    public InventoryCategory(int cate_id , String cate_name){
        this.cate_id = cate_id;
        this.cate_name = cate_name;
    }
    public void setCategoryId(int cate_id){
        this.cate_id = cate_id;
    }
    public int getCategoryId(){
        return this.cate_id;
    }
    public String getCategoryName(){
        return this.cate_name;
    }
    public void setCategoryName(String cate_name){
        this.cate_name = cate_name;
    }
}
