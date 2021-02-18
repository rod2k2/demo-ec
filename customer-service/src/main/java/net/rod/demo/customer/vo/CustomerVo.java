package net.rod.demo.customer.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Rod
 * @date 2020/6/12
 */
@Data
public class CustomerVo implements Serializable {
    private static final long serialVersionUID = 5408835882862053732L;

    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
}
