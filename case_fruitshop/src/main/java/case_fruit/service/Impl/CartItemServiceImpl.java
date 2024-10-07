package case_fruit.service.Impl;

import case_fruit.model.ShoppingCartItem;
import case_fruit.repository.IShoppingCartItemRepository;
import case_fruit.repository.Impl.ShoppingCartItemRepository;
import case_fruit.service.ICartItemService;

import java.util.List;

public class CartItemServiceImpl implements ICartItemService {
    private final IShoppingCartItemRepository cartItemRepository = new ShoppingCartItemRepository();

    @Override
    public List<ShoppingCartItem> getItemsByCartId(int shoppingCartId) {
        return cartItemRepository.getItemsByCartId(shoppingCartId);
    }

    @Override
    public void addItem(ShoppingCartItem item) {
        cartItemRepository.addItem(item);
    }

    @Override
    public void updateItem(ShoppingCartItem item) {
        cartItemRepository.updateItem(item);
    }

    @Override
    public void deleteItem(int id) {
        cartItemRepository.deleteItem(id);
    }

    @Override
    public void addProductToCart(int shoppingCartId, int productId, int quantity) {
        cartItemRepository.addProductToCart(shoppingCartId, productId, quantity);
    }
}
