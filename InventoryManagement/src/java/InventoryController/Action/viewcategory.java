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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhiral
 */
public class viewcategory implements ActionInterface{

    @Override
    public String actionPerfrom(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InventoryDAO invDAO = (InventoryDAO)request.getServletContext().getAttribute("InventoryDAO");
        try{
            int cate_no = Integer.parseInt(request.getParameter("cateid"));
            InventoryItem[] myitem = invDAO.getItemsCategory(cate_no);
            request.setAttribute("myitem_category", myitem);
            request.setAttribute("display", "test3");
            //System.out.println(myitem[0].getDescription());
            return "view.jsp";
            
        }catch(DAOException | NullPointerException e){
            return null;
        }
    }
    
}
