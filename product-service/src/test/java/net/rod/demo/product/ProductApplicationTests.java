package net.rod.demo.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ProductApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Long redisKeyOneId = redisTemplate.opsForValue().increment("redisKeyOneId");
        System.out.println(redisKeyOneId);
        redisKeyOneId = redisTemplate.opsForValue().increment("redisKeyOneId");
        System.out.println(redisKeyOneId);
    }

}
