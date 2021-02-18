package net.rod.demo.product.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Rod Have fun with coding
 * @date 2021/1/18
 */
@Data
@Entity
@Table(name = "product_price_change_log")
public class ProductPriceChangeLog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "entry_datetime",insertable = false,updatable = false)
    private LocalDateTime entryDatetime;
}
