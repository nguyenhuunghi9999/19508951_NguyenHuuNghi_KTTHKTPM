package com.nghi.BillingService.controller;

import com.nghi.BillingService.VO.ResponseTemplateVO;
import com.nghi.BillingService.entity.Billing;
import com.nghi.BillingService.service.BillingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
@Slf4j
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/")
    public Billing saveBilling(@RequestBody Billing billing) {
        return billingService.saveBilling(billing);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getBillWithPassenger(@PathVariable("id") Long billId) {
        return billingService.getBillWithPassenger(billId);
    }
}
