/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.InventoryCategory;
import InventoryDAO1.InventoryDAO;
import UserDefineException1.DAOException;
import UserDefineException1.ItemNotFound;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class myCategory implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO myDAO = (InventoryDAO)request.getServletContext().getAttribute("InventoryDAO");
           try{
               //System.out.println("Hello");
               int item_code = Integer.parseInt(request.getParameter("ic"));
               //System.out.println(item_code);
               InventoryCategory mycate = myDAO.myCategory(item_code);
               request.setAttribute("mycate", mycate);
               //System.out.println(mycate.getCategoryName());
               return "CategoryEdit.jsp";
           }catch(DAOException e){
               //e.printStackTrace();
               return null;
           }
    }
    
}
