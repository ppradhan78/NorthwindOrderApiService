package org.pkp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Products", schema ="dbo" )
public class Product {

    @Id
    @NotBlank
    @Column(nullable = false, name="ProductID")
    private int productID;

    @Column(nullable = false, name="ProductName",length = 40)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SupplierID" ,nullable = false)
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CategoryID" ,nullable = false)
    private Category category;

    @Column(nullable = true, name="QuantityPerUnit",length = 20)
    private String quantityPerUnit;

    @Column(name = "UnitPrice", precision = 19, scale = 4)
    private BigDecimal unitPrice;


    @Column(nullable = true, name="UnitsInStock")
    private Short unitsInStock;


    @Column(nullable = false, name="UnitsOnOrder")
    private Short unitsOnOrder;


    @Column(nullable = false, name="ReorderLevel")
    private Short reorderLevel;


    @Column(nullable = false, name="Discontinued")
    private boolean discontinued;

    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails;

}
