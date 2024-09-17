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
import java.util.ArrayList;
import java.util.List;
import thai.dev.data.model.OrderItem;
import thai.dev.util.Helper;

public class CartServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);

        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<OrderItem>();
            session.setAttribute("cart", cart);
        }
        request.setAttribute("cart", cart);
        request.setAttribute("total", Helper.total(cart));

        request.getRequestDispatcher("cart.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createOrder(request);
                break;
            case "update":
                updateOrder(request);
                break;
            case "delete":
                deleteOrder(request);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("CartServlet");
    }

    private void createOrder(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        OrderItem orderItem = new OrderItem(quantity, price, 0, productId);
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        boolean isExistsInCart = false;

        if (cart == null) {
            cart = new ArrayList<>();
        } else {
            for (OrderItem ord : cart) {
                if (ord.getProductId() == productId) {
                    ord.setQuantity(ord.getQuantity() + quantity);
                    isExistsInCart = true;
                    break;
                }
            }
        }
        if (!isExistsInCart) {
            cart.add(orderItem);
        }
        session.setAttribute("cart", cart);
    }

    private void updateOrder(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        
        if (cart != null && cart.isEmpty()== false) {
            for(OrderItem ord :cart){
                if(ord.getProductId()==productId){
                    ord.setQuantity(quantity);
                }
            }  
        }
        session.setAttribute("cart", cart);
    }

    private void deleteOrder(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();

        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        if (cart != null) {
            for (int i = 0; i < cart.size(); i++) {
                OrderItem ord = cart.get(i);
                if (ord.getProductId() == productId) {
                    cart.remove(ord);
                }
            }
        }
        session.setAttribute("cart", cart);
    }
}
