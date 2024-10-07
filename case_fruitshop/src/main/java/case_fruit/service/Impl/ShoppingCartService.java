package case_fruit.service.Impl;

import case_fruit.model.ShoppingCart;
import case_fruit.repository.IShoppingCartRepo;
import case_fruit.repository.Impl.ShoppingCartRepository;
import case_fruit.service.IShoppingCartService;

import java.util.List;

public class ShoppingCartService implements IShoppingCartService {
    private final IShoppingCartRepo shoppingCartRepository = new ShoppingCartRepository();

    @Override
    public List<ShoppingCart> getAllCarts() {
        return shoppingCartRepository.getAllCarts();
    }

    @Override
    public ShoppingCart getCartById(int id) {
        return shoppingCartRepository.getCartById(id);
    }

    @Override
    public void addCart(ShoppingCart cart) {
        shoppingCartRepository.addCart(cart);
    }

    @Override
    public void updateCart(ShoppingCart cart) {
        shoppingCartRepository.updateCart(cart);
    }

    @Override
    public void deleteCart(int id) {
        shoppingCartRepository.deleteCart(id);
    }
}
