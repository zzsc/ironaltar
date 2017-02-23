package pl.ironaltar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ironaltar.domain.ProductGallery;
import pl.ironaltar.repositories.ProductGalleryRepository;

/**
 * Created by szzc on 22.02.17.
 */
@Service
public class ProductGalleryServiceImpl implements ProductGalleryService{
    private ProductGalleryRepository productGalleryRepository;

    @Autowired
    public void setProductGalleryRepository(ProductGalleryRepository productGalleryRepository) {
        this.productGalleryRepository = productGalleryRepository;
    }

    @Override
    public Iterable<ProductGallery> listAllProductGallerys() {return productGalleryRepository.findAll();
    }

    @Override
    public ProductGallery saveProductGallery(ProductGallery productGallery) {
        return productGalleryRepository.save(productGallery);
    }

    @Override
    public void deleteProductGallery(Integer id) {
        productGalleryRepository.delete(id);
    }

}
