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

    @NotNull(message = "OrderId is required")
    private Integer orderId;

    @NotNull(message = "ProductId is required")
    private Integer productId;

    @NotNull(message = "UnitPrice is required")
    @Positive(message = "UnitPrice must be greater than 0")
    private BigDecimal unitPrice;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    private Short quantity;

    @NotNull(message = "Discount is required")
    @DecimalMin(value = "0.0", message = "Discount must be >= 0")
    @DecimalMax(value = "1.0", message = "Discount must be <= 1")
    private Float discount;
}

