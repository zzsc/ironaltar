package pl.ironaltar.bootstrap;

import pl.ironaltar.domain.Product;
import pl.ironaltar.repositories.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
/*
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setBrand("Casorama");
        shirt.setCategory("balcony");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("http://classicmeble.pl/wp-content/uploads/2015/02/");
        shirt.setImageName("16-256x256.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setBrand("Liroy Merlin");
        mug.setCategory("balcony");
        mug.setImageUrl("http://classicmeble.pl/wp-content/uploads/2015/02/");
        mug.setImageName("16-256x256.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());

        Product bug = new Product();
        bug.setDescription("Spring Framework Guru Mug");
        bug.setBrand("Agata meble");
        bug.setCategory("balcony");
        bug.setImageUrl("http://classicmeble.pl/wp-content/uploads/2015/02/");
        bug.setImageName("16-256x256.jpg");
        bug.setProductId("168639393495335947");
        bug.setPrice(new BigDecimal("11.95"));
        productRepository.save(bug);

        log.info("Saved Bug - id:" + bug.getId());

        Product shoe = new Product();
        shoe.setDescription("Spring Framework Guru Mug");
        shoe.setBrand("Ikea");
        shoe.setCategory("balcony");
        shoe.setImageUrl("http://classicmeble.pl/wp-content/uploads/2015/02/");
        shoe.setImageName("16-256x256.jpg");
        shoe.setProductId("168639393495335947");
        shoe.setPrice(new BigDecimal("11.95"));
        productRepository.save(shoe);

        log.info("Saved Shoe - id:" + shoe.getId());

*/
    }
}