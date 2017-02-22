package pl.ironaltar.domain;

import javax.persistence.*;

/**
 * Created by szzc on 22.02.17.
 */
@Entity
@Table(name = "productgallery")
public class ProductGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "productid")
    private String ProductId;
    @Column(name = "imagename")
    private String ImageName;
    @Column(name = "imageurl")
    private String ImageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
