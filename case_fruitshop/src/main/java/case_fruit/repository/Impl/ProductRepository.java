package case_fruit.repository.Impl;

import case_fruit.model.Product;
import case_fruit.model.ProductCategory;
import case_fruit.repository.IProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProduct {
    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = mapRowToProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public void saveProduct(Product product) {
        String sql = "INSERT INTO product (name, description, price, image, category_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setProductParams(statement, product);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int product_id) {
        String sql = "DELETE FROM product WHERE product_id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE product SET name = ?, description = ?, price = ?, image = ?, category_id = ? WHERE product_id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setProductParams(statement, product);
            statement.setInt(6, product.getProduct_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getById(int product_id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE product_id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = mapRowToProduct(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                productList.add(mapRowToProduct(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<ProductCategory> findAllProductCategories() {
        List<ProductCategory> productCategories = new ArrayList<>();
        String sql = "SELECT * FROM product_category";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ProductCategory category = new ProductCategory();
                category.setCategory_id(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));

                productCategories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productCategories;
    }


    private void setProductParams(PreparedStatement statement, Product product) throws SQLException {
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setDouble(3, product.getPrice());
        statement.setString(4, product.getImage());
        statement.setInt(5, product.getCategory_id());
    }

    private Product mapRowToProduct(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getInt("product_id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getInt("price"),
                resultSet.getString("image"),
                resultSet.getInt("category_id")
        );
    }
}