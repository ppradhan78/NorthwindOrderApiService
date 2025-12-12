package org.pkp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @NotBlank
    @Column(nullable = false, name="OrderID")
    private int orderID;

    @Column(nullable = false, name="CustomerID")
    private String customerID;

    @Column(nullable = false, name = "EmployeeID")
    private int employeeID;

    @Column(nullable = true, name="OrderDate")
    private LocalDate orderDate;

    @Column(nullable = true, name="RequiredDate")
    private LocalDate  requiredDate;

    @Column(nullable = true, name="ShippedDate")
    private LocalDate  shippedDate;

    @Column(nullable = true, name="ShipVia")
    private int shipVia	;

    @Column(nullable = true, name="Freight")
    private int freight;

    @Column(nullable = true, name="ShipName")
    private String shipName;

    @Column(nullable = true, name="ShipAddress")
    private String shipAddress;

    @Column(nullable = true,name="ShipCity")
    private String shipCity;

    @Column(nullable = true, name="ShipRegion")
    private String shipRegion;

    @Column(nullable = true, name="ShipPostalCode")
    private String shipPostalCode;

    @Column(nullable = true, name="ShipCountry")
    private String shipCountry;
    
}
