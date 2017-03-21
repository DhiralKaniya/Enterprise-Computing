/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
public class dbconnection {
    
    static String DB_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/Employee?autoReconnect=true&useSSL=false";
    
    static String DB_USER = "root";
    static String DB_PASS = "root";
    Connection con ;
    public dbconnection()throws SQLException{
        //Class.forName(DB_Driver);
        con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        System.out.println("Connection Successfully..");
    }
    public void insertEmployee(Employee e)throws SQLException{
        //create query 
        String qry = "INSERT INTO tbl_employee VALUES(null,'"+e.getEmpname()+"', "+e.getEmpsalary()+","+e.getDepartment()+" )";
        //System.out.println(qry) ;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(qry);
        System.out.println("Record Inserted..!!");
    }
    public ArrayList<Employee> searchEmployee()throws SQLException{
        //create query 
        String qry = "SELECT * FROM tbl_employee";
        //System.out.println(qry) ;
        Statement stmt = con.createStatement();
        ResultSet myres = stmt.executeQuery(qry);
        ArrayList<Employee> myemp = new ArrayList<Employee>();
        while(myres.next()){
            Employee e = new Employee(myres.getInt("empid"),myres.getString("empname"),myres.getDouble("empsalary"),myres.getInt("depid"));
            myemp.add(e);
        }
        System.out.println("Record Inserted..!!");
        return myemp;
    }
}
