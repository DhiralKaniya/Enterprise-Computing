/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDefineException;

/**
 *
 * @author dhiral
 */
public class ItemExists extends Exception{
    public ItemExists(String s){
        super(s);
    }
    public ItemExists(){
        super("Item Already Exists");
    }
}
