/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thai.dev.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thai.dev.admin.BaseAdminServlet;
import thai.dev.data.dao.DatabaseDao;
import thai.dev.data.dao.UserDAO;

/**
 *
 * @author ACER
 */
public class DeleteUserServlet extends BaseAdminServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userId"));
        UserDAO userDao = DatabaseDao.getInstance().getUserDao();
        userDao.delete(userID);
        
        response.sendRedirect("IndexUserServlet");
    }
    
}
