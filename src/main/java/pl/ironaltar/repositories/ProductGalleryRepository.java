package pl.ironaltar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ironaltar.domain.ProductGallery;

/**
 * Created by szzc on 22.02.17.
 */
public interface ProductGalleryRepository extends JpaRepository<ProductGallery, Integer> {
}
