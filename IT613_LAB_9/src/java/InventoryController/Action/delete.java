/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.InventoryDAO;
import InventoryDAO1.InventoryItem;
import UserDefineException1.DAOException;
import UserDefineException1.ItemNotFound;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class delete implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
           InventoryDAO myDAO = (InventoryDAO)request.getServletContext().getAttribute("InventoryDAO");
           try{
               int item_code = Integer.parseInt(request.getParameter("item_code"));
               myDAO.deleteItem(item_code);
               InventoryItem[] myitem = (InventoryItem[])myDAO.getItem();
               request.setAttribute("myitem", myitem);
               return "view.jsp";
           }catch(DAOException | ItemNotFound e){
               return null;
           }
    }
    
}
