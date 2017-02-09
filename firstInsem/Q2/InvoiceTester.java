/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insem_exam;

/**
 *
 * @author dhiral
 */
public class InvoiceTester {
    public static void main(String[] args){
        Invoice i = new Invoice("Dhiral",10.0,"07-02-2017");
        Item i1 = new Item(100,10,2,2000);
        Item i2 = new Item(101,10,3,3000);
        i.addItem(i1,5);
        i.addItem(i2,6);
        i.setTaxRate(10.0);
        i.print(System.out);
        
        Invoice new_i = new Invoice("Hardik",10.0,"07-02-2017");
        new_i.addItem(i1,2);
        new_i.addItem(i2,3);
        new_i.setTaxRate(10.0);
        new_i.print(System.out);
    }
}
