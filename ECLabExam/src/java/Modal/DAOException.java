/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author dhiral
 */
public class DAOException extends Exception{
    public DAOException(){
        super("DAOException is called..!!");
    }
    public DAOException(String str){
        super(str);
    }
}
