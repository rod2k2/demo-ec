package net.rod.demo.product.model;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Rod Have fun with coding
 * @date 2021/2/8 22:43
 */
public interface ProductDetailReport {
        //the sql result filed is also named id
        Integer getId();

        String getName();

        //Optional can also support
        Optional<BigDecimal> getPrice();

        String getCategory();

        //open projection, based on SpEL ( Spring Expression Language)
        @Value("#{target.category} | #{target.name}")
        String getDisplayName();

        //this field always null because didn't wrote into SQL
        Optional<String> getNonSuchFiled();
}
