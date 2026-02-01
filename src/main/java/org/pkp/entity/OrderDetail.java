package org.pkp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@ToString(exclude = "order")
//@Table(name = "Order Details", schema ="dbo" )


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order Details")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "ProductID")
    private Product product;

    @Schema(example = "14.00", description = "Unit price of the product")
    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Schema(example = "14.00", description = "Unit price of the product")
    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    @Column(nullable = false, name = "Quantity")
    private Short  quantity;

    @Column(nullable = false, name = "Discount")
    @NotNull(message = "Discount is required")
    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private Float  discount;
}
