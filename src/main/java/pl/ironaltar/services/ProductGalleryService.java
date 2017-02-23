package pl.ironaltar.services;

import pl.ironaltar.domain.ProductGallery;

/**
 * Created by szzc on 22.02.17.
 */
public interface ProductGalleryService {
    Iterable<ProductGallery> listAllProductGallerys();
    ProductGallery saveProductGallery(ProductGallery productGallery);
    void deleteProductGallery(Integer id);
}
