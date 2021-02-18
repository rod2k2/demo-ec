package net.rod.demo.customer.web;

import net.rod.demo.customer.vo.CustomerVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rod
 * @date 2020/6/12
 */

@RestController(value = "Customer API to manipulate customer via http")
@RequestMapping(value = "/api/customers")
public class CustomerController {


    @GetMapping(value = "/{id}")
    public CustomerVo getCustomerById(@PathVariable(value = "id") Integer customerId){
        CustomerVo vo = new CustomerVo();
        vo.setId(customerId);
        vo.setName("Rod Zhong");
        vo.setEmail("xxxx@xxx.com");
        vo.setPhone("123-456-7890");
        return vo;
    }

    @PutMapping(value = "/{id}")
    public CustomerVo updateCustomerById(@PathVariable(value = "id") Integer customerId,@RequestBody final CustomerVo customer ){
        return customer;
    }

}
