/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.lang.Object;
import java.lang.Comparable;
/**
 *
 * @author dhiral
 */
public class BinaryNode {
    private Object node;
    private Comparable theKey;
    public BinaryNode right;
    public BinaryNode left;
    public BinaryNode(Comparable theKey,Object node){
        this.theKey = theKey;
        this.node = node;
        this.right = null;
        this.left = null;
    }
    public Comparable gettheKey(){
            return this.theKey;
    }
    public Object getNode(){
        return this.node;
    }
    public BinaryNode getRight(){
        return this.right;
    }
    public BinaryNode getLeft(){
        return this.left;
    }
    public void setRight(BinaryNode right){
        this.right = right;
    }
    public void setLeft(BinaryNode left){
        this.left = left;
    }
}
