package org.pkp.dto.v2.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailRequest {

    @NotNull
    private Integer orderId;

    @NotNull
    private Integer productId;

    @NotNull
    private BigDecimal unitPrice;

    @NotNull
    private Integer quantity;

    private Float discount;
}
