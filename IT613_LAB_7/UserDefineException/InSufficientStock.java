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
public class InSufficientStock extends Exception {
    public InSufficientStock(String message){
        super(message);
    }
    public InSufficientStock(){
        super("Stock is InSufficient");
    }
}
