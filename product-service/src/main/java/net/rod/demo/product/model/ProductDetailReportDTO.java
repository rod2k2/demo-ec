package net.rod.demo.product.model;

import lombok.Value;

import java.math.BigDecimal;

/**
 * @author Rod ,have fun with coding
 * @date 2021/2/8 8:19
 */
@Value
public class ProductDetailReportDTO {

    Integer id;
    String name;
    BigDecimal price;
    String description;
    String category;
}