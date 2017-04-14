/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;

/**
 *
 * @author dhiral
 */
public class Tester {
    public static void main(String[] args){
        try{
            Connection dbcon = DBConnection.getInstance().getConnection();
            System.out.println("Connection Successfully Done..!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
