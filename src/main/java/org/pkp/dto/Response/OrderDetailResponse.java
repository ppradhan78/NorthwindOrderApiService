package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDetailResponse {
    private Integer orderId;
    private Integer productID;
    private BigDecimal unitPrice;
    private Short  quantity;
    private Float  discount;

}