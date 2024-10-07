package case_fruit.controller;

import case_fruit.model.Product;
import case_fruit.model.ProductCategory;
import case_fruit.service.IProductService;
import case_fruit.service.Impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productController", value = "/fruit-admin")
public class ProductControllerAdmin extends HttpServlet {
    private static final String ACTION_CREATE = "create";
    private static final String ACTION_EDIT = "edit";
    private static final String ACTION_DELETE = "delete";
    private static final String ACTION_SEARCH = "search";

    private final IProductService productService = new ProductService();
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
                case ACTION_CREATE:
                    request.getRequestDispatcher("/fruit/add.jsp").forward(request, response);
                    return;

                case ACTION_EDIT:
                    int editId = Integer.parseInt(request.getParameter("id"));
                    Product product = productService.getById(editId);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("/fruit/edit.jsp").forward(request, response);
                    return;

                case ACTION_DELETE:
                    int deleteId = Integer.parseInt(request.getParameter("id"));
                    productService.deleteProduct(deleteId);
                    response.sendRedirect(request.getContextPath() + "/fruit-admin");
                    return;

                case ACTION_SEARCH:
                    String searchKeyword = request.getParameter("keyword");
                    products = productService.searchProducts(searchKeyword);
                    break;

                default:
                    products = productService.findAllProducts();
                    break;
            }


            List<ProductCategory> categories = productService.findAllProductCategories();
            System.out.println("Number of categories: " + categories.size());
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/fruit/fruit-admin.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
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
                case ACTION_CREATE:
                    String name = request.getParameter("name");
                    String description = request.getParameter("description");
                    int price = Integer.parseInt(request.getParameter("price"));
                    String image = request.getParameter("image");
                    int categoryId = Integer.parseInt(request.getParameter("category_id"));

                    Product newProduct = new Product(0, name, description, price, image, categoryId);
                    productService.saveProduct(newProduct);
                    response.sendRedirect(request.getContextPath() + "/fruit-adim");
                    break;

                case ACTION_EDIT:
                    int id = Integer.parseInt(request.getParameter("id"));
                    String updatedName = request.getParameter("name");
                    String updatedDescription = request.getParameter("description");
                    int updatedPrice = Integer.parseInt(request.getParameter("price"));
                    String updatedImage = request.getParameter("image");
                    int updatedCategoryId = Integer.parseInt(request.getParameter("category_id"));

                    Product updatedProduct = new Product(id, updatedName, updatedDescription, updatedPrice, updatedImage, updatedCategoryId);
                    productService.updateProduct(updatedProduct);
                    response.sendRedirect(request.getContextPath() + "/fruit-admin");
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                    break;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Đã xảy ra lỗi.");
            request.getRequestDispatcher("/fruit/error.jsp").forward(request, response);
        }
    }
}
