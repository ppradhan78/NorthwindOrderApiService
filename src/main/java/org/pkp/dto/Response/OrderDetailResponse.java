package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDetailResponse {
    private Integer orderId;
    private Integer productID;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private CustomerResponse customer;

}