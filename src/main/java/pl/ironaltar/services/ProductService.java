package pl.ironaltar.services;


import pl.ironaltar.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Iterable<Product> listAllProducts();

    List<Product> findByPriceLessThanOrderByPriceAsc(BigDecimal price);

    List<Product> findByCategoryOrderByBrandAsc(String category);

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}