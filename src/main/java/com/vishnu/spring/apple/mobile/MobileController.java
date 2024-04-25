package com.vishnu.spring.apple.mobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "api/v1/mobile")
public class MobileController {

    private final MobileService mobileService;

    @Autowired
    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @GetMapping
    public List<Mobile> getMobiles() {
        return mobileService.getMobiles();
    }

    @GetMapping(path = "id/{mobileId}")
    public Mobile getMobile(@PathVariable("mobileId") Long mobileId) {
        return mobileService.getMobile(mobileId);
    }

    @GetMapping(path = "sku/{mobileSKU}")
    public Mobile getMobile(@PathVariable("mobileSKU") String mobileSKU) {
        return mobileService.getMobile(mobileSKU);
    }

    @PostMapping
    public void registerNewMobile(@RequestBody Mobile mobile) {
        mobileService.addNewMobile(mobile);
    }

    @DeleteMapping(path = "id/{mobileId}")
    public void deleteMobile(@PathVariable("mobileId") Long mobileId) {
        mobileService.deleteMobile(mobileId);
    }

    @DeleteMapping(path = "sku/{mobileSKU}")
    public void deleteMobile(@PathVariable("mobileSKU") String mobileSKU) {
        mobileService.deleteMobile(mobileSKU);
    }

    @PutMapping(path = "id/{mobileId}")
    public void updateMobile(@PathVariable("mobileId") Long mobileId,
            @RequestBody Mobile mobile) {
        mobileService.updateMobile(mobileId, mobile);
    }

    @PutMapping(path = "sku/{mobileSKU}")
    public void updateMobile(@PathVariable("mobileSKU") String mobileSKU,
            @RequestBody Mobile mobile) {
        mobileService.updateMobile(mobileSKU, mobile);
    }

}