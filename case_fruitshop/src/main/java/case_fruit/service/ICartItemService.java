package case_fruit.service;

import case_fruit.model.ShoppingCartItem;

import java.util.List;

public interface ICartItemService {
    List<ShoppingCartItem> getItemsByCartId(int shoppingCartId);
    void addItem(ShoppingCartItem item);
    void updateItem(ShoppingCartItem item);
    void deleteItem(int id);
    void addProductToCart(int shoppingCartId, int productId, int quantity);
}
