package net.rod.demo.product.controller;

import lombok.extern.slf4j.Slf4j;
import net.rod.demo.product.model.Product;
import net.rod.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rod
 * @date 2021/1/18
 */
@RestController(value = "Rest Controller encapsulate resource manipulate for product")
@RequestMapping(value = "/api/product/")
@Slf4j
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping(value = "/id/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "")
    public Product createNewProduct(@RequestBody Product product) {
         log.debug("start  save data into database");
         productService.saveProduct(product);
         log.debug("completed save data into database");
         productService.syncProduct(product);
         return product;
    }

    @PutMapping(value = "")
    public Product changeProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        productService.syncProduct(updatedProduct);
        return updatedProduct;
    }


}
