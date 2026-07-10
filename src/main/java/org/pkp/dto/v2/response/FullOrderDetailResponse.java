package org.pkp.dto.v2.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FullOrderDetailResponse {

    private Integer productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private Float discount;
}