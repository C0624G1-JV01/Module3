package case_fruit.service.Impl;

import case_fruit.model.ShoppingCart;
import case_fruit.repository.IShoppingCartRepo;
import case_fruit.repository.Impl.ShoppingCartRepo;
import case_fruit.service.IShoppingCartService;

import java.util.List;

public class ShoppingCartService implements IShoppingCartService {
    private final IShoppingCartRepo shoppingCartRepo;

    public ShoppingCartService() {
        this.shoppingCartRepo = new ShoppingCartRepo();
    }

    @Override
    public void addCart(ShoppingCart cart) {
        shoppingCartRepo.addCart(cart);
    }

    @Override
    public List<ShoppingCart> getAllCarts() {
        return shoppingCartRepo.getAllCarts();
    }

    @Override
    public ShoppingCart getCartById(int id) {
        return shoppingCartRepo.getCartById(id);
    }

    @Override
    public void updateCart(ShoppingCart cart) {
        shoppingCartRepo.updateCart(cart);
    }

    @Override
    public void deleteCart(int id) {
        shoppingCartRepo.deleteCart(id);
    }
}
