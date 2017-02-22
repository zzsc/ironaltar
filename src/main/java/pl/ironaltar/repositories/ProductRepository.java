package pl.ironaltar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ironaltar.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
     List<Product> findByCategoryOrderByBrandAsc(String category);
     List<Product> findByPriceLessThanOrderByPriceAsc(BigDecimal price);
}
