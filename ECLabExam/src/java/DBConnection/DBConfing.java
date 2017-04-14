/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

/**
 *
 * @author dhiral
 */
public interface DBConfing {
    //String DB_DRIVER = "org.postgresql.Driver";
    String DB_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/Currency?autoReconnect=true&useSSL=false";
    //String DB_URL = "jdbc:postgresql://localhost:3306/Employee";
    String DB_USER = "root";
    String DB_PASS = "root";
}
