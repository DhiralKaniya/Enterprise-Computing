/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryDAO;
import java.sql.*;
import UserDefineException.DBConnect;
/**
 *
 * @author dhiral
 */
public class dbConnect {
    private String dbURL;
    static String user = "root";
    static String password = "root";
    private String dbName;
    private Connection myConn;
    private PreparedStatement myStmt ; 
    
    //Default Constructor initialize with Inventory Database
    public dbConnect() throws DBConnect{
        this.dbURL = new String("jdbc:mysql://localhost:3306/");
        this.dbName = new String("Inventory");
        this.dbURL += this.dbName;
        this.dbURL += "?autoReconnect=true&useSSL=false";
        try{
            myConn = DriverManager.getConnection(this.dbURL,user,password);
        }catch(Exception e){
            this.dbConnectError();
        }
    }
    //Testing insert Query
    public void testingInsert() throws SQLException{
        this.myStmt = this.myConn.prepareCall("call insert_tbl_category(?,?)");
        this.myStmt.setInt(1, 3);
        this.myStmt.setString(2,"World");
        this.myStmt.execute();
    }
    //User define connection constructor initialization 
    public dbConnect(String dbURL,String dbName) throws DBConnect{
        this.dbURL = dbURL;
        this.dbName = dbName;
        this.dbURL += this.dbName;
         this.dbURL += "?autoReconnect=true&useSSL=false";
        try{
            myConn = DriverManager.getConnection(this.dbURL,user,password);
        }catch(SQLException e){
            this.dbConnectError();
        }
    }
    //Prepare Procedure Statement
    public void setPreparedStatement(String ProcedureName,int arg) throws SQLException{
        try {
            this.myStmt.clearParameters();
        }catch(NullPointerException e){
            
        }
        String str = "{call " + ProcedureName+"(";
        for(int i=0;i<arg;i++){
            if(i == arg-1)
                str += "?";
            else
                str += "?,";
        }
        str+=")}";
        //System.out.println(str);
        this.myStmt = this.myConn.prepareCall(str);
    }
    //Set Parametter of the Prepare Statement
    public void setParaMeter(int paraNumber , int paraValue) throws SQLException{
        this.myStmt.setInt(paraNumber, paraValue);
    }
    public void setParaMeter(int paraNumber,String paraValue) throws SQLException{
        this.myStmt.setString(paraNumber,paraValue);
    }
    public void setParaMeter(int paraNumber,double paraValue) throws SQLException{
        this.myStmt.setDouble(paraNumber, paraValue);
    }
   
    //Execute update the procedure
    public void executeUpdateProcedure()throws SQLException{
        this.myStmt.executeUpdate();
    }
    //Execute the Procedure
    public void executeProcedure()throws SQLException{
        this.myStmt.execute();
    }
    //get Result of the executatble procedure
    public ResultSet getResult()throws SQLException{
       return this.myStmt.getResultSet();
    }
    //get connection Object
    public Connection getConnection(){
        return this.myConn;
    }
    //Error Functionality
    private void dbConnectError() throws DBConnect{
        throw new DBConnect();
    }
    //Auto Commit Off
    public void autoCommit(Boolean autoCommit)throws SQLException{
        this.myConn.setAutoCommit(autoCommit);
    }
    //Roll Back call
    public void rollBack()throws SQLException{
        this.myConn.rollback();
    }
    //commit the data
    public void commit()throws SQLException{
        this.myConn.commit();
    }
   
}
