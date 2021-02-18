package net.rod.demo.product.repository;

import net.rod.demo.product.model.Product;
import net.rod.demo.product.model.ProductDetailReport;
import net.rod.demo.product.model.ProductDetailReportDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rod
 * @date 2021/1/18
 */
@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Query(value = " select p.id,p.name,p.price ,p.description ,pc.category " +
            " from product p " +
            " left join product_category pc" +
            " on p.category_id  = pc.id  " +
            " where p.id = :id",nativeQuery = true
    )
    List<ProductDetailReport> getProductDetailReportByUserInterfaceProjection(@Param("id") Integer id);


    @Query(value = " select new net.rod.demo.product.model.ProductDetailReportDTO(p.id,p.name,p.price ,p.description ,p.productCategory.category) " +
            " from Product p  where p.id = :id"
    )
    List<ProductDetailReportDTO> getProductDetailReportByMappingClass(@Param("id") Integer id);

}
