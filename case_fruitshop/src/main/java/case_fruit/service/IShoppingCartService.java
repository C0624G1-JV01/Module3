package case_fruit.service;

import case_fruit.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    void addCart(ShoppingCart cart);
    List<ShoppingCart> getAllCarts();
    ShoppingCart getCartById(int id);
    void updateCart(ShoppingCart cart);
    void deleteCart(int id);
}
