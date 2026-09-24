package net.laboratorioderedes.api_product.service;

import net.laboratorioderedes.api_product.entity.Product;
import java.util.List;

public interface ProductService {
    // create
    Product createProduct(Product product);

    // read
    List<Product> getAllProducts();
    Product getProductById(Long productId);

    // update
    Product updateProduct(Long productId, Product product);

    // delete
    Product deleteProductById(Long productId);
}