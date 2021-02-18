package net.rod.demo.vendor.repository;

import lombok.Data;

/**
 * @author Rod
 * @date 2021/1/13
 */
@Data
public class VendorProfile {
    private Integer id;
    private Integer vendorId;
    private String profileType;
    private String profileValue;
    private Integer version;
}
