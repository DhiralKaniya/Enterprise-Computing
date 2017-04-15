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
public class Customer {
    private int custid ;
    private String custName;
    private String contactno;
    private String emailid;
    private String password;
    public Customer(int custid , String custName,String contactno,String emailid,String password){
        this.custName=custName;
        this.custid=custid;
        this.emailid=emailid;
        this.contactno=contactno;
        this.password=password;
    }
    public Customer(String custName,String contactno,String emailid,String password){
        this.custName=custName;
        this.custid=0;
        this.emailid=emailid;
        this.contactno=contactno;
        this.password=password;
    }
    public int getCustid(){
        return this.custid;
    }
    public String getCustName(){
        return this.custName;
    }
    public String getContactno(){
        return this.contactno;
    }
    public String getEmailid(){
        return this.emailid;
    }
    public String getPassword(){
        return this.password;
    }
}  
