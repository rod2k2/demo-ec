package net.rod.demo.vendor.service;

import net.rod.demo.vendor.model.Vendor;
import net.rod.demo.vendor.model.VendorSearchCriteria;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.List;

/**
 * @author Rod
 * @date 2021/1/11
 */
public interface VendorService {

    List<Vendor> getVendorByCriteria(VendorSearchCriteria vsc);

    /**
     * @param id vendor id
     * @return vendor
     */
    Vendor getVendorById(@NonNull Integer id);

    Vendor addVendor(Vendor vendor);

    Vendor updateVendor(Vendor vendor) throws Exception;
}
