package case_fruit.service.Impl;
import case_fruit.model.Product;
import case_fruit.model.ProductCategory;
import case_fruit.repository.IProduct;
import case_fruit.repository.Impl.ProductRepository;
import case_fruit.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    private static final IProduct productRepository = new ProductRepository();

    @Override
    public List<Product> findAllProducts() throws SQLException, ClassNotFoundException {
        return productRepository.findAllProducts();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void deleteProduct(int product_id) {
        productRepository.deleteProduct(product_id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public Product getById(int product_id) {
        return productRepository.getById(product_id);
    }

    @Override
    public List<Product> searchProducts(String name) throws SQLException {
        return productRepository.searchProducts(name);

    }

    public List<ProductCategory> findAllProductCategories() {
        return productRepository.findAllProductCategories();
    }
}