package net.rod.demo.vendor.repository;

import net.rod.demo.vendor.model.Vendor;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rod
 * @date 2021/1/11
 */
@Mapper
@Repository
public interface VendorRepository {

    @Select("SELECT id, name,description,address from vendor where id = #{id}")
    Vendor findById(@Param("id") Integer id);

    @Select(" select id,name,description,address from vendor where name like '%'||#{name}||'%'")
    List<Vendor> findByNameLike(@Param("name") String name);

    @Insert("insert into vendor (name,description,address) values (#{name},#{description},#{address})")
    @SelectKey(keyProperty = "id",before = false,resultType=Integer.class,statement = "select last_INSERT_ID()")
    void  saveVendor(Vendor vendor);

    @Update("update vendor set name = #{name},description=#{description},address=#{address} where id = #{id}")
    void updateVendor(Vendor vendor);
}
