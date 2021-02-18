package net.rod.demo.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.rod.demo.product.util.Constants.TaskQueueName;

/**
 * Task controller to receive task
 *
 * @author Rod ,have fun with coding
 * @date 2021/2/3 21:44
 */
@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @PostMapping(value = "/{priority}/{taskName}")
    public boolean submitTask(@PathVariable Integer priority, @PathVariable String taskName) {
        ListOperations lops = redisTemplate.opsForList();
        lops.leftPush(TaskQueueName, taskName);
        return true;
    }
}
