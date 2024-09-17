/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thai.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import thai.dev.data.dao.DatabaseDao;
import thai.dev.data.dao.ProductDao;
import thai.dev.data.model.Product;
import thai.dev.util.Constants;

/**
 *
 * @author ACER
 */
public class ProductServelt extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         super.doGet(request, response);
        int ProductId = Integer.parseInt(request.getParameter("productId"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(ProductId);
        List<Product> newsProductList = productDao.news(Constants.NUMBER_EVENT);
        
        request.setAttribute("newsProductList", newsProductList);
        request.setAttribute("product", product);
        request.getRequestDispatcher("product.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
