package net.rod.demo.vendor.controller;

import io.swagger.annotations.ApiOperation;
import net.rod.demo.vendor.model.Vendor;
import net.rod.demo.vendor.model.VendorSearchCriteria;
import net.rod.demo.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Rod
 * @date 2021/1/11
 */
@RestController(value = "services manipulate vendor data ")
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired
    VendorService service;

    @GetMapping("/{vendorId}")
    @ApiOperation(value = "return a vendor entity by a given vendor id")
    public Vendor getVendor(@PathVariable("vendorId") Integer id) {
        System.out.println("id = [" + id + "]");
        return service.getVendorById(id);
    }

    @GetMapping("/protobuff/id/{id}")
    public Vendor getVendor4ProtocolBuffer(@PathVariable("id") Integer id ){
        return service.getVendorById(id);
    }

    @GetMapping("/q")
    public List<Vendor> getVendor(@RequestParam(name = "name") String name){
        VendorSearchCriteria vsc = new VendorSearchCriteria();
        vsc.setName(name);
        return service.getVendorByCriteria(vsc);
    }

    @PostMapping("")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return service.addVendor(vendor);
    }

    @PutMapping("")
    public Vendor updateVendor(@RequestBody Vendor vendor){
        try {
            return service.updateVendor(vendor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendor;
    }
}
