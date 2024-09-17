/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thai.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thai.dev.data.dao.DatabaseDao;
import thai.dev.data.dao.UserDAO;
import thai.dev.data.model.User;

/**
 *
 * @author ACER
 */
public class RegisterServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = DatabaseDao.getInstance().getUserDao();
        User user = userDAO.find(email);

        if (user != null) {
            session.setAttribute("error", "Email already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            user = new User(email, password, "user");
            userDAO.insert(user);
            session.setAttribute("success", "Registration successful! You can now log in.");
            response.sendRedirect("LoginServlet");
        }
    }
}
