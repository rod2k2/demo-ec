package net.rod.demo.product.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Rod
 * @date 2021/1/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",insertable = false,updatable = false)
    private ProductCategory productCategory;


    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy ="productId")
    private List<ProductPriceChangeLog> priceChangeLogs;

}
