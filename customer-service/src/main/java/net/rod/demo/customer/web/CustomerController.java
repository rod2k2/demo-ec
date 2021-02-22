package net.rod.demo.customer.web;

import net.rod.demo.customer.service.CustomerService;
import net.rod.demo.customer.vo.CustomerQueryVo;
import net.rod.demo.customer.vo.CustomerVo;
import net.rod.demo.customer.vo.CustomerVoOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rod
 * @date 2020/6/12
 */

@RestController(value = "Customer API to manipulate customer via http")
@RequestMapping(value = "/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{id}")
    public CustomerVo getCustomerById(@PathVariable(value = "id") Integer customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value = "/{id}")
    public CustomerVo updateCustomerById(@PathVariable(value = "id") Integer customerId, @RequestBody final CustomerVo customer) {
        return customer;
    }

    @GetMapping(value = "")
    public List<CustomerVo> getCustomerList() {
        CustomerQueryVo queryVo = new CustomerQueryVo();
        return customerService.getCustomerList(queryVo);
    }

    @GetMapping(value = "/binary", produces = "application/x-protobuf")
    public CustomerVoOuterClass.CustomerVoList getCustomerListAsBinary() {
        CustomerVoOuterClass.CustomerVoList.Builder builder = CustomerVoOuterClass.CustomerVoList.newBuilder();

        CustomerQueryVo queryVo = new CustomerQueryVo();
        List<CustomerVo> customerList = customerService.getCustomerList(queryVo);
        for (CustomerVo vo : customerList) {
            builder.addCustomerVos(CustomerVoOuterClass.CustomerVo.newBuilder()
                    .setId(vo.getId())
                    .setAddress(vo.getAddress())
                    .setEmail(vo.getEmail())
                    .setName(vo.getName())
                    .setPhone(vo.getPhone())
                    .build());
        }
        return builder.build();
    }

}
