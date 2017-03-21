/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
public class DbTester {
    public static void main(String[] args){
        try{
            dbconnection db = new dbconnection();
            Employee e = new Employee(2,"Mukesh",5000,1);
            db.insertEmployee(e);
            
            ArrayList<Employee> myemp = db.searchEmployee();
            for(Employee a : myemp){
                System.out.println("Empid => "+a.getEmpid() + " || EmpName " + a.getEmpname());
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
