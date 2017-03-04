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
public class DAOException extends Exception{
      public DAOException(String s){
          super(s);
      }
      public DAOException(){
          super("DAO Exception Throws");
      }
}
