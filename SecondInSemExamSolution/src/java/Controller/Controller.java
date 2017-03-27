/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Item.*;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletConfig;
import Util.ObjectCreator;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author dhiral
 */
public class Controller extends HttpServlet {
    ItemStore itemstore;
    ShoppingCart mycart;
    @Override
    public void init()throws ServletException{
        itemstore = new ItemStore();
        try{
            itemstore.addItem(new Item(1,"Hello",10,1000));
            itemstore.addItem(new Item(2,"World",10,2000));
        }catch(ItemExists e){
           e.printStackTrace();
        }
        mycart = new ShoppingCart(itemstore);
        getServletContext().setAttribute("mycart",mycart);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter pw = response.getWriter();
            
        
           String actions = request.getParameter("action");
  
           Action myaction = getAction(actions);
           String view = myaction.ActionPerformed(request,response);     
//           pw.println(mycart.getOrderAmoubt());
//           pw.println(view);
            try{
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/"+view);
                rd.forward(request, response);
            }catch(NullPointerException e){
                e.printStackTrace();
            }
    }
    
    public Action getAction(String action)throws ServletException,IOException{
        Properties p = new Properties();
       
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("Controller/myaction.properties");
        try{
            p.load(is);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        String action_class = p.getProperty(action);
        //System.out.println(action_class);
        Action myaction = (Action) ObjectCreator.createObject(action_class);
        return myaction;
       
    }

}
