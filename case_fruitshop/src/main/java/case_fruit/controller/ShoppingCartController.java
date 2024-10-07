package case_fruit.controller;

import case_fruit.model.ShoppingCart;
import case_fruit.service.IShoppingCartService;
import case_fruit.service.Impl.ShoppingCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "shoppingCartController", value = "/shoppingCart")
public class ShoppingCartController extends HttpServlet {
    private final IShoppingCartService shoppingCartService = new ShoppingCartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ShoppingCart> carts = shoppingCartService.getAllCarts();
        request.setAttribute("carts", carts);
        request.getRequestDispatcher("/Cart/shoppingCart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            ShoppingCart cart = new ShoppingCart(0, Double.parseDouble(request.getParameter("total_price")),
                    Integer.parseInt(request.getParameter("user_id")),
                    new Date(),
                    request.getParameter("address"),
                    "Pending");
            shoppingCartService.addCart(cart);
            response.sendRedirect("shoppingCart");
        } else if ("update".equals(action)) {
            ShoppingCart cart = new ShoppingCart(Integer.parseInt(request.getParameter("shopping_cart_id")),
                    Double.parseDouble(request.getParameter("total_price")),
                    Integer.parseInt(request.getParameter("user_id")),
                    new Date(),
                    request.getParameter("address"),
                    request.getParameter("status"));
            shoppingCartService.updateCart(cart);
            response.sendRedirect("shoppingCart");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            shoppingCartService.deleteCart(id);
            response.sendRedirect("shoppingCart");
        }
    }
}
