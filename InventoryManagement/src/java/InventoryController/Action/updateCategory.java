/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController.Action;

import InventoryController.ActionInterface;
import InventoryDAO1.InventoryDAO;
import InventoryDAO1.InventoryCategory;
import UserDefineException1.DAOException;
import UserDefineException1.ItemNotFound;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class updateCategory implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO myDAO = (InventoryDAO) request.getServletContext().getAttribute("InventoryDAO");
        try{
             int cate_id = Integer.parseInt(request.getParameter("item_cate"));
             String cate_name = request.getParameter("cate_name");
             InventoryCategory mycategory = new InventoryCategory(cate_id,cate_name);
             myDAO.updateCategory(mycategory);
             
             request.setAttribute("mycategory", mycategory);
             return "categoryHome";
        }catch(DAOException e){
            return null;
        }
    }
    
}
