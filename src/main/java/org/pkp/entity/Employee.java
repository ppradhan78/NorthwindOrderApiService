package org.pkp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "Employees", schema ="dbo" )
public class Employee {

    @Id
    //@NotBlank
    @Column(name="EmployeeID")
    private Integer employeeID;

    @NotBlank
    @Column(nullable = false, name = "LastName" ,length = 20)
    private String lastName;

    @Column(nullable = false, name="FirstName",length = 10)
    private String firstName;

    @Column(nullable = true, name="Title",length = 30)
    private String title	;

    @Column(nullable = true, name="TitleOfCourtesy",length = 25)
    private String titleOfCourtesy;

    @Column(nullable = true, name="BirthDate")
    private LocalDate birthDate;

    @Column(nullable = true, name="HireDate")
    private LocalDate hireDate;

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

    @Column(nullable = true, name="HomePhone",length = 24)
    private String homePhone;

    @Column(nullable = true, name="Extension",length = 4)
    private String extension;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = true, name="Photo")
    private byte[] photo;

    @Lob
    @Column(nullable = true, name="Notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ReportsTo" ,nullable = false)
    private Employee manager;

    @Column(nullable = true, name="PhotoPath",length = 255)
    private String photoPath;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<Employee> subordinates;

}
