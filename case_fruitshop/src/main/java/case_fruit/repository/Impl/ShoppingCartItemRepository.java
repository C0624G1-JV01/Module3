package case_fruit.repository.Impl;

import case_fruit.model.ShoppingCartItem;
import case_fruit.repository.IShoppingCartItemRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartItemRepository implements IShoppingCartItemRepository {

    @Override
    public List<ShoppingCartItem> getItemsByCartId(int shoppingCartId) {
        List<ShoppingCartItem> items = new ArrayList<>();
        String sql = "SELECT * FROM cart_items WHERE shopping_cart_id=?";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, shoppingCartId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ShoppingCartItem item = new ShoppingCartItem(
                        resultSet.getInt("id"),
                        resultSet.getInt("shopping_cart_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getInt("quantity")
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void addItem(ShoppingCartItem item) {
        String sql = "INSERT INTO cart_items (shopping_cart_id, product_id, quantity) VALUES (?, ?, ?)";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, item.getShopping_cart_id());
            preparedStatement.setInt(2, item.getProduct_id());
            preparedStatement.setInt(3, item.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(ShoppingCartItem item) {
        String sql = "UPDATE cart_items SET quantity=? WHERE id=?";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, item.getQuantity());
            preparedStatement.setInt(2, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int id) {
        String sql = "DELETE FROM cart_items WHERE id=?";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProductToCart(int shoppingCartId, int productId, int quantity) {
        String checkSql = "SELECT * FROM cart_items WHERE shopping_cart_id=? AND product_id=?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {

            checkStatement.setInt(1, shoppingCartId);
            checkStatement.setInt(2, productId);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                int currentQuantity = resultSet.getInt("quantity");
                updateItem(new ShoppingCartItem(resultSet.getInt("id"), shoppingCartId, productId, currentQuantity + quantity));
            } else {
                addItem(new ShoppingCartItem(0, shoppingCartId, productId, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
