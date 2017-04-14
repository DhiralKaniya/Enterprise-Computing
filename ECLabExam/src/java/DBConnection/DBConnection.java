/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author dhiral
 */
public class DBConnection {
    //connection final variabl and dbconnect instance
    private final Connection conn;
    private static DBConnection instance =null;
    //Connection methods 
    public DBConnection() throws ClassNotFoundException,SQLException{
        Class.forName(DBConfing.DB_DRIVER);
        conn = DriverManager.getConnection(DBConfing.DB_URL,DBConfing.DB_USER,DBConfing.DB_PASS);
    }
    
    //get current instance of dbconnection
    public static DBConnection getInstance() throws SQLException,ClassNotFoundException{
        if(instance == null)
            instance  = new DBConnection();
        return instance;
    }
    
    //get connection object
    public Connection getConnection(){
        return conn;
    }
    //set schema 
    public Connection getConnectionSchema(String schema)throws SQLException{
        Statement st = conn.createStatement();
        st.execute("set search_path to "+schema+",public;");
        return conn;
    }
    //close the connection
    public void close()throws SQLException{
        conn.close();
        instance = null;
    }
    
}
