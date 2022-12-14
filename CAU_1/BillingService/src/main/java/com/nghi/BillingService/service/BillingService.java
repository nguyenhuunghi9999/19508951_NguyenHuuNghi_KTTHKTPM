package com.nghi.BillingService.service;

import com.nghi.BillingService.VO.Passenger;
import com.nghi.BillingService.VO.ResponseTemplateVO;
import com.nghi.BillingService.entity.Billing;
import com.nghi.BillingService.repository.BillingRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Slf4j
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Billing saveBilling(Billing bill) {
        return billingRepository.save(bill);
    }
    public BillingService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    int count=1;
    @Retry(name = "PassengerService")
    public ResponseTemplateVO getBillWithPassenger(Long billId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Billing bill = billingRepository.findByBillId(billId);
        System.out.println("Retry method called " + count++ + " times at " + new Date());
        Passenger passenger =
                restTemplate.getForObject("http://localhost:9005/passenger/" + bill.getPassengerId()
                        ,Passenger.class);

        vo.setBilling(bill);
        vo.setPassenger(passenger);

        return  vo;
    }


}
