package net.rod.demo.product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import net.rod.demo.product.model.Product;
import net.rod.demo.product.model.ProductPriceChangeLog;
import net.rod.demo.product.repository.ProductPriceChangeLogRepository;
import net.rod.demo.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rod , have fun with coding.
 * @date 2021/1/18
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductPriceChangeLogRepository priceChangeLogRepository;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product does not exists!"));
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);

    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        Product existedProduct = productRepository.findById(product.getId()).orElseThrow(() -> new IllegalArgumentException("Product does not exist!"));
        existedProduct.setPrice(product.getPrice());

        ProductPriceChangeLog log = new ProductPriceChangeLog();
        log.setPrice(product.getPrice());
        log.setProductId(existedProduct.getId());
        productRepository.save(existedProduct);
        priceChangeLogRepository.save(log);
        return existedProduct;
    }

    @Async
    @Override
    public Product syncProduct(Product product) {

        String productKey = "product:" + product.getId();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {
            String dataJson = mapper.writeValueAsString(product);
            redisTemplate.opsForValue().set(productKey, dataJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return product;
    }
}
