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
import UserDefineException1.ItemExists;
import UserDefineException1.ItemNotFound;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class insert implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO invDAO = (InventoryDAO)request.getServletContext().getAttribute("InventoryDAO");
        try{
            
            
            String item_description = request.getParameter("id");
            int qty = Integer.parseInt(request.getParameter("qis"));
            int mr = Integer.parseInt(request.getParameter("mrs"));
            int cost = Integer.parseInt(request.getParameter("cost"));
            int cateid = Integer.parseInt(request.getParameter("cid"));
            System.out.println(cateid);
            InventoryItem myitem = new InventoryItem(0,item_description,qty,mr,cost,cateid);
            invDAO.InsertItem(myitem);
            request.setAttribute("myinventory", invDAO);
            return "view.jsp";
        }catch(DAOException | ItemExists e){
            return null;
        }
    }
    
}
