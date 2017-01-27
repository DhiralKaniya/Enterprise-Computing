/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.lang.Object;
import java.lang.Comparable;
import java.io.PrintStream;
/**
 *
 * @author dhiral
 */
public class BST {
    BinaryNode root;
    Object obj;
    public BST(){
        root = null;
    }
    public Object get(Comparable theKey){
      Object temp = get(theKey,root);
      return temp;
    }
    public Object get(Comparable theKey,BinaryNode node){
        if(node == null || theKey.compareTo(node.gettheKey()) == 0){
            return node.getNode();
        }
        else{
            if(theKey.compareTo(node.gettheKey()) < 0)
                return get(theKey,node.getLeft());
            else
                return get(theKey,node.getRight());
        }
    }
    //Put Method
    public void put(Comparable theKey,Object x){
            root = put(theKey,x,root);
    }
    public BinaryNode put(Comparable theKey,Object x,BinaryNode node){
        if(node == null)
        {
              node = new BinaryNode(theKey,x);
        }
        else
        {   
            //System.out.println(theKey.compareTo(node.gettheKey()));
            if(theKey.compareTo(node.gettheKey()) < 0)
            {
                node.setLeft(this.put(theKey, x, node.getLeft()));
            }
            else
            {
                node.setRight(this.put(theKey, x, node.getRight()));
            }
        }
        //System.out.println(theKey +"-> "+ node.gettheKey());
        return node;
    }
    
    public boolean isEmpty(){
        if(root == null)
            return true;
        else 
            return false;
    }
    public void preOrderOutput(PrintStream out){
        preOrderOutput(out,root);
    }
    public void preOrderOutput(PrintStream out,BinaryNode node){
        if(node != null){
            try{
                out = new PrintStream(System.out);
                out.println("Key is "+ node.gettheKey());
                Book bk = (Book)node.getNode();
                bk.print();
            }catch(Exception e){
                return ;
            }
            preOrderOutput(out,node.getLeft());
            preOrderOutput(out,node.getRight());
        }
    }
    public void inOrderOutput(PrintStream out)
    {
        //System.out.println(root.gettheKey());
        inOrderOutput(out,root);
    }
    public void inOrderOutput(PrintStream out,BinaryNode node){
        //System.out.println(node.gettheKey());
        if(node!= null){
            inOrderOutput(out,node.getLeft());
            try{
                System.out.println("----------------------------");
                out = new PrintStream(System.out);
                out.println("Key is "+node.gettheKey());
                Book bk = (Book)node.getNode();
                bk.print();
            }catch(Exception e){
                System.out.println("Hello");
                return ;
            }
            inOrderOutput(out,node.getRight());
        }
    }
    public void postOrderOutput(PrintStream out){
        postOrderOutput(out,root);
    }
    public void postOrderOutput(PrintStream out,BinaryNode node){
        if(node != null){
            postOrderOutput(out,node.getLeft());
            postOrderOutput(out,node.getRight());
            try{
                out = new PrintStream(System.out);
                out.println("Key is "+ node.gettheKey());
                Book bk = (Book)node.getNode();
                bk.print();
            }catch(Exception e){
                return ;
            }
        }
    }
    public void printdata(){
        System.out.println(root.getLeft() + " " + root.getRight());
    }
}
