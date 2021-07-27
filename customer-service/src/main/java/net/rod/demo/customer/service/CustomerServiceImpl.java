package net.rod.demo.customer.service;

import net.rod.demo.customer.vo.CustomerQueryVo;
import net.rod.demo.customer.vo.CustomerVo;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rod Have fun with coding
 * @date 2021/2/22 21:31
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<CustomerVo> getCustomerList(CustomerQueryVo customerQueryVo) {

        int mockDataSize = 50;
        List<CustomerVo> customerList  = new ArrayList<>();
        for (int i=0;i<=mockDataSize;i++){
            CustomerVo vo = getCustomerVo();
            vo.setId(i);
            customerList.add(vo);
        }
        return customerList;
    }

    private CustomerVo getCustomerVo() {
        CustomerVo vo = new CustomerVo();
        vo.setName("Rod Zhong");
        vo.setEmail("xxxx@xxx.com");
        vo.setPhone("123-456-7890");
        vo.setAddress("This is address ");
        return vo;
    }

    @Override
    public CustomerVo getCustomer(@NonNull Integer customerId){
        CustomerVo vo = getCustomerVo();
        vo.setId(customerId);
        return vo;
    }

}
