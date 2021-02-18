package net.rod.demo.product.repository;

import net.rod.demo.product.model.ProductDetailReport;
import net.rod.demo.product.model.ProductDetailReportDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Rod ,have fun with coding
 * @date 2021/2/8 8:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ProductDetailReportRepositoryTest {


    @Autowired
    private ProductRepository reportRepository;

    @Test
    void getProductDetailReport() {

        List<ProductDetailReport> productDetailReport = reportRepository.getProductDetailReportByUserInterfaceProjection(1);
        assertTrue(productDetailReport.size() ==1);
        productDetailReport.stream().forEach(x -> {
            System.out.println("id=" +x.getId()+ ";name=" +x.getName()+ ";price="+x.getPrice().orElseGet(()->BigDecimal.ZERO)+";category="+ x.getCategory()+";Display name="+x.getDisplayName());
            try{
                String noSuchField = x.getNonSuchFiled().orElseThrow(() -> new RuntimeException());
            }catch (RuntimeException re){
                System.err.println("Catch runtime exception here!"+re.getCause());
            }
        });

        List<ProductDetailReportDTO> dtoList = reportRepository.getProductDetailReportByMappingClass(1);
        assertTrue(dtoList.size() ==1);
        dtoList.stream().forEach(x -> {
            System.out.println("id=" +x.getId()+ ";name=" +x.getName()+ ";category="+ x.getCategory());
        });

    }
}