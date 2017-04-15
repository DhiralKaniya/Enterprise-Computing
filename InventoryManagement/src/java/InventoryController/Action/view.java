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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class view implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO invDAO = (InventoryDAO)request.getServletContext().getAttribute("InventoryDAO");
        try{
            InventoryItem[] myitem = invDAO.getItem();
            request.setAttribute("myitem", myitem);
            InventoryCategory[] mycate = invDAO.viewCategory();
            request.setAttribute("mycate", mycate);
            return "view.jsp";
        }catch(DAOException e){
            return null;
        }
    }
    
}
