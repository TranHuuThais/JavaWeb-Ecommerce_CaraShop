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

public class ShopServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
    
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();

        int totalProducts = productDao.findAll().size();
        int totalPages = (int) Math.ceil((double) totalProducts / Constants.PER_PAGE);

        int currentPage = 1;
        try {
            currentPage = Math.max(1, Integer.parseInt(request.getParameter("page")));
        } catch (NumberFormatException e) {
        }

        int offset = (currentPage - 1) * Constants.PER_PAGE;

        String sort = request.getParameter("sort");
        String order = request.getParameter("order");

        if (sort == null || sort.isEmpty()) {
            sort = "name";
        }
        if (order == null || order.isEmpty()) {
            order = "ASC";
        }

        List<Product> productList = productDao.filter(0, sort, order);

        request.setAttribute("ProductList", productList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("sort", sort);
        request.setAttribute("order", order);

        request.getRequestDispatcher("shop.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
