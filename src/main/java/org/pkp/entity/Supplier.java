package org.pkp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Suppliers", schema ="dbo" )
public class Supplier {

    @Id
    @NotBlank
    @Column(nullable = false, name="SupplierID")
    private int supplierID;

    @NotBlank
    @Column(nullable = false, name = "CompanyName" ,length = 40)
    private String companyName;

    @Column(nullable = true, name="ContactName",length = 30)
    private String contactName;

    @Column(nullable = true, name="ContactTitle",length = 30)
    private String contactTitle;

    @Column(nullable = true,name="Address",length = 60)
    private String address;

    @Column(nullable = true, name="City",length = 15)
    private String city;

    @Column(nullable = true, name="Region",length = 15)
    private String region;

    @Column(nullable = true, name="PostalCode",length = 10)
    private String postalCode;

    @Column(nullable = true, name="Country",length = 15)
    private String country;

    @Column(nullable = true, name="Phone",length = 24)
    private String phone;

    @Column(nullable = true, name="Fax",length = 24)
    private String fax;

    @Lob
    @Column(nullable = true, name="HomePage",length = 255)
    private String homePage;
}
