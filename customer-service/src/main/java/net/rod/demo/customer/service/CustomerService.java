package net.rod.demo.customer.service;

import net.rod.demo.customer.vo.CustomerQueryVo;
import net.rod.demo.customer.vo.CustomerVo;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @author Rod Have fun with coding
 * @date 2021/2/22 21:30
 */
public interface CustomerService {

    List<CustomerVo> getCustomerList(CustomerQueryVo customerQueryVo);

    CustomerVo getCustomer(@NonNull Integer customerId);
}
