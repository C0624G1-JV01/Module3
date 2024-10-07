package case_fruit.service;

import case_fruit.model.Product;
import case_fruit.model.ProductCategory;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> findAllProducts() throws SQLException, ClassNotFoundException;
    void saveProduct(Product product);
    void deleteProduct(int product_id);
    void updateProduct(Product product);
    Product getById(int product_id);
    List<ProductCategory> findAllProductCategories();

    List<Product> searchProducts(String name) throws SQLException;
}