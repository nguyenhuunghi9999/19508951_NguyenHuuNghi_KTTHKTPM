package com.nghi.BillingService.VO;

import com.nghi.BillingService.entity.Billing;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseTemplateVO {
    private Billing billing;
    private Passenger passenger;
}
