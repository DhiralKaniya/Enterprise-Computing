/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author dhiral
 */
public class BSTTester {
    public static void main(String[] args){
        BST btree = new BST();
        Book b1 = new Book(121,"ABC",250);
        btree.put(new Integer(121), b1);
        Book b2 = new Book(132,"XYC",290);
        btree.put(new Integer(132), b2);
         Book b3 = new Book(111,"pqr",240);
        btree.put(new Integer(111), b3);
        btree.inOrderOutput( System.out ); 
        Book bk = (Book)btree.get(new Integer(121));
        bk.print();
    }
}
