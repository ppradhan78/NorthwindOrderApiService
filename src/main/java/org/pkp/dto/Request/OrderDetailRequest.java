package org.pkp.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailRequest {

    @NotNull
    private Integer productId;

    @NotNull
    private BigDecimal unitPrice;

    @NotNull
    private Integer quantity;

    private Float discount;
}
