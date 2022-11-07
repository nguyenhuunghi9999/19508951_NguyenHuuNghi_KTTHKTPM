package com.nghi.BillingService.controller;

import com.nghi.BillingService.VO.ResponseTemplateVO;
import com.nghi.BillingService.entity.Billing;
import com.nghi.BillingService.service.BillingService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/billing")
@Slf4j
public class BillingController {

    @Autowired
    private BillingService billingService;

    int count=1;

    @PostMapping("/")
    public Billing saveBilling(@RequestBody Billing billing) {
        return billingService.saveBilling(billing);
    }

    @GetMapping("/{id}")
    @Retry(name = "PASSENGER-SERVICE")
    public ResponseTemplateVO getBillWithPassenger(@PathVariable("id") Long billId) {
        System.out.println("Retry method called " + count++ + " times at " + new Date());
        return billingService.getBillWithPassenger(billId);
    }
}
