package org.pkp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "Shippers", schema ="dbo" )
public class Shipper {

    @Id
    @NotBlank
    @Column(name="ShipperID")
    private Integer shipperID;

    @NotBlank
    @Column(nullable = false, name = "CompanyName" ,length = 40)
    private String companyName;

    @Column(nullable = false, name="Phone",length = 24)
    private String phone;
}
