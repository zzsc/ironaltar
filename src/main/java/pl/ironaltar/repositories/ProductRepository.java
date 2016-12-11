package pl.ironaltar.repositories;

import pl.ironaltar.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
     List<Product> findByCategory(String category);
}
