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
public class str_stack {
    public static void main(String[] args){
        //for String type Stack
        Stack<String> stack = new Stack<String>();
        stack.push("Hello World");
        stack.push("My Name");
        stack.push("My World");
        stack.push("Object");
        System.out.println("Peek variable :- "+stack.peek());
        System.out.println("POP :-"+stack.pop());
        System.out.println("POP 2 :- "+stack.pop());
        
        //For Triangle type stack
        Stack<Triangle> tri_stack = new Stack<Triangle>();
        tri_stack.push(new Triangle(10,20,30));
        tri_stack.push(new Triangle(100,200,300));
        System.out.println("Peek Triangle's Area :- " );
        Triangle t = tri_stack.peek();
        System.out.println(t.area());
        System.out.println("POP Triangle's Area:-");
        Triangle t1 = (Triangle) tri_stack.pop();
        System.out.println(t1.area());
 
    }
}
