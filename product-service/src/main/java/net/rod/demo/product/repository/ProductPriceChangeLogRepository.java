package net.rod.demo.product.repository;

import net.rod.demo.product.model.ProductPriceChangeLog;
import org.springframework.data.repository.CrudRepository;

/**
 * class encapsulate  crud method to produce price change log entity
 * @author Rod Have fun with coding
 * @date 2021/1/18
 */
public interface ProductPriceChangeLogRepository extends CrudRepository<ProductPriceChangeLog,Integer> {
}
