/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.InventoryCategory;
import InventoryDAO1.InventoryDAO;
import InventoryDAO1.InventoryItem;
import UserDefineException1.DAOException;
import UserDefineException1.ItemNotFound;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class viewInventory implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO myDAO = (InventoryDAO)request.getServletContext().getAttribute("InventoryDAO");
           try{
               int item_code = Integer.parseInt(request.getParameter("ic"));
               //System.out.println(item_code);
               InventoryItem myitem = myDAO.getItem(item_code);
               InventoryCategory[] mycate = myDAO.viewCategory();
               request.setAttribute("myitem", myitem);
               request.setAttribute("mycate", mycate);
               System.out.println(myitem.getDescription()); 
               return "Edit.jsp";
           }catch(DAOException | ItemNotFound | ClassCastException e){
               //e.printStackTrace();
               return null;
           }
    }
    
}
