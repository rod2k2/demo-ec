package net.rod.demo.product.service;

import net.rod.demo.product.model.Product;

/**
 * @author Rod
 * @date 2021/1/18
 */
public interface ProductService {

    Product getProductById(Integer id);

    /**
     * save product into database and populate the generated id
     * @param product
     * @return
     */
    Product saveProduct(Product product);

    Product updateProduct(Product product);

    /**
     * put data with async way
     * @param product
     * @return
     */
    Product syncProduct(Product product);
}
