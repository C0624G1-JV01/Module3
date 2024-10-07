package case_fruit.service;

import case_fruit.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    List<ShoppingCart> getAllCarts();
    ShoppingCart getCartById(int id);
    void addCart(ShoppingCart cart);
    void updateCart(ShoppingCart cart);
    void deleteCart(int id);
}
