package net.rod.demo.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static net.rod.demo.product.util.Constants.TaskQueueName;

/**
 * Service take responsibility to manage schedule task
 * @author Rod ,have fun with coding
 * @date 2021/2/3 21:31
 */

@Service
@Slf4j
public class ScheduleTaskService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Scheduled(fixedDelay = 1000*60)
    public void runTask(){
        Object value = redisTemplate.opsForList().rightPop(TaskQueueName);
        log.debug("running task , get value is {}",value);
    }
}
