package com.nghi.BillingService.service;

import com.nghi.BillingService.VO.Passenger;
import com.nghi.BillingService.VO.ResponseTemplateVO;
import com.nghi.BillingService.entity.Billing;
import com.nghi.BillingService.repository.BillingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Billing saveUser(Billing bill) {
        return billingRepository.save(bill);
    }

    public ResponseTemplateVO getBillWithPassenger(Long billId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Billing bill = billingRepository.findByBillId(billId);

        Passenger passenger =
                restTemplate.getForObject("http://localhost:9001/api/department/" + bill.getPassengerId()
                        ,Passenger.class);

        vo.setBilling(bill);
        vo.setPassenger(passenger);

        return  vo;
    }


}
