package net.rod.demo.vendor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rod
 * @date 2021/1/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    private Integer id;
    private String name;
    private String description;
    private String address;
    private Integer rank;
}
