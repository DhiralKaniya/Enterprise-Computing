/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dhiral
 */
public class Employee {
    private int empid;
    private String empname;
    private double empsalary;
    private int department;
    public Employee(int empid,String empname,double empsalary){
        this.empid = empid;
        this.empname=empname;
        this.empsalary=empsalary;
        this.department=0;
    }
    public Employee(int empid,String empname,double empsalary,int department){
        this.empid = empid;
        this.empname=empname;
        this.empsalary=empsalary;
        this.department=department;
    }
    public int getEmpid(){
        return this.empid;
    }
    public String getEmpname(){
        return this.empname;
    }
    public double getEmpsalary(){
        return this.empsalary;
    }
    public int getDepartment(){
        return this.department;
    }
}
