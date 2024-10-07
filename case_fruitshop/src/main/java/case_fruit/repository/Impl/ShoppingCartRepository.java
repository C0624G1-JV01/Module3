package case_fruit.repository.Impl;

import case_fruit.model.ShoppingCart;
import case_fruit.repository.IShoppingCartRepo;
import case_fruit.repository.Impl.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartRepository implements IShoppingCartRepo {

    @Override
    public List<ShoppingCart> getAllCarts() {
        List<ShoppingCart> carts = new ArrayList<>();
        String sql = "SELECT * FROM shopping_carts";

        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                ShoppingCart cart = new ShoppingCart(
                        resultSet.getInt("shopping_cart_id"),
                        resultSet.getDouble("total_price"),
                        resultSet.getInt("user_id"),
                        resultSet.getDate("date"),
                        resultSet.getString("address"),
                        resultSet.getString("status")
                );
                carts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }

    @Override
    public ShoppingCart getCartById(int id) {
        ShoppingCart cart = null;
        String sql = "SELECT * FROM shopping_carts WHERE shopping_cart_id = ?";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cart = new ShoppingCart(
                        resultSet.getInt("shopping_cart_id"),
                        resultSet.getDouble("total_price"),
                        resultSet.getInt("user_id"),
                        resultSet.getDate("date"),
                        resultSet.getString("address"),
                        resultSet.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public void addCart(ShoppingCart cart) {
        String sql = "INSERT INTO shopping_carts (total_price, user_id, date, address, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, cart.getTotal_price());
            preparedStatement.setInt(2, cart.getUser_id());
            preparedStatement.setDate(3, new java.sql.Date(cart.getDate().getTime()));
            preparedStatement.setString(4, cart.getAddress());
            preparedStatement.setString(5, cart.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Ghi lại lỗi vào log thực tế
        }
    }

    @Override
    public void updateCart(ShoppingCart cart) {
        String sql = "UPDATE shopping_carts SET total_price=?, user_id=?, date=?, address=?, status=? WHERE shopping_cart_id=?";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, cart.getTotal_price());
            preparedStatement.setInt(2, cart.getUser_id());
            preparedStatement.setDate(3, new java.sql.Date(cart.getDate().getTime()));
            preparedStatement.setString(4, cart.getAddress());
            preparedStatement.setString(5, cart.getStatus());
            preparedStatement.setInt(6, cart.getShopping_cart_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Ghi lại lỗi vào log thực tế
        }
    }

    @Override
    public void deleteCart(int id) {
        String sql = "DELETE FROM shopping_carts WHERE shopping_cart_id=?";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
