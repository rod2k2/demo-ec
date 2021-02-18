//package net.rod.demo.product.repository;
//
//import net.rod.demo.product.vo.ProductDetailReport;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
//
//import javax.persistence.EntityResult;
//import javax.persistence.FieldResult;
//import javax.persistence.NamedNativeQuery;
//import javax.persistence.SqlResultSetMapping;
//import java.util.List;
//
///**
// * @author Rod ,have fun with coding
// * @date 2021/2/8 8:21
// */
//@SqlResultSetMapping(
//        name="productDetailReport",
//        entities = {
//            @EntityResult(
//                    entityClass = ProductDetailReport.class,
//                    fields = {
//                            @FieldResult(name="id", column="id"),
//                            @FieldResult(name = "price",column = "price"),
//                            @FieldResult(name = "description",column = "description"),
//                            @FieldResult(name = "categoryName",column = "category"),
//                    }
//            )
//        }
//)
//@NamedNativeQuery(name = "getProductDetailReport",resultSetMapping = "productDetailReport",
//        query=" select p.id,p.name,p.price ,p.description ,pc.category \n" +
//                "from product p \n" +
//                "\t left join product_category pc \n" +
//                "\t on p.category_id  = pc.id  \n" +
//                "where p.id  = :id  ")
//public interface ProductDetailReportRepository extends JpaRepository<ProductDetailReport,Long> {
//
//
//    List<ProductDetailReport> getProductDetailReport(@Param("id") Integer id);
//}
