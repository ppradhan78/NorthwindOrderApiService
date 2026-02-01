package org.pkp.entity;

import jakarta.persistence.*;
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
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "ProductID")
    private Product product;

//    @Id
//    @NotBlank
//    @Column(nullable = false, name="OrderID")
//    private int orderID;
//
//    @Id
//    @NotBlank
//    @Column(nullable = false, name="ProductID")
//    private int productID;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false, name = "Quantity")
    private Short  quantity;

    @Column(nullable = false, name = "Discount")
    private Float  discount;
}
