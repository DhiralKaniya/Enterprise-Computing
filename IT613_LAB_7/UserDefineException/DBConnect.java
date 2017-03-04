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
public class DBConnect extends Exception {
    public DBConnect(){
        super("DB Connection Error has been Occur ..!!");
    }
    public DBConnect(String s){
        super(s);
    }
}
