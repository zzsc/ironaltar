package pl.ironaltar.services;


import pl.ironaltar.domain.Product;

import java.util.List;

public interface ProductService {
    Iterable<Product> listAllProducts();

    List<Product> findByCategoryOrderByBrandAsc(String category);

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}