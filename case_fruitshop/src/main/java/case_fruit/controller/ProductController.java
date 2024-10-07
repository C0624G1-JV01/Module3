package case_fruit.controller;

import case_fruit.model.Product;
import case_fruit.model.ProductCategory;
import case_fruit.service.ICartItemService;
import case_fruit.service.IProductService;
import case_fruit.service.Impl.CartItemServiceImpl;
import case_fruit.service.Impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productController", value = "/fruit-shop")
public class ProductController extends HttpServlet {
    private static final String ACTION_SEARCH = "search";
    private static final String ACTION_ADD_TO_CART = "addToCart";

    private final IProductService productService = new ProductService();
    private final ICartItemService cartService = new CartItemServiceImpl(); // Khởi tạo dịch vụ giỏ hàng

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        List<Product> products = new ArrayList<>();

        try {
            switch (action) {
                case ACTION_SEARCH:
                    String searchKeyword = request.getParameter("keyword");
                    products = productService.searchProducts(searchKeyword);
                    break;

                default:
                    products = productService.findAllProducts();
                    break;
            }

            List<ProductCategory> categories = productService.findAllProductCategories();
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/fruit/fruit-shop.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Đã xảy ra lỗi.");
            request.getRequestDispatcher("/fruit/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case ACTION_ADD_TO_CART:
                    int productId = Integer.parseInt(request.getParameter("id"));
                    int quantity = Integer.parseInt(request.getParameter("quantity")); // Lấy số lượng từ request

                    // Thêm sản phẩm vào giỏ hàng
                    cartService.addProductToCart(1, productId, quantity); // Giả sử shoppingCartId là 1
                    System.out.println("Product ID " + productId + " added to cart with quantity " + quantity);
                    response.sendRedirect(request.getContextPath() + "/fruit-shop");
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                    break;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID or quantity");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Đã xảy ra lỗi.");
            request.getRequestDispatcher("/fruit/error.jsp").forward(request, response);
        }
    }
}
