package org.pkp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Orders", schema = "dbo")
public class Order {

    @Id
    @Column(name = "OrderID", nullable = false)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer orderID;

    @ManyToOne(fetch = FetchType.LAZY)
    //@Column(name = "CustomerID")
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    //@Column(name = "EmployeeID")
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "RequiredDate")
    private LocalDate requiredDate;

    @Column(name = "ShippedDate")
    private LocalDate shippedDate;

    @Column(name = "ShipVia")
    private Integer shipVia;

    @Column(name = "Freight")
    private BigDecimal freight;

    @Column(name = "ShipName")
    private String shipName;

    @Column(name = "ShipAddress")
    private String shipAddress;

    @Column(name = "ShipCity")
    private String shipCity;

    @Column(name = "ShipRegion")
    private String shipRegion;

    @Column(name = "ShipPostalCode")
    private String shipPostalCode;

    @Column(name = "ShipCountry")
    private String shipCountry;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;
}