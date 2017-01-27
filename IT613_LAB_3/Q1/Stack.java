/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
public class Stack<T>{
    //T data;
    ArrayList<T> data;
    int top;
    public Stack(){
        data = new ArrayList<T>();
        top = -1;
    }
    public void push(T s){
        top+=1;
        data.add(top, s);
    }
    public T peek(){
        return data.get(top);
    }
    public Object pop(){
        T temp = data.remove(top);
        top-=1;
        return temp;
    }
    public boolean isEmpty(){
        if(top<0)
            return true;
        else
            return false;
    }
}
