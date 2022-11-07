package com.nghi.BillingService.repository;

import com.nghi.BillingService.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    Billing findByBillId(Long BillId);
}
