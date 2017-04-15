/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryController;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dhiral
 */
public class Authentication implements Filter {
    
    private static final boolean debug = true;

  
    private FilterConfig filterConfig = null;
    
    public Authentication() {
    }    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest myreq = (HttpServletRequest)request;
        String username = (String)myreq.getSession().getAttribute("username");
        String action = request.getParameter("action");
        if(action==null)
            action = "view.jsp";
        if(username != null || action.compareTo("login")==0 || action.compareTo("loginvalidation")==0 || action.compareTo("register")==0 ){
            if(username != "admin"){
                
            }
            chain.doFilter(request, response);
        }else{
            myreq.getSession().setAttribute("username", null);
            request.setAttribute("status", "Your Login Failed");
            RequestDispatcher rd = myreq.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
        this.filterConfig=null;
    }
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("Authentication()");
        }
        StringBuffer sb = new StringBuffer("Authentication(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
}
