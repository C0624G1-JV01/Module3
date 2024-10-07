package case_fruit.repository;

import case_fruit.model.ShoppingCart;
import java.util.List;

public interface IShoppingCartRepo {
    void addCart(ShoppingCart cart);
    List<ShoppingCart> getAllCarts();
    ShoppingCart getCartById(int id);
    void updateCart(ShoppingCart cart);
    void deleteCart(int id);
}