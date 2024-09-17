
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thai.dev.admin.orderitem;

import java.io.IOException;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import thai.dev.admin.BaseAdminServlet;
import thai.dev.data.dao.DatabaseDao;
import thai.dev.data.dao.OrderDao;
import thai.dev.data.dao.OrderItemDao;
import thai.dev.data.model.Order;
import thai.dev.data.model.OrderItem;

/**
 *
 * @author ACER
 */
public class IndexOrderItemServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);
        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();
        List<OrderItem> orderItemList = orderItemDao.findByOrderId(orderId);

        request.setAttribute("orderItemList", orderItemList);
        request.setAttribute("order", order);
        request.getRequestDispatcher("admin/orderitem/index.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
