package net.rod.demo.vendor.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Rod
 * @date 2021/1/13
 */
@Mapper
@Repository
public interface VendorProfileRepository {

    @Insert("insert into vendor_profile(vendor_id,profile_type,profile_value,version) values ( #{vendorId},#{profileType},#{profileValue},#{version})")
    void saveProfile(VendorProfile profile);

}
