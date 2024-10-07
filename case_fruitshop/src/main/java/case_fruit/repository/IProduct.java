package case_fruit.repository;


import case_fruit.model.Product;
import case_fruit.model.ProductCategory;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    List<Product> findAllProducts() throws SQLException, ClassNotFoundException;
    void saveProduct(Product product);
    void deleteProduct(int product_id);
    void updateProduct(Product product);
    Product getById(int product_id);
    List<Product> searchProducts(String name);
    List<ProductCategory> findAllProductCategories();
}