package net.rod.demo.vendor.service;

import net.rod.demo.vendor.model.Vendor;
import net.rod.demo.vendor.model.VendorSearchCriteria;
import net.rod.demo.vendor.repository.VendorProfile;
import net.rod.demo.vendor.repository.VendorProfileRepository;
import net.rod.demo.vendor.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Rod
 * @date 2021/1/11
 */
@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorProfileRepository vendorProfileRepository;

    @Override
    public List<Vendor> getVendorByCriteria(VendorSearchCriteria vsc) {
        return vendorRepository.findByNameLike(vsc.getName());
    }

    @Override
    public Vendor getVendorById(Integer id) {
        return vendorRepository.findById(id);
    }

    @Override
    public Vendor addVendor(Vendor vendor) {
        vendorRepository.saveVendor(vendor);
        vendorProfileRepository.saveProfile(this.generateProfile(vendor));
        return vendor;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Vendor updateVendor(Vendor vendor) throws Exception {
        vendorRepository.updateVendor(vendor);
        this.generateProfile(vendor);
        return vendor;
    }

    @Transactional(propagation = Propagation.NESTED)
    public VendorProfile generateProfile(Vendor vendor) {
        VendorProfile vendorProfile = new VendorProfile();
        vendorProfile.setProfileType("TEST");
        vendorProfile.setProfileValue("123");
        vendorProfile.setVersion(1);
        vendorProfile.setVendorId(vendor.getId());
        vendorProfileRepository.saveProfile(vendorProfile);
        return vendorProfile;
    }
}
