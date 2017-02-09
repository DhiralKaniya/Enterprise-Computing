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
public class DailyLimitException extends Exception{
    public DailyLimitException(){
        super("Daily Limit has been Excieed !!");
    }
}
