package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDetailResponse {

    private Integer productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private Float discount;
}