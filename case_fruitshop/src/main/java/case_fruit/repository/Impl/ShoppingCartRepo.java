package case_fruit.repository.Impl;

import case_fruit.model.ShoppingCart;
import case_fruit.repository.IShoppingCartRepo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartRepo implements IShoppingCartRepo {
    private final List<ShoppingCart> cartStorage = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void addCart(ShoppingCart cart) {
        cart.setShopping_cart_id(currentId++);
        cartStorage.add(cart);
    }

    @Override
    public List<ShoppingCart> getAllCarts() {
        return new ArrayList<>(cartStorage);
    }

    @Override
    public ShoppingCart getCartById(int id) {
        for (ShoppingCart cart : cartStorage) {
            if (cart.getShopping_cart_id() == id) {
                return cart;
            }
        }
        return null;
    }

    @Override
    public void updateCart(ShoppingCart cart) {
        for (int i = 0; i < cartStorage.size(); i++) {
            if (cartStorage.get(i).getShopping_cart_id() == cart.getShopping_cart_id()) {
                cartStorage.set(i, cart);
                return;
            }
        }
    }

    @Override
    public void deleteCart(int id) {
        for (int i = 0; i < cartStorage.size(); i++) {
            if (cartStorage.get(i).getShopping_cart_id() == id) {
                cartStorage.remove(i);
                break;
            }
        }
    }

}
