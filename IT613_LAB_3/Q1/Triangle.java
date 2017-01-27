/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author dhiral
 */
public class Triangle {
    public Triangle() {          
        resize(0,0,0); 
    }
    public Triangle(double a, double b, double c) { 
        resize(a,b,c); 
    }
    public void resize(double new_a, double new_b, double new_c) { 
        double s = (new_a+new_b+new_c)/2; 
        if ( ((s-new_a) * (s-new_b) * (s-new_c)) < 0 ) 
            throw new RuntimeException("Given data do not make a Triangle"); 
        a = new_a; 
        b = new_b; 
        c = new_c;         
    }
    public double area() { 
        double area, s; 
        s = (a+b+c)/2; 
        area = Math.sqrt(s *(s-a) * (s-b) * (s-c)); 
        return area; 
    }
    public double perimeter() { 
        double p; 
        p = a+b+c; 
        return p; 
    }
    public double getA(){ 
        return a; 
    }
    public double getB(){ 
        return b; 
    }
    public double getC(){ 
        return c; 
    }
    private double a; 
    private double b; 
    private double c; 
    
}
