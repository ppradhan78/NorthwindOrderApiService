package org.pkp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Customers", schema ="dbo" )
public class Customer {
    @Id
    @NotBlank
    @Column(nullable = false,unique = true,length = 5, name="CustomerID")
    private String customerID;

    @NotBlank
    @Column(nullable = false, name = "CompanyName",length = 40)
    private String companyName;

    @Column(nullable = true, name="ContactName",length = 30)
    private String contactName;

    @Column(nullable = true, name="ContactTitle",length = 30)
    private String contactTitle	;

    @Column(nullable = true, name="Address",length = 60)
    private String address;

    @Column(nullable = true, name="City",length = 15)
    private String city;

    @Column(nullable = true, name="Region",length = 15)
    private String region;

    @Column(nullable = true,name="PostalCode",length = 10)
    private String postalCode;

    @Column(nullable = true, name="Country",length = 15)
    private String country;

    @Column(nullable = true, name="Phone",length = 24)
    private String phone;

    @Column(nullable = true, name="Fax",length = 24)
    private String fax;
}