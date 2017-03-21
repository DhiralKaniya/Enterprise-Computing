/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConfing;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.PrintStream;
import java.sql.ResultSet;
/**
 *
 * @author dhiral
 */
public class DBConnectTester {
    public static void main(String[] args){
        PrintStream stdout = new PrintStream(System.out);
        try{
            Connection con = DBConnection.getInstance().getConnection();
            String qry = "SELECT * FROM tbl_employee";
            Statement mystmt = con.createStatement();
            ResultSet myres = mystmt.executeQuery(qry);
            while(myres.next()){
                stdout.println(myres.getInt("empid"));
                stdout.println(myres.getString("empname"));
            }
            stdout.println("Connection Successfully");
        }catch(SQLException e){
            stdout.println(e);
        }catch(ClassNotFoundException f){
            stdout.println(f);
        }
    }
}
