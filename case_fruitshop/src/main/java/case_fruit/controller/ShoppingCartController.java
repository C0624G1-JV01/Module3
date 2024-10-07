package case_fruit.controller;

import case_fruit.model.ShoppingCartItem;
import case_fruit.service.ICartItemService;
import case_fruit.service.Impl.CartItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShoppingCartController", value = "/shopping-cart")
public class ShoppingCartController extends HttpServlet {
    private final ICartItemService itemService = new CartItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int cartId = Integer.parseInt(request.getParameter("cartId"));
            List<ShoppingCartItem> items = itemService.getItemsByCartId(cartId);
            request.setAttribute("items", items);
            request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid cart ID");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int cartId = Integer.parseInt(request.getParameter("cartId")); // Get cartId for redirecting

        try {
            if ("add".equals(action)) {
                ShoppingCartItem item = new ShoppingCartItem(0, cartId,
                        Integer.parseInt(request.getParameter("productId")),
                        Integer.parseInt(request.getParameter("quantity")));
                itemService.addItem(item);
            } else if ("update".equals(action)) {
                ShoppingCartItem item = new ShoppingCartItem(Integer.parseInt(request.getParameter("id")),
                        cartId,
                        Integer.parseInt(request.getParameter("productId")),
                        Integer.parseInt(request.getParameter("quantity")));
                itemService.updateItem(item);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                itemService.deleteItem(id);
            }
            response.sendRedirect("shopping-cart?cartId=" + cartId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
        }
    }
}
