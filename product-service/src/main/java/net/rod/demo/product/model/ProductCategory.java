package net.rod.demo.product.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Rod ,have fun with coding
 * @date 2021/1/18
 */
@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "category")
    private String  category;

}
