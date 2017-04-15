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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class insertCategory implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO myDAO = (InventoryDAO)request.getServletContext().getAttribute("InventoryDAO");
        try{
            String category = request.getParameter("category");
            InventoryCategory mycate = new InventoryCategory(0,category);
            myDAO.addCategory(mycate);
            InventoryCategory[] mycategory = myDAO.viewCategory();
            request.setAttribute("mycategory", mycategory);
            return "category.jsp";
        }catch(DAOException e){
            System.out.println(e);
            return null;
        }
    }
    
}
